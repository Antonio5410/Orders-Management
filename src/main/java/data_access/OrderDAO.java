package data_access;

import conection.ConnectionFactory;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public static void addOrder(int NROrder, int IDClient, int IDProduct, float cantitate) {
        String insertStatementString = "INSERT INTO depozit.order (NROrder, IDClient, IDProduct, cantitate) VALUES (?, ?, ?, ?);";
        Connection dbConnection = null;
        PreparedStatement insertStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            insertStatement = dbConnection.prepareStatement(insertStatementString);
            insertStatement.setInt(1, NROrder);
            insertStatement.setInt(2, IDClient);
            insertStatement.setInt(3, IDProduct);
            insertStatement.setFloat(4, cantitate);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static Order findById(int NROrder) {
        String findStatementString = "SELECT * FROM depozit.order WHERE NROrder = ?;";
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Order order = null;

        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1, NROrder);
            rs = findStatement.executeQuery();

            if (rs.next()) {
                int IDClient = rs.getInt("IDClient");
                int IDProduct = rs.getInt("IDProduct");
                float cantitate = rs.getFloat("cantitate");

                order = new Order(NROrder, IDClient, IDProduct, cantitate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return order;
    }

    public static void updateOrder(int NROrder, int IDClient, int IDProduct, float cantitate) {
        String updateStatementString = "UPDATE depozit.order SET IDClient = ?, IDProduct = ?, cantitate = ? WHERE NROrder = ?;";
        Connection dbConnection = null;
        PreparedStatement updateStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            updateStatement = dbConnection.prepareStatement(updateStatementString);
            updateStatement.setInt(1, IDClient);
            updateStatement.setInt(2, IDProduct);
            updateStatement.setFloat(3, cantitate);
            updateStatement.setInt(4, NROrder);
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static void deleteOrder(int NROrder) {
        String deleteStatementString = "DELETE FROM depozit.order WHERE NROrder = ?;";
        Connection dbConnection = null;
        PreparedStatement deleteStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setInt(1, NROrder);
            deleteStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static List<Order> getAllOrders() {
        String getAllStatementString = "SELECT * FROM depozit.order;";
        Connection dbConnection = null;
        PreparedStatement getAllStatement = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<>();

        try {
            dbConnection = ConnectionFactory.getConnection();
            getAllStatement = dbConnection.prepareStatement(getAllStatementString);
            rs = getAllStatement.executeQuery();

            while (rs.next()) {
                int NROrder = rs.getInt("NROrder");
                int IDClient = rs.getInt("IDClient");
                int IDProduct = rs.getInt("IDProduct");
                float cantitate = rs.getFloat("cantitate");
                orders.add(new Order(NROrder, IDClient, IDProduct, cantitate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(getAllStatement);
            ConnectionFactory.close(dbConnection);
        }

        return orders;
    }
}

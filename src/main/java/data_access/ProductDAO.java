package data_access;

import conection.ConnectionFactory;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static void addProduct(int IDProduct, String ProdName, float ProdPrice, int stoc) {
        String insertStatementString = "INSERT INTO depozit.product (IDproduct, ProdName, ProdPrice, stoc) VALUES (?, ?, ?, ?);";
        Connection dbConnection = null;
        PreparedStatement insertStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            insertStatement = dbConnection.prepareStatement(insertStatementString);
            insertStatement.setInt(1, IDProduct);
            insertStatement.setString(2, ProdName);
            insertStatement.setFloat(3, ProdPrice);
            insertStatement.setInt(4, stoc);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static Product findById(int IDProduct) {
        String findStatementString = "select * from depozit.product where IDproduct = ?;";
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Product prod = null;

        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1, IDProduct);
            rs = findStatement.executeQuery();

            if (rs.next()) {
                int IDproduct = rs.getInt("IDproduct");
                String ProdName = rs.getString("ProdName");
                float ProdPrice = rs.getFloat("ProdPrice");
                int Stoc = rs.getInt("Stoc");

                prod = new Product(IDproduct, ProdName, ProdPrice, Stoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return prod;
    }

    public static void updateProduct(int IDProduct, String ProdName, float ProdPrice, int stoc) {
        String updateStatementString = "UPDATE depozit.product SET ProdName = ?, ProdPrice = ?, stoc = ? WHERE IDproduct = ?;";
        Connection dbConnection = null;
        PreparedStatement updateStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            updateStatement = dbConnection.prepareStatement(updateStatementString);
            updateStatement.setString(1, ProdName);
            updateStatement.setFloat(2, ProdPrice);
            updateStatement.setInt(3, stoc);
            updateStatement.setInt(4, IDProduct);
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static void deleteProduct(int IDProduct) {
        String deleteStatementString = "DELETE FROM depozit.product WHERE IDproduct = ?;";
        Connection dbConnection = null;
        PreparedStatement deleteStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setInt(1, IDProduct);
            deleteStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static List<Product> getAllProducts() {
        String getAllStatementString = "SELECT * FROM depozit.product;";
        Connection dbConnection = null;
        PreparedStatement getAllStatement = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();

        try {
            dbConnection = ConnectionFactory.getConnection();
            getAllStatement = dbConnection.prepareStatement(getAllStatementString);
            rs = getAllStatement.executeQuery();

            while (rs.next()) {
                int IDproduct = rs.getInt("IDproduct");
                String ProdName = rs.getString("ProdName");
                float ProdPrice = rs.getFloat("ProdPrice");
                int Stoc = rs.getInt("Stoc");
                products.add(new Product(IDproduct, ProdName, ProdPrice, Stoc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(getAllStatement);
            ConnectionFactory.close(dbConnection);
        }

        return products;
    }
}

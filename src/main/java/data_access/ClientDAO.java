package data_access;

import conection.ConnectionFactory;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public static void addClient(int id, String nume, String adresa, int age) {
        String addClientQuery = "INSERT INTO depozit.client (IDclient, Nume, Adresa, Age) VALUES (?, ?, ?, ?);";
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            preparedStatement = dbConnection.prepareStatement(addClientQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nume);
            preparedStatement.setString(3, adresa);
            preparedStatement.setInt(4, age);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static Client findById(int IDclient) {
        String findClientQuery = "SELECT * FROM depozit.client WHERE IDclient = ?";
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Client client = null;

        try {
            preparedStatement = dbConnection.prepareStatement(findClientQuery);
            preparedStatement.setInt(1, IDclient);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String nume = rs.getString("Nume");
                String adresa = rs.getString("Adresa");
                int age = rs.getInt("Age");

                client = new Client(IDclient, nume, adresa, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(dbConnection);
        }

        return client;
    }

    public static void updateClient(int id, String nume, String adresa, int age) {
        String updateClientQuery = "UPDATE depozit.client SET Nume = ?, Adresa = ?, Age = ? WHERE IDclient = ?;";
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            preparedStatement = dbConnection.prepareStatement(updateClientQuery);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, adresa);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static void deleteClient(int id) {
        String deleteClientQuery = "DELETE FROM depozit.client WHERE IDclient = ?;";
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            preparedStatement = dbConnection.prepareStatement(deleteClientQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static List<Client> getAllClients() {
        String getAllClientsQuery = "SELECT * FROM depozit.client;";
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Client> clients = new ArrayList<>();

        try {
            dbConnection = ConnectionFactory.getConnection();
            preparedStatement = dbConnection.prepareStatement(getAllClientsQuery);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("IDclient");
                String nume = rs.getString("Nume");
                String adresa = rs.getString("Adresa");
                int age = rs.getInt("Age");
                clients.add(new Client(id, nume, adresa, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(dbConnection);
        }

        return clients;
    }
}

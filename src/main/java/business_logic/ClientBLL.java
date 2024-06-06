package business_logic;

import java.util.List;
import model.Client;
import data_access.ClientDAO;

public class ClientBLL {

    public static void addClient(int id, String nume, String adresa, int age) throws Exception {
        // Example of validation logic
        if (nume == null || nume.trim().isEmpty()) {
            throw new Exception("Client name cannot be empty.");
        }
        if (age <= 0) {
            throw new Exception("Client age must be a positive number.");
        }

        // If validation passes, call the DAO method
        ClientDAO.addClient(id, nume, adresa, age);
    }

    public static Client findById(int id) throws Exception {
        // Example of business rule: Check if ID is valid
        if (id <= 0) {
            throw new Exception("Client ID must be a positive number.");
        }

        // Call the DAO method to fetch the client
        return ClientDAO.findById(id);
    }

    public static void updateClient(int id, String nume, String adresa, int age) throws Exception {
        // Example of validation logic
        if (id <= 0) {
            throw new Exception("Client ID must be a positive number.");
        }
        if (nume == null || nume.trim().isEmpty()) {
            throw new Exception("Client name cannot be empty.");
        }
        if (age <= 0) {
            throw new Exception("Client age must be a positive number.");
        }

        // Call the DAO method to update the client
        ClientDAO.updateClient(id, nume, adresa, age);
    }

    public static void deleteClient(int id) throws Exception {
        // Example of business rule: Check if ID is valid
        if (id <= 0) {
            throw new Exception("Client ID must be a positive number.");
        }

        // Call the DAO method to delete the client
        ClientDAO.deleteClient(id);
    }

    public static List<Client> getAllClients() {
        // Call the DAO method to fetch all clients
        return ClientDAO.getAllClients();
    }
}

package presentation;

import model.Client;
import business_logic.ClientBLL;
import presentation.ClientOperationsWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClientController {
    private ClientOperationsWindow clientOperationsWindow;

    public ClientController(ClientOperationsWindow clientOperationsWindow) {
        this.clientOperationsWindow = clientOperationsWindow;
        initController();
    }

    private void initController() {
        clientOperationsWindow.getAddButton().addActionListener(e -> addClient());
        clientOperationsWindow.getEditButton().addActionListener(e -> editClient());
        clientOperationsWindow.getDeleteButton().addActionListener(e -> deleteClient());
        clientOperationsWindow.getViewAllButton().addActionListener(e -> viewAllClients());
    }

    private void addClient() {
        try {
            int id = Integer.parseInt(clientOperationsWindow.getIdField().getText());
            String name = clientOperationsWindow.getNameField().getText();
            String address = clientOperationsWindow.getAddressField().getText();
            int age = Integer.parseInt(clientOperationsWindow.getAgeField().getText());
            ClientBLL.addClient(id, name, address, age);
            JOptionPane.showMessageDialog(clientOperationsWindow, "Client added successfully!");
            viewAllClients();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(clientOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editClient() {
        try {
            int id = Integer.parseInt(clientOperationsWindow.getIdField().getText());
            String name = clientOperationsWindow.getNameField().getText();
            String address = clientOperationsWindow.getAddressField().getText();
            int age = Integer.parseInt(clientOperationsWindow.getAgeField().getText());
            ClientBLL.updateClient(id, name, address, age);
            JOptionPane.showMessageDialog(clientOperationsWindow, "Client updated successfully!");
            viewAllClients();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(clientOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteClient() {
        try {
            int id = Integer.parseInt(clientOperationsWindow.getIdField().getText());
            Client client = ClientBLL.findById(id);
            if (client == null) {
                JOptionPane.showMessageDialog(clientOperationsWindow, "Client with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ClientBLL.deleteClient(id);
                JOptionPane.showMessageDialog(clientOperationsWindow, "Client deleted successfully!");
                viewAllClients();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(clientOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAllClients() {
        try {
            List<Client> clients = ClientBLL.getAllClients();
            DefaultTableModel model = (DefaultTableModel) clientOperationsWindow.getClientTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Client client : clients) {
                model.addRow(new Object[]{client.getIDclient(), client.getNume(), client.getAdresa(), client.getAge()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(clientOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

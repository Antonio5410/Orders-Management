package presentation;

import model.Client;
import business_logic.ClientBLL;
import model.Order;
import business_logic.OrderBLL;
import model.Product;
import business_logic.ProductBLL;
import presentation.OrderCreationWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class OrderController {
    private OrderCreationWindow orderCreationWindow;

    public OrderController(OrderCreationWindow orderCreationWindow) {
        this.orderCreationWindow = orderCreationWindow;
        initController();
    }

    private void initController() {
        orderCreationWindow.getCreateOrderButton().addActionListener(e -> createOrder());
        orderCreationWindow.getViewAllButton().addActionListener(e -> viewAllOrders());
        loadClients();
        loadProducts();
        loadClientTable();
        loadProductTable();
    }

    private void createOrder() {
        try {
            int clientId = (int) orderCreationWindow.getClientComboBox().getSelectedItem();
            int productId = (int) orderCreationWindow.getProductComboBox().getSelectedItem();
            float quantity = Float.parseFloat(orderCreationWindow.getQuantityField().getText());

            // Generate the next order number
            int orderNumber = OrderBLL.generateOrderNumber();
            OrderBLL.addOrder(orderNumber, clientId, productId, quantity);

            JOptionPane.showMessageDialog(orderCreationWindow, "Order created successfully!");
            viewAllOrders();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(orderCreationWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAllOrders() {
        try {
            List<Order> orders = OrderBLL.getAllOrders();
            DefaultTableModel model = (DefaultTableModel) orderCreationWindow.getOrderTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Order order : orders) {
                model.addRow(new Object[]{order.getNROrder(), order.getIDClient(), order.getIDProduct(), order.getCantitate()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(orderCreationWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadClients() {
        // Load clients from the ClientBLL and add them to the clientComboBox
        try {
            List<Client> clients = ClientBLL.getAllClients();
            for (Client client : clients) {
                orderCreationWindow.getClientComboBox().addItem(client.getIDclient());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(orderCreationWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadProducts() {
        // Load products from the ProductBLL and add them to the productComboBox
        try {
            List<Product> products = ProductBLL.getAllProducts();
            for (Product product : products) {
                orderCreationWindow.getProductComboBox().addItem(product.getIDProduct());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(orderCreationWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadClientTable() {
        try {
            List<Client> clients = ClientBLL.getAllClients();
            DefaultTableModel model = (DefaultTableModel) orderCreationWindow.getClientTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Client client : clients) {
                model.addRow(new Object[]{client.getIDclient(), client.getNume(), client.getAdresa(), client.getAge()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(orderCreationWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadProductTable() {
        try {
            List<Product> products = ProductBLL.getAllProducts();
            DefaultTableModel model = (DefaultTableModel) orderCreationWindow.getProductTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Product product : products) {
                model.addRow(new Object[]{product.getIDProduct(), product.getProdName(), product.getProdPrice(), product.getStoc()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(orderCreationWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package presentation;


import model.Client;
import business_logic.ClientBLL;
import model.Order;
import business_logic.OrderBLL;
import model.Product;
import business_logic.ProductBLL;
import presentation.ViewTablesWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewTablesController {
    private ViewTablesWindow viewTablesWindow;

    public ViewTablesController(ViewTablesWindow viewTablesWindow) {
        this.viewTablesWindow = viewTablesWindow;
        initController();
    }

    private void initController() {
        viewTablesWindow.getViewClientsButton().addActionListener(e -> viewAllClients());
        viewTablesWindow.getViewProductsButton().addActionListener(e -> viewAllProducts());
        viewTablesWindow.getViewOrdersButton().addActionListener(e -> viewAllOrders());
    }

    private void viewAllClients() {
        try {
            List<Client> clients = ClientBLL.getAllClients();
            DefaultTableModel model = (DefaultTableModel) viewTablesWindow.getClientTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Client client : clients) {
                model.addRow(new Object[]{client.getIDclient(), client.getNume(), client.getAdresa(), client.getAge()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(viewTablesWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAllProducts() {
        try {
            List<Product> products = ProductBLL.getAllProducts();
            DefaultTableModel model = (DefaultTableModel) viewTablesWindow.getProductTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Product product : products) {
                model.addRow(new Object[]{product.getIDProduct(), product.getProdName(), product.getProdPrice(), product.getStoc()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(viewTablesWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAllOrders() {
        try {
            List<Order> orders = OrderBLL.getAllOrders();
            DefaultTableModel model = (DefaultTableModel) viewTablesWindow.getOrderTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Order order : orders) {
                model.addRow(new Object[]{order.getNROrder(), order.getIDClient(), order.getIDProduct(), order.getCantitate()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(viewTablesWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


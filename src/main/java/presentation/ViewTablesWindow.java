package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewTablesWindow extends JFrame {
    private JFrame parent;
    private JTable clientTable;
    private JTable productTable;
    private JTable orderTable;
    private JButton viewClientsButton;
    private JButton viewProductsButton;
    private JButton viewOrdersButton;

    public ViewTablesWindow(JFrame parent) {
        this.parent = parent;
        setTitle("View Tables");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            parent.setVisible(true);
        });

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));

        viewClientsButton = new JButton("View Clients");
        viewProductsButton = new JButton("View Products");
        viewOrdersButton = new JButton("View Orders");

        buttonPanel.add(backButton);
        buttonPanel.add(viewClientsButton);
        buttonPanel.add(viewProductsButton);
        buttonPanel.add(viewOrdersButton);

        // Tables for displaying data
        clientTable = new JTable(new DefaultTableModel(new String[]{"ID", "Name", "Address", "Age"}, 0));
        productTable = new JTable(new DefaultTableModel(new String[]{"ID", "Name", "Price", "Stock"}, 0));
        orderTable = new JTable(new DefaultTableModel(new String[]{"Order Number", "Client ID", "Product ID", "Quantity"}, 0));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Clients", new JScrollPane(clientTable));
        tabbedPane.addTab("Products", new JScrollPane(productTable));
        tabbedPane.addTab("Orders", new JScrollPane(orderTable));

        add(buttonPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

        parent.setVisible(false);
        setVisible(true);
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public JTable getProductTable() {
        return productTable;
    }

    public JTable getOrderTable() {
        return orderTable;
    }

    public JButton getViewClientsButton() {
        return viewClientsButton;
    }

    public JButton getViewProductsButton() {
        return viewProductsButton;
    }

    public JButton getViewOrdersButton() {
        return viewOrdersButton;
    }
}

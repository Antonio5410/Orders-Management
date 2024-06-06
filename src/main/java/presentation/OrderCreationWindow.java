package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderCreationWindow extends JFrame {
    private JFrame parent;
    private JComboBox<Integer> clientComboBox;
    private JComboBox<Integer> productComboBox;
    private JTextField quantityField;
    private JTable orderTable;
    private JTable clientTable;
    private JTable productTable;
    private JButton createOrderButton;
    private JButton viewAllButton;

    public OrderCreationWindow(JFrame parent) {
        this.parent = parent;
        setTitle("Create Product Orders");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // This will hide the window but keep the application running
        setLayout(new BorderLayout());

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            parent.setVisible(true);
        });

        // JTable for displaying orders
        orderTable = new JTable(new DefaultTableModel(new String[]{"Order Number", "Client ID", "Product ID", "Quantity"}, 0));
        JScrollPane orderScrollPane = new JScrollPane(orderTable);

        // JTable for displaying clients
        clientTable = new JTable(new DefaultTableModel(new String[]{"Client ID", "Name", "Address", "Age"}, 0));
        JScrollPane clientScrollPane = new JScrollPane(clientTable);

        // JTable for displaying products
        productTable = new JTable(new DefaultTableModel(new String[]{"Product ID", "Name", "Price", "Stock"}, 0));
        JScrollPane productScrollPane = new JScrollPane(productTable);

        // Panel for order creation
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        clientComboBox = new JComboBox<>();
        productComboBox = new JComboBox<>();
        quantityField = new JTextField(10);

        createOrderButton = new JButton("Create Order");
        viewAllButton = new JButton("View All Orders");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Client:"), gbc);

        gbc.gridx = 1;
        panel.add(clientComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Product:"), gbc);

        gbc.gridx = 1;
        panel.add(productComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Quantity:"), gbc);

        gbc.gridx = 1;
        panel.add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(createOrderButton, gbc);

        gbc.gridy = 4;
        panel.add(viewAllButton, gbc);

        // Adding tables to a separate panel
        JPanel tablePanel = new JPanel(new GridLayout(1, 3, 10, 10));
        tablePanel.add(new JScrollPane(clientTable));
        tablePanel.add(new JScrollPane(productTable));
        tablePanel.add(new JScrollPane(orderTable));

        add(backButton, BorderLayout.NORTH);
        add(panel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);

        parent.setVisible(false);
        setVisible(true);
    }

    public JComboBox<Integer> getClientComboBox() {
        return clientComboBox;
    }

    public JComboBox<Integer> getProductComboBox() {
        return productComboBox;
    }

    public JTextField getQuantityField() {
        return quantityField;
    }

    public JTable getOrderTable() {
        return orderTable;
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public JTable getProductTable() {
        return productTable;
    }

    public JButton getCreateOrderButton() {
        return createOrderButton;
    }

    public JButton getViewAllButton() {
        return viewAllButton;
    }
}

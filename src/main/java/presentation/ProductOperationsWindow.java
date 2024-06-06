package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductOperationsWindow extends JFrame {
    private JFrame parent;
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField stockField;
    private JTable productTable;
    private JButton addButton;
    private JButton editButton;
    private JButton increaseStockButton;
    private JButton viewAllButton;

    public ProductOperationsWindow(JFrame parent) {
        this.parent = parent;
        setTitle("Product Operations");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            parent.setVisible(true);
        });

        // JTable for displaying products
        productTable = new JTable(new DefaultTableModel(new String[]{"ID", "Name", "Price", "Stock"}, 0));
        JScrollPane scrollPane = new JScrollPane(productTable);

        // Panel for product operations
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        idField = new JTextField(5);
        nameField = new JTextField(10);
        priceField = new JTextField(10);
        stockField = new JTextField(5);

        addButton = new JButton("Add Product");
        editButton = new JButton("Edit Product");
        increaseStockButton = new JButton("Increase Stock");
        viewAllButton = new JButton("View All Products");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        panel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Stock:"), gbc);
        gbc.gridx = 1;
        panel.add(stockField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(addButton, gbc);

        gbc.gridy = 5;
        panel.add(editButton, gbc);

        gbc.gridy = 6;
        panel.add(increaseStockButton, gbc);

        gbc.gridy = 7;
        panel.add(viewAllButton, gbc);

        add(backButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        parent.setVisible(false);
        setVisible(true);
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JTextField getStockField() {
        return stockField;
    }

    public JTable getProductTable() {
        return productTable;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getIncreaseStockButton() {
        return increaseStockButton;
    }

    public JButton getViewAllButton() {
        return viewAllButton;
    }
}

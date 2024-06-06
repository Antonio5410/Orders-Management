package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClientOperationsWindow extends JFrame {
    private JFrame parent;
    private JTextField idField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField ageField;
    private JTable clientTable;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton viewAllButton;

    public ClientOperationsWindow(JFrame parent) {
        this.parent = parent;
        setTitle("Client Operations");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            parent.setVisible(true);
        });

        // JTable for displaying clients
        clientTable = new JTable(new DefaultTableModel(new String[]{"ID", "Name", "Address", "Age"}, 0));
        JScrollPane scrollPane = new JScrollPane(clientTable);

        // Panel for client operations
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        idField = new JTextField(5);
        nameField = new JTextField(10);
        addressField = new JTextField(10);
        ageField = new JTextField(5);

        addButton = new JButton("Add Client");
        editButton = new JButton("Edit Client");
        deleteButton = new JButton("Delete Client");
        viewAllButton = new JButton("View All Clients");

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
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        panel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        panel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(addButton, gbc);

        gbc.gridy = 5;
        panel.add(editButton, gbc);

        gbc.gridy = 6;
        panel.add(deleteButton, gbc);

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

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getViewAllButton() {
        return viewAllButton;
    }
}

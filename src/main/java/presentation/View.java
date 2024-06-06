package presentation;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        setTitle("Main Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton clientOperationsButton = new JButton("Client Operations");
        clientOperationsButton.addActionListener(e -> {
            ClientOperationsWindow clientOperationsWindow = new ClientOperationsWindow(this);
            new ClientController(clientOperationsWindow);
        });

        JButton orderCreationButton = new JButton("Create Product Orders");
        orderCreationButton.addActionListener(e -> {
            OrderCreationWindow orderCreationWindow = new OrderCreationWindow(this);
            new OrderController(orderCreationWindow); // Assuming OrderController is created
        });

        JButton productOperationsButton = new JButton("Product Operations");
        productOperationsButton.addActionListener(e -> {
            ProductOperationsWindow productOperationsWindow = new ProductOperationsWindow(this);
            new ProductController(productOperationsWindow); // Assuming ProductController is created
        });

        JButton viewTablesButton = new JButton("View Tables");
        viewTablesButton.addActionListener(e -> {
            ViewTablesWindow viewTablesWindow = new ViewTablesWindow(this);
            new ViewTablesController(viewTablesWindow); // Assuming ViewTablesController is created
        });

        add(clientOperationsButton);
        add(orderCreationButton);
        add(productOperationsButton);
        add(viewTablesButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(View::new);
    }
}

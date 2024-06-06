package business_logic;

import data_access.*;
import model.*;

import java.util.List;

public class OrderBLL {

    public static void addOrder(int NROrder, int IDClient, int IDProduct, float cantitate) throws Exception {
        // Example of validation logic
        if (IDClient <= 0) {
            throw new Exception("Client ID must be a positive number.");
        }
        if (IDProduct <= 0) {
            throw new Exception("Product ID must be a positive number.");
        }
        if (cantitate <= 0) {
            throw new Exception("Quantity must be a positive number.");
        }

        // Check if the product exists and has enough stock
        Product product = ProductDAO.findById(IDProduct);
        if (product == null) {
            throw new Exception("Product not found.");
        }
        if (product.getStoc() < cantitate) {
            throw new Exception("Not enough stock for the product.");
        }

        // Reduce the product stock
        ProductDAO.updateProduct(IDProduct, product.getProdName(), product.getProdPrice(), (int) (product.getStoc() - cantitate));

        // If validation passes, call the DAO method
        OrderDAO.addOrder(NROrder, IDClient, IDProduct, cantitate);
    }

    public static Order findById(int NROrder) throws Exception {
        // Example of business rule: Check if order number is valid
        if (NROrder <= 0) {
            throw new Exception("Order number must be a positive number.");
        }

        // Call the DAO method to fetch the order
        return OrderDAO.findById(NROrder);
    }

    public static void updateOrder(int NROrder, int IDClient, int IDProduct, float cantitate) throws Exception {
        // Example of validation logic
        if (NROrder <= 0) {
            throw new Exception("Order number must be a positive number.");
        }
        if (IDClient <= 0) {
            throw new Exception("Client ID must be a positive number.");
        }
        if (IDProduct <= 0) {
            throw new Exception("Product ID must be a positive number.");
        }
        if (cantitate <= 0) {
            throw new Exception("Quantity must be a positive number.");
        }

        // Check if the product exists and has enough stock
        Product product = ProductDAO.findById(IDProduct);
        if (product == null) {
            throw new Exception("Product not found.");
        }
        if (product.getStoc() < cantitate) {
            throw new Exception("Not enough stock for the product.");
        }

        // If validation passes, call the DAO method
        OrderDAO.updateOrder(NROrder, IDClient, IDProduct, cantitate);
    }

    public static void deleteOrder(int NROrder) throws Exception {
        // Example of business rule: Check if order number is valid
        if (NROrder <= 0) {
            throw new Exception("Order number must be a positive number.");
        }

        // Call the DAO method to delete the order
        OrderDAO.deleteOrder(NROrder);
    }

    public static List<Order> getAllOrders() {
        // Call the DAO method to fetch all orders
        return OrderDAO.getAllOrders();
    }

    public static int generateOrderNumber() throws Exception {
        List<Order> allOrders = getAllOrders();
        int maxOrderNumber = 0;
        for (Order order : allOrders) {
            if (order.getNROrder() > maxOrderNumber) {
                maxOrderNumber = order.getNROrder();
            }
        }
        return maxOrderNumber + 1;
    }
}

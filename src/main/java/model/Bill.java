package model;

import java.util.List;

public record Bill(int orderNumber, int clientId, List<OrderItem> orderItems, double totalAmount) {

    public Bill(int orderNumber, int clientId, List<OrderItem> orderItems) {
        this(orderNumber, clientId, orderItems, calculateTotalAmount(orderItems));
    }

    private static double calculateTotalAmount(List<OrderItem> orderItems) {
        return orderItems.stream().mapToDouble(item -> item.productPrice() * item.quantity()).sum();
    }

    public void printBill() {
        System.out.println("Bill for Order #" + orderNumber);
        System.out.println("Client ID: " + clientId);
        System.out.println("=================================");
        for (OrderItem item : orderItems) {
            System.out.printf("Product ID: %d, Name: %s, Quantity: %.2f, Price: %.2f, Total: %.2f%n",
                    item.productId(), item.productName(), item.quantity(),
                    item.productPrice(), item.productPrice() * item.quantity());
        }
        System.out.println("=================================");
        System.out.printf("Total Amount: %.2f%n", totalAmount);
    }
}

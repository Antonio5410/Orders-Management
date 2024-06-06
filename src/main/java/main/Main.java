package main;

import model.Bill;
import business_logic.OrderBLL;

public class Main {
    public static void main(String[] args) {
        try {
            Bill bill = OrderBLL.generateBillForOrder(4); // Assume order number 1 exists
            bill.printBill();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

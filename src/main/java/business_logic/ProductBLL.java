package business_logic;

import model.Product;
import data_access.ProductDAO;

import java.util.List;

public class ProductBLL {

    public static void addProduct(int IDProduct, String ProdName, float ProdPrice, int stoc) throws Exception {
        // Example of validation logic
        if (ProdName == null || ProdName.trim().isEmpty()) {
            throw new Exception("Product name cannot be empty.");
        }
        if (ProdPrice <= 0) {
            throw new Exception("Product price must be a positive number.");
        }
        if (stoc < 0) {
            throw new Exception("Product stock cannot be negative.");
        }

        // If validation passes, call the DAO method
        ProductDAO.addProduct(IDProduct, ProdName, ProdPrice, stoc);
    }

    public static Product findById(int IDProduct) throws Exception {
        // Example of business rule: Check if ID is valid
        if (IDProduct <= 0) {
            throw new Exception("Product ID must be a positive number.");
        }

        // Call the DAO method to fetch the product
        return ProductDAO.findById(IDProduct);
    }

    public static void updateProduct(int IDProduct, String ProdName, float ProdPrice, int stoc) throws Exception {
        // Example of validation logic
        if (IDProduct <= 0) {
            throw new Exception("Product ID must be a positive number.");
        }
        if (ProdName == null || ProdName.trim().isEmpty()) {
            throw new Exception("Product name cannot be empty.");
        }
        if (ProdPrice <= 0) {
            throw new Exception("Product price must be a positive number.");
        }
        if (stoc < 0) {
            throw new Exception("Product stock cannot be negative.");
        }

        // Call the DAO method to update the product
        ProductDAO.updateProduct(IDProduct, ProdName, ProdPrice, stoc);
    }

    public static void deleteProduct(int IDProduct) throws Exception {
        // Example of business rule: Check if ID is valid
        if (IDProduct <= 0) {
            throw new Exception("Product ID must be a positive number.");
        }

        // Call the DAO method to delete the product
        ProductDAO.deleteProduct(IDProduct);
    }

    public static List<Product> getAllProducts() {
        // Call the DAO method to fetch all products
        return ProductDAO.getAllProducts();
    }
}

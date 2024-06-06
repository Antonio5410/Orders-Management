package presentation;

import model.Product;
import business_logic.ProductBLL;
import presentation.ProductOperationsWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProductController {
    private ProductOperationsWindow productOperationsWindow;

    public ProductController(ProductOperationsWindow productOperationsWindow) {
        this.productOperationsWindow = productOperationsWindow;
        initController();
    }

    private void initController() {
        productOperationsWindow.getAddButton().addActionListener(e -> addProduct());
        productOperationsWindow.getEditButton().addActionListener(e -> editProduct());
        productOperationsWindow.getIncreaseStockButton().addActionListener(e -> increaseStock());
        productOperationsWindow.getViewAllButton().addActionListener(e -> viewAllProducts());
    }

    private void addProduct() {
        try {
            int id = Integer.parseInt(productOperationsWindow.getIdField().getText());
            String name = productOperationsWindow.getNameField().getText();
            float price = Float.parseFloat(productOperationsWindow.getPriceField().getText());
            int stock = Integer.parseInt(productOperationsWindow.getStockField().getText());
            ProductBLL.addProduct(id, name, price, stock);
            JOptionPane.showMessageDialog(productOperationsWindow, "Product added successfully!");
            viewAllProducts();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(productOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editProduct() {
        try {
            int id = Integer.parseInt(productOperationsWindow.getIdField().getText());
            String name = productOperationsWindow.getNameField().getText();
            float price = Float.parseFloat(productOperationsWindow.getPriceField().getText());
            int stock = Integer.parseInt(productOperationsWindow.getStockField().getText());
            ProductBLL.updateProduct(id, name, price, stock);
            JOptionPane.showMessageDialog(productOperationsWindow, "Product updated successfully!");
            viewAllProducts();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(productOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void increaseStock() {
        try {
            int id = Integer.parseInt(productOperationsWindow.getIdField().getText());
            int stockIncrease = Integer.parseInt(productOperationsWindow.getStockField().getText());
            Product product = ProductBLL.findById(id);
            if (product == null) {
                throw new Exception("Product not found.");
            }
            ProductBLL.updateProduct(id, product.getProdName(), product.getProdPrice(), product.getStoc() + stockIncrease);
            JOptionPane.showMessageDialog(productOperationsWindow, "Product stock increased successfully!");
            viewAllProducts();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(productOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAllProducts() {
        try {
            List<Product> products = ProductBLL.getAllProducts();
            DefaultTableModel model = (DefaultTableModel) productOperationsWindow.getProductTable().getModel();
            model.setRowCount(0); // Clear existing data
            for (Product product : products) {
                model.addRow(new Object[]{product.getIDProduct(), product.getProdName(), product.getProdPrice(), product.getStoc()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(productOperationsWindow, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

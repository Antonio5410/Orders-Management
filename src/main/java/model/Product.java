package model;

public class Product {
    private int IDProduct;
    private String ProdName;
    private float ProdPrice;
    private int stoc;

    public Product(int IDProduct, String ProdName, float ProdPrice, int stoc) {
        this.IDProduct = IDProduct;
        this.ProdName = ProdName;
        this.ProdPrice = ProdPrice;
        this.stoc = stoc;
    }

    public int getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(int IDProduct) {
        this.IDProduct = IDProduct;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String ProdName) {
        this.ProdName = ProdName;
    }

    public float getProdPrice() {
        return ProdPrice;
    }

    public void setProdPrice(float ProdPrice) {
        this.ProdPrice = ProdPrice;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "IDProduct=" + IDProduct +
                ", ProdName='" + ProdName + '\'' +
                ", ProdPrice=" + ProdPrice +
                ", stoc=" + stoc +
                '}';
    }
}

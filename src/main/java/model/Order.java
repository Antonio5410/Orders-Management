package model;

public class Order {
    private int NROrder;
    private int IDClient;
    private int IDProduct;
    private float cantitate;

    public Order(int NROrder, int IDClient, int IDProduct, float cantitate) {
        this.NROrder = NROrder;
        this.IDClient = IDClient;
        this.IDProduct = IDProduct;
        this.cantitate = cantitate;
    }

    public int getNROrder() {
        return NROrder;
    }

    public void setNROrder(int NROrder) {
        this.NROrder = NROrder;
    }

    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public int getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(int IDProduct) {
        this.IDProduct = IDProduct;
    }

    public float getCantitate() {
        return cantitate;
    }

    public void setCantitate(float cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "NROrder=" + NROrder +
                ", IDClient=" + IDClient +
                ", IDProduct=" + IDProduct +
                ", cantitate=" + cantitate +
                '}';
    }
}

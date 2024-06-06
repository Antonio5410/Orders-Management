package model;

public class Client {
    private int IDclient;
    private String Nume;
    private String Adresa;
    private int age;

    public Client(int IDclient, String nume, String adresa, int age) {
        this.IDclient = IDclient;
        this.Nume = nume;
        this.Adresa = adresa;
        this.age = age;
    }

    public int getIDclient() {
        return IDclient;
    }

    public String getNume() {
        return Nume;
    }

    public String getAdresa() {
        return Adresa;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "IDclient=" + IDclient +
                ", Nume='" + Nume + '\'' +
                ", Adresa='" + Adresa + '\'' +
                ", age=" + age +
                '}';
    }
}

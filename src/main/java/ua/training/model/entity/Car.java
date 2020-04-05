package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private String model;
    private long price;

    private Manufacturer manufacturer;
    private List<Shop> shops = new ArrayList<>();

    public Car() {
    }

    public Car(int id, String model, long price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public Car(int id, String model, long price, Manufacturer manufacturer) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void addShop(Shop shop) {
        shops.add(shop);
    }
    public List<Shop> getShops() {
        return shops;
    }

    @Override
    public String toString() {
        return "Car{" +
                System.identityHashCode(this) +
                ", id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                ", shops=" + shops +
                '}';
    }
}

package ua.training.model.entity;

public class Shop {
    private int id;
    private String name;
    private String telephone;

    private Manufacturer manufacturer;

    public Shop() {
    }

    public Shop(int id, String name, String telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public Shop(int id, String name, String telephone, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Shop{" +
                System.identityHashCode(this) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

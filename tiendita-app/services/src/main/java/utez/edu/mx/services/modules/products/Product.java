package utez.edu.mx.services.modules.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.services.kernel.BaseEntity;
import utez.edu.mx.services.modules.brands.Brand;
import utez.edu.mx.services.modules.bundles.Bundle;
import utez.edu.mx.services.modules.discounts.Discount;

import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Column(name = "on_sale", nullable = false)
    private boolean onSale;

    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false) //Funciona igual que column
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "id_discount", unique = true)
    private Discount discount;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Bundle> bundles;

    public Product(){

    }

    public Product(Long id, String name, double price, Long stock, boolean onSale, Brand brand, Discount discount, List<Bundle> bundles) {
        super(id);
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.onSale = onSale;
        this.brand = brand;
        this.discount = discount;
        this.bundles = bundles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<Bundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<Bundle> bundles) {
        this.bundles = bundles;
    }
}

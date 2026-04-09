package utez.edu.mx.services.modules.bundles.dtos;

import utez.edu.mx.services.modules.products.dtos.ProductBrandDTO;
import utez.edu.mx.services.modules.products.dtos.ProductDiscountDTO;

public class BundleProductDTO {
    private Long id;
    private String name;
    private Double price;
    private ProductBrandDTO brand;
    private ProductDiscountDTO discount;

    public BundleProductDTO() {
    }

    public BundleProductDTO(Long id, String name, Double price, ProductBrandDTO brand, ProductDiscountDTO discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public ProductBrandDTO getBrand() {
        return brand;
    }

    public ProductDiscountDTO getDiscount() {
        return discount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBrand(ProductBrandDTO brand) {
        this.brand = brand;
    }

    public void setDiscount(ProductDiscountDTO discount) {
        this.discount = discount;
    }
}
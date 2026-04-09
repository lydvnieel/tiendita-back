package utez.edu.mx.services.modules.products.dtos;

public class BasicProductDataDTO {
    private Long id;
    private String name;
    private Double price;
    private Long stock;
    private Boolean onSale;
    private ProductBrandDTO brand;
    private ProductDiscountDTO discount;

    public BasicProductDataDTO() {
    }

    public BasicProductDataDTO(Long id, String name, Double price, Long stock, Boolean onSale,
                               ProductBrandDTO brand, ProductDiscountDTO discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.onSale = onSale;
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

    public Long getStock() {
        return stock;
    }

    public Boolean getOnSale() {
        return onSale;
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

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public void setBrand(ProductBrandDTO brand) {
        this.brand = brand;
    }

    public void setDiscount(ProductDiscountDTO discount) {
        this.discount = discount;
    }
}
package utez.edu.mx.services.modules.products.dtos;

public class ProductDiscountDTO {
    private Long id;
    private Double discount;
    private String type;

    public ProductDiscountDTO() {
    }

    public ProductDiscountDTO(Long id, Double discount, String type) {
        this.id = id;
        this.discount = discount;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
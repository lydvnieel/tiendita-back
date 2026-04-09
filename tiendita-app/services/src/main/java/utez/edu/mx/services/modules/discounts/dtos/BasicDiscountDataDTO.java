package utez.edu.mx.services.modules.discounts.dtos;

public class BasicDiscountDataDTO {
    private Long id;
    private String code;
    private Double discount;
    private String type;
    private Boolean active;

    public BasicDiscountDataDTO() {

    }

    public BasicDiscountDataDTO(Long id, String code, Double discount, String type, Boolean active) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.type = type;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

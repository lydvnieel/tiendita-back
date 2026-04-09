package utez.edu.mx.services.modules.discounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import utez.edu.mx.services.kernel.BaseEntity;
import utez.edu.mx.services.modules.products.Product;

@Entity
@Table(name = "discount")
public class Discount extends BaseEntity {

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "discount", nullable = false)
    private double discount;

    @Column(name = "type", nullable = false)
    private boolean type;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToOne(mappedBy = "discount")
    @JsonIgnore
    private Product product;

    public Discount() {
    }

    public Discount(String code, double discount, boolean type, boolean active) {
        this.code = code;
        this.discount = discount;
        this.type = type;
        this.active = active;
    }

    public Discount(Long id, String code, double discount, boolean type, boolean active, Product product) {
        super(id);
        this.code = code;
        this.discount = discount;
        this.type = type;
        this.active = active;
        this.product = product;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

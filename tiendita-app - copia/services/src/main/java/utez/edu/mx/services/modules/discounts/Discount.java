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
}

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

}

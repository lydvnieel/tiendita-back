package utez.edu.mx.services.modules.bundles;

import jakarta.persistence.*;
import utez.edu.mx.services.kernel.BaseEntity;
import utez.edu.mx.services.modules.products.Product;

import java.util.List;

@Entity
@Table(name = "bundle")
public class Bundle extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "start_date", nullable = false)

    private String startDate;
    @Column(name = "end_date", nullable = false)

    private String endDate;
    @Column(name = "active", nullable = false)

    private boolean active;

    @ManyToMany
    @JoinTable(
            name = "bundle_has_products",
            joinColumns = @JoinColumn(name = "id_bundle", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_product", nullable = false)
    )
    private List<Product> products;

}

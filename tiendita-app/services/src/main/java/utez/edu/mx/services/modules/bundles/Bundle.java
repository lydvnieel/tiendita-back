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

    public Bundle(){

    }

    public Bundle(Long id, String name, String startDate, String endDate, boolean active, List<Product> products) {
        super(id);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

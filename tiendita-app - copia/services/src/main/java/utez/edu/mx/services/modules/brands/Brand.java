package utez.edu.mx.services.modules.brands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import utez.edu.mx.services.kernel.BaseEntity;
import utez.edu.mx.services.modules.products.Product;

import java.util.List;

@Entity //Le dice a spring que esta clase es una entidad
@Table(name = "brand") //Indica que es una tabla y ponerle nombre a una tabla
public class Brand extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "registry_date", nullable = false)
    private String registryDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;



    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Product> products;


    public Brand(){

    }

    public Brand(Long id, List<Product> products, String description, String registryDate, String name) {
        super(id);
        this.products = products;
        this.description = description;
        this.registryDate = registryDate;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

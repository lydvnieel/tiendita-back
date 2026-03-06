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

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Product> products;

}

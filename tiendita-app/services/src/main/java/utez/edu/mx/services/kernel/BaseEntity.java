package utez.edu.mx.services.kernel;

import jakarta.persistence.*;

@MappedSuperclass //Sirve para extender y heredar propiedades que se repiten y pueda utilizar anotaciones de JPA
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;

    public BaseEntity(){

    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

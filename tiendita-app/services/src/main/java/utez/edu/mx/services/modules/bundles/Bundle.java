package utez.edu.mx.services.modules.bundles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import utez.edu.mx.services.kernel.BaseEntity;

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

}

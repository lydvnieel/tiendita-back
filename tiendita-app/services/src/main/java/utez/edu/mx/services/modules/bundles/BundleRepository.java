package utez.edu.mx.services.modules.bundles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BundleRepository extends JpaRepository<Bundle, Long> {
    @Modifying
    @Query(value = "UPDATE bundle SET active = !active WHERE id = :id", nativeQuery = true)
    void changeBundleStatus(@Param("id") Long id);
}

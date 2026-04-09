package utez.edu.mx.services.modules.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query(value = "UPDATE product SET on_sale = !on_sale WHERE id = :", nativeQuery = true)
    void changeProductStatus(@Param("id") Long id);
}

package utez.edu.mx.services.modules.discounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    @Modifying
    @Query(value = "UPDATE discount SET active = !active WHERE id = :id", nativeQuery = true)
    void changeDiscountStatus(@Param("id") Long id);
}

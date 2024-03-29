package de.telran.l3.eg240123mbelesson331082023.repository.jpa;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.jpa.JpaProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaProductRepository extends JpaRepository<JpaProduct, Integer> {

    @Transactional
    void deleteByName(String name);

    @Query(value = "select sum(price) from product", nativeQuery = true)
    double getTotalPrice();


}

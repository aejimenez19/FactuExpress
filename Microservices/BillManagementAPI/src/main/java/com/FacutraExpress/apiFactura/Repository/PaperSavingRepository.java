package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Entities.PaperSaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaperSavingRepository extends JpaRepository<PaperSaving, Long> {

    @Query(value = "SELECT b.id_customer AS idCustomer, COUNT(DISTINCT b.id) AS totalInvoice, SUM(product_count) AS totalItems " +
            "FROM bills b LEFT JOIN ( SELECT  id_bill, COUNT(DISTINCT id) AS product_count FROM " +
            "items GROUP BY id_bill ) p ON b.id = p.id_bill WHERE b.id_customer= 1", nativeQuery = true)
    Optional<PaperSaving> getPaperSaving(Long id);
}

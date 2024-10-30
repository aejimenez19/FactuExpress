package com.facturaExpress.InvoiceService.Repository;

import com.facturaExpress.InvoiceService.Commons.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query(value = "SELECT id FROM customers WHERE number_identification = :identification", nativeQuery = true)
    Long getIdCustomerByIdentification(@Param("identification") String identification);
}

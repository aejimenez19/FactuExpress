package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Entities.BillsByCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BillsByCompanyRepository extends JpaRepository<BillsByCompany, Long> {
    @Query(value = "SELECT b.id as id_bill, b.references_code," +
            " b.billing_date,c.id as id_company, c.name as name_company, t.name as type_payment " +
            "FROM bills b INNER JOIN companys c ON c.id = b.id_company " +
            "INNER JOIN type_payment t ON t.id = b.id_type_payment " +
            "WHERE b.id_customer = :id AND DATE_FORMAT(b.billing_date, '%Y-%m') = :date " +
            "ORDER BY c.id desc;",
            nativeQuery = true)
    List<BillsByCompany> getBillOrderByCompany(@Param("id") Long id, @Param("date") String date);
}

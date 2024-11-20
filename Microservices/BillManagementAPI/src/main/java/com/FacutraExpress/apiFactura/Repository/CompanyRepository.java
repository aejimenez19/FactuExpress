package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Comercio;
import com.FacutraExpress.apiFactura.Models.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "select companys.* from bills join companys on companys.id = bills.id_company where bills.id = ?1",
            nativeQuery = true)
    Company getCompanyWithIdBill(Long idBill);
}

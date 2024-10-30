package com.facturaExpress.InvoiceService.Repository;

import com.facturaExpress.InvoiceService.Commons.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}

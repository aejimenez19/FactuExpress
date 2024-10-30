package com.facturaExpress.InvoiceService.Repository;

import com.facturaExpress.InvoiceService.Commons.Entities.Credential;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credential, Long> {
    Credential findByUserName(@NotNull String user);
}

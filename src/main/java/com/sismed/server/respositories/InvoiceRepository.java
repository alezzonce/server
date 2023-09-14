package com.sismed.server.respositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sismed.server.entities.InvoiceEntity;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, UUID> {

}
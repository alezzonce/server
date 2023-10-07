package com.sismed.server.respositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sismed.server.entities.DeliveryEntity;

// Esto será IMPLEMENTADO AUTOMÁTICAMENTE por Spring en un Bean llamado DeliveryRepository

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {  

}


package com.sismed.server.respositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sismed.server.entities.MedicineTypeEntity;

// Esto será IMPLEMENTADO AUTOMÁTICAMENTE por Spring en un Bean llamado MedicineTypeRepository

public interface MedicineTypeRepository extends JpaRepository<MedicineTypeEntity, UUID> {

}

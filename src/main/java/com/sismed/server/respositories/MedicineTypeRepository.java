package com.sismed.server.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sismed.server.entities.MedicineTypeEntity;

public interface MedicineTypeRepository extends JpaRepository<MedicineTypeEntity, UUID> {

}

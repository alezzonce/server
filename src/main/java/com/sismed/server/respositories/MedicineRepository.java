package com.sismed.server.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sismed.server.entities.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, UUID> {

}
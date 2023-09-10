package com.sismed.server.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sismed.server.entities.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, UUID> {
    @Query("SELECT u FROM MedicineEntity u WHERE u.name = ?1")
    MedicineEntity findByMedicine(String Medicine);
    boolean existsByName(String name);

    boolean existsByMedicine(String Medicine);

}
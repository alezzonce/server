package com.sismed.server.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sismed.server.entities.DeliveryEntity;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {

}


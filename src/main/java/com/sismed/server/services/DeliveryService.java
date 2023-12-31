package com.sismed.server.services;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.sismed.server.utils.Pagination;
import com.sismed.server.respositories.DeliveryRepository;
import org.springframework.data.domain.PageRequest;
import com.sismed.server.entities.DeliveryEntity;

/* Servicio de métodos CRUD (crear, leer, actualizar y eliminar) registros de la tabla Delivery */

@Service
public class DeliveryService extends RuntimeException {

    @Autowired DeliveryRepository deliveryRepository;

    /* Método para obtener todos los registros de la tabla Delivery */

    public Pagination<DeliveryEntity> getAllUsers(int page, int size){
        Page<DeliveryEntity> users = deliveryRepository.findAll(PageRequest.of(page, size));
        Pagination<DeliveryEntity> pagination = new Pagination<DeliveryEntity>();
        pagination.setCurrentPage(page);
        pagination.setData(users.getContent());
        pagination.setPageSize(size);
        pagination.setTotal(users.getTotalPages());
        pagination.setTotalElements(users.getTotalElements());
        pagination.setPage(users.getNumber());
        return pagination;
    }

    /* Método para crear un registro de la tabla Delivery */

    public DeliveryEntity createDelivery (DeliveryEntity deliveryEntity) {

        return deliveryRepository.save(deliveryEntity);
    }

    /* Método para actualizar un registro de la tabla Delivery */

    public DeliveryEntity updateDelivery (UUID id, DeliveryEntity delivery) {
        Optional<DeliveryEntity> deliveryUpdate = deliveryRepository.findById(id);
            if (deliveryUpdate.isPresent()) {
                deliveryUpdate.get().setVehicleLicensePlate(delivery.getVehicleLicensePlate());
                deliveryUpdate.get().setVehicleType(delivery.getVehicleType());
                    return deliveryRepository.save(deliveryUpdate.get());
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }

    /* Método para eliminar un registro de la tabla Delivery */

    public DeliveryEntity deleteById (UUID id) {
        Optional<DeliveryEntity> userDelete = deliveryRepository.findById(id);
        if (userDelete.isPresent()) {
            deliveryRepository.deleteById(id);
                return userDelete.get();
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }
}
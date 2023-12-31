package com.sismed.server.services;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.sismed.server.utils.Pagination;
import com.sismed.server.respositories.MedicineRepository;
import org.springframework.data.domain.PageRequest;
import com.sismed.server.entities.MedicineEntity;

/* Servicio de métodos CRUD (crear, leer, actualizar y eliminar) registros de la tabla Medicine */

@Service
public class MedicineService extends RuntimeException {

    @Autowired
    MedicineRepository MedicineRepository;

    /* Método para obtener todos los registros de la tabla Medicine */

    public Pagination<MedicineEntity> getAllUsers(int page, int size) {
        Page<MedicineEntity> users = MedicineRepository.findAll(PageRequest.of(page, size));
        Pagination<MedicineEntity> pagination = new Pagination<MedicineEntity>();
        pagination.setCurrentPage(page);
        pagination.setData(users.getContent());
        pagination.setPageSize(size);
        pagination.setTotal(users.getTotalPages());
        pagination.setTotalElements(users.getTotalElements());
        pagination.setPage(users.getNumber());
            return pagination;
    }

    /* Método para crear un registro de la tabla Medicine */

    public MedicineEntity createMedicine(MedicineEntity MedicineEntity) {

        return MedicineRepository.save(MedicineEntity);
    }

    /* Método para actualizar un registro de la tabla Medicine */

    public MedicineEntity updateMedicine(UUID id, MedicineEntity user) {
        Optional<MedicineEntity> MedicineTypeUpdate = MedicineRepository.findById(id);
        if (MedicineTypeUpdate.isPresent()) {
            MedicineTypeUpdate.get().setName(user.getName());
            MedicineTypeUpdate.get().setDescription(user.getDescription());
                return MedicineRepository.save(MedicineTypeUpdate.get());
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }

    /* Método para eliminar un registro de la tabla Medicine */

    public MedicineEntity deleteById(UUID id) {
        Optional<MedicineEntity> userDelete = MedicineRepository.findById(id);
        if (userDelete.isPresent()) {
            MedicineRepository.deleteById(id);
            return userDelete.get();
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }
}
package com.sismed.server.services;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.sismed.server.utils.Pagination;
import com.sismed.server.respositories.MedicineTypeRepository;
import org.springframework.data.domain.PageRequest;
import com.sismed.server.entities.MedicineTypeEntity;

/* Servicio de métodos CRUD (crear, leer, actualizar y eliminar) registros de la tabla MedicineType */

@Service
public class MedicineTypeService extends RuntimeException {

    @Autowired MedicineTypeRepository medicineTypeRepository;

    /* Método para obtener todos los registros de la tabla MedicineType */

    public Pagination<MedicineTypeEntity> getAllUsers(int page, int size){
        Page<MedicineTypeEntity> users = medicineTypeRepository.findAll(PageRequest.of(page, size));
        Pagination<MedicineTypeEntity> pagination = new Pagination<MedicineTypeEntity>();
        pagination.setCurrentPage(page);
        pagination.setData(users.getContent());
        pagination.setPageSize(size);
        pagination.setTotal(users.getTotalPages());
        pagination.setTotalElements(users.getTotalElements());
        pagination.setPage(users.getNumber());
        return pagination;
    }

    /* Método para crear un registro de la tabla MedicineType */

    public MedicineTypeEntity createMedicineType (MedicineTypeEntity medicineTypeEntity) {
        return medicineTypeRepository.save(medicineTypeEntity);
    }

    /* Método para actualizar un registro de la tabla MedicineType */

    public MedicineTypeEntity updateMedicineType (UUID id, MedicineTypeEntity user) {
        Optional<MedicineTypeEntity> MedicineTypeUpdate = medicineTypeRepository.findById(id);
        if (MedicineTypeUpdate.isPresent()) {
            MedicineTypeUpdate.get().setCategory(user.getCategory());
            MedicineTypeUpdate.get().setAmount(user.getAmount());
            return medicineTypeRepository.save(MedicineTypeUpdate.get());
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }

    /* Método para eliminar un registro de la tabla MedicineType */

    public MedicineTypeEntity deleteById (UUID id) {
        Optional<MedicineTypeEntity> userDelete = medicineTypeRepository.findById(id);
        if (userDelete.isPresent()) {
            medicineTypeRepository.deleteById(id);
            return userDelete.get();
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }
}
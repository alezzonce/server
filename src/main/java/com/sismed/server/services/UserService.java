package com.sismed.server.services;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.sismed.server.utils.Pagination;
import com.sismed.server.respositories.UserRepository;
import org.springframework.data.domain.PageRequest;
import com.sismed.server.entities.UserEntity;

/* Servicio de métodos CRUD (crear, leer, actualizar y eliminar) registros de la tabla User */

@Service
public class UserService extends RuntimeException {

    @Autowired UserRepository userRepository;

    /* Método para obtener todos los registros de la tabla User */

    public Pagination<UserEntity> getAllUsers(int page, int size){
        Page<UserEntity> users = userRepository.findAll(PageRequest.of(page, size));
        Pagination<UserEntity> pagination = new Pagination<UserEntity>();
        pagination.setCurrentPage(page);
        pagination.setData(users.getContent());
        pagination.setPageSize(size);
        pagination.setTotal(users.getTotalPages());
        pagination.setTotalElements(users.getTotalElements());
        pagination.setPage(users.getNumber());
        return pagination;
    }

    /* Método para crear un registro de la tabla User */

    public UserEntity createUser (UserEntity userEntity) {
        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            throw new DataIntegrityViolationException("Username already exists");
        }

        return userRepository.save(userEntity);
    }

    /* Método para actualizar un registro de la tabla User */

    public UserEntity updateUser (UUID id, UserEntity user) {
        Optional<UserEntity> userUpdate = userRepository.findById(id);
        if (userUpdate.isPresent()) {
            userUpdate.get().setUsername(user.getUsername());
            userUpdate.get().setPassword(user.getPassword());
            userUpdate.get().setEmail(user.getEmail());
            userUpdate.get().setFirstName(user.getFirstName());
            userUpdate.get().setLastName(user.getLastName());
            userUpdate.get().setTelephone(user.getTelephone());
            userUpdate.get().setAddress(user.getAddress());
            userUpdate.get().setUserRol(user.getUserRol());
            return userRepository.save(userUpdate.get());
        } else {
            throw new DataIntegrityViolationException("El usuario no existe");
        }
    }

    /* Método para eliminar un registro de la tabla User */

    public UserEntity deleteById (UUID id) {
        Optional<UserEntity> userDelete = userRepository.findById(id);
        if (userDelete.isPresent()) {
            userRepository.deleteById(id);
            return userDelete.get();
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }
}




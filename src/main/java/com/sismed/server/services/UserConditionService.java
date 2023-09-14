package com.sismed.server.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.sismed.server.utils.Pagination;
import com.sismed.server.respositories.UserConditionRepository;
import org.springframework.data.domain.PageRequest;

import com.sismed.server.entities.UserConditionEntity;

@Service
public class UserConditionService extends RuntimeException {

    @Autowired UserConditionRepository userConditionRepository;

    public Pagination<UserConditionEntity> getAllUsers(int page, int size){
        Page<UserConditionEntity> users = userConditionRepository.findAll(PageRequest.of(page, size));
        Pagination<UserConditionEntity> pagination = new Pagination<UserConditionEntity>();
        pagination.setCurrentPage(page);
        pagination.setData(users.getContent());
        pagination.setPageSize(size);
        pagination.setTotal(users.getTotalPages());
        pagination.setTotalElements(users.getTotalElements());
        pagination.setPage(users.getNumber());
        return pagination;
    }

    public UserConditionEntity createUserCondition (UserConditionEntity UserConditionEntity) {

        if (userConditionRepository.existsByuserCondition(UserConditionEntity.getUserCondition())) {
                throw new DataIntegrityViolationException("User already exists");
            }

        return userConditionRepository.save(UserConditionEntity);
    }

    public UserConditionEntity updateUserCondition (UUID id, UserConditionEntity user) {
        Optional<UserConditionEntity> userUpdate = userConditionRepository.findById(id);
        if (userUpdate.isPresent()) {
            userUpdate.get().setObservation(user.getObservation());
            userUpdate.get().setUserCondition(user.getUserCondition());
            return userConditionRepository.save(userUpdate.get());
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }

    public UserConditionEntity deleteById (UUID id) {
        Optional<UserConditionEntity> userDelete = userConditionRepository.findById(id);
        if (userDelete.isPresent()) {
            userConditionRepository.deleteById(id);
            return userDelete.get();
        } else {
            throw new DataIntegrityViolationException("User not found");
        }
    }
}

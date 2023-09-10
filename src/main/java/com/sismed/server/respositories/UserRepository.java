package com.sismed.server.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sismed.server.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    /*@Query("SELECT u FROM UserEntity u WHERE u.user = ?1")  QUEDA PENDIENTE REVISARLO GENERA ERROR*/
    UserEntity findByuser(String user);

    boolean existsByuser(String user);

}

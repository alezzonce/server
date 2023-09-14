package com.sismed.server.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sismed.server.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {


}


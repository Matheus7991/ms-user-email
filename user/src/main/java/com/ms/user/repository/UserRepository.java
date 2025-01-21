package com.ms.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}

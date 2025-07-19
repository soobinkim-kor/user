package com.soobin.user.repository;

import com.soobin.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByAccount(String account);
    Optional<UserEntity> findByRrn(String rrn);
    boolean existsByAccount(String account);
    boolean existsByRrn(String rrn);
}

package com.example.account_service.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.account_service.model.UserProfile;

@Repository
public interface UserProfileRepos extends JpaRepository<UserProfile, Long>{
   Optional<UserProfile> findById(Long id);

   Optional<UserProfile> findByEmail(String email);
}

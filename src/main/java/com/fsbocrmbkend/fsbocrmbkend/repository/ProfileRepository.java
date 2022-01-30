package com.fsbocrmbkend.fsbocrmbkend.repository;

import com.fsbocrmbkend.fsbocrmbkend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findById(Long userId);
}
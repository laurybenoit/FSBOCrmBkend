package com.fsbocrmbkend.fsbocrmbkend.repository;

import com.fsbocrmbkend.fsbocrmbkend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAddress(String userEmailAddress);
    User findUserByEmailAddress(String userEmailAddress);
    User findByUserProfileId(Long profileId);
    User findByIdAndUserProfileId(Long id, Long profileId);
}

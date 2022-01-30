package com.fsbocrmbkend.fsbocrmbkend.repository;

import com.fsbocrmbkend.fsbocrmbkend.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository<address> extends JpaRepository<Properties, Long> {
    Optional<Properties> findByAddress(String address);
    Optional<Properties> findBylotZize(String lotZize);
}

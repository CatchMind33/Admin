package com.catchmind.admin.repository;


import com.catchmind.admin.model.entity.Pending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PendingRepository extends JpaRepository<Pending, Long> {
    Optional<Pending> findByPenBisName(String penBisName);
}

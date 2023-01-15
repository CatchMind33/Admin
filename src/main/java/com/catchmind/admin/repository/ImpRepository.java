package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Ask;
import com.catchmind.admin.model.entity.Improvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImpRepository extends JpaRepository<Improvement,Long> {
    Optional<Improvement> findByImpIdx(Long impIdx);
}

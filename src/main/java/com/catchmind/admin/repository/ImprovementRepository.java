package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Improvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImprovementRepository extends JpaRepository<Improvement,Long> {
}

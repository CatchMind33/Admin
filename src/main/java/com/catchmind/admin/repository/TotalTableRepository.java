package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.TotalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalTableRepository extends JpaRepository<TotalTable,Long> {
}

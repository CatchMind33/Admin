package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskRepository extends JpaRepository<Ask,Long> {
}

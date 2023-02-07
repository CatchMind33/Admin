package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AskRepository extends JpaRepository<Ask,Long> {
    Optional<Ask> findByAskIdx(Long askIdx);
}

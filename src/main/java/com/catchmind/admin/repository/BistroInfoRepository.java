package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.BistroInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BistroInfoRepository extends JpaRepository<BistroInfo,Long> {
    Optional<BistroInfo> findByResAdmin_ResaBisName(String resaBisName);
}
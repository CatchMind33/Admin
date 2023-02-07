package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.BistroInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BistroInfoRepository extends JpaRepository<BistroInfo,Long> {
    BistroInfo findByResaBisName(String resaBisName);
}
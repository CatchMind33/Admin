package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.BistroDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BisDetailRepository extends JpaRepository<BistroDetail,Long> {
}

package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Pending;
import com.catchmind.admin.model.entity.ResAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResAdminRepository extends JpaRepository<ResAdmin, String> {

    Optional<ResAdmin> findByResaUserid(String resaUserid);

    List<ResAdmin> findByResaBisNameContaining(String resaBisName);
}

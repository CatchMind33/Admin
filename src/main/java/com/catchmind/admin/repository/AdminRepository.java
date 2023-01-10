package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    // 쿼리 메소드 구현
    // 로그인 쿼리
    Optional<Admin> findByAdUseridAndAdUserpw(String adUserid, String adUserpw);
}

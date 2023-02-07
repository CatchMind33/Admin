package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.TalkAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkAdminRepository extends JpaRepository<TalkAdmin, Long> {
}

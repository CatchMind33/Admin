package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.DeclareComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecComRepository extends JpaRepository<DeclareComment, Long> {
}

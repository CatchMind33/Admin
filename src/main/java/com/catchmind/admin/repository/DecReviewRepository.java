package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.DeclareReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecReviewRepository extends JpaRepository<DeclareReview, Long> {
    List<DeclareReview> findTop3By();
}

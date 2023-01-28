package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.DeclareReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecReviewRepository extends JpaRepository<DeclareReview, Long> {
}

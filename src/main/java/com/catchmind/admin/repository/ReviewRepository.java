package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByRevIdx(Long revIdx);
}

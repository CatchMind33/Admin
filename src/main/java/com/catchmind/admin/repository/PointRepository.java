package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point,Long> {
}

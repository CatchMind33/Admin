package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

    Optional<Profile> findByPrNick(String prNick);

    List<Profile> findTop4By();

    Optional<Profile> findByPrIdx(Long prIdx);

    Integer countBy();

    List<Profile> findTop5ByOrderByPrReviewDesc();
}
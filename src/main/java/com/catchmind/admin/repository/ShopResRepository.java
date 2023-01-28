package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.ShopResTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopResRepository extends JpaRepository<ShopResTable,Long> {

}

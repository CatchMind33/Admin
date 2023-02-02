package com.catchmind.admin.repository;

import com.catchmind.admin.model.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve,Long> {
    Integer countReserveByResStatusAndResaBisName(String resStatus,String resaBisName);
    Integer countByResMonth(String resMonth);
    Integer countBy();
}

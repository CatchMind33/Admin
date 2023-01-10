package com.catchmind.admin.model.entity;

import com.catchmind.admin.model.config.AuditableUpdate;
import com.catchmind.admin.model.config.BaseEntityUpdate;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Notice extends BaseEntityUpdate implements AuditableUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noIdx;
    private String noTitle;
    private String adName;
    private String adUserid;
    private String noContent;

}
//   no_idx int primary key auto_increment,
//   no_title varchar(1000) not null,
//   ad_name varchar(100) not null,
//   ad_userid varchar(100),
//   no_content varchar(2000) not null,
//   reg_date datetime default now(),
//   update_date datetime,
//        foreign key (ad_userid) references admin (ad_userid) on update cascade on delete cascade
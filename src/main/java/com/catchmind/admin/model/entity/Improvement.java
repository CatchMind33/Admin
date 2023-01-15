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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Improvement extends BaseEntityUpdate implements AuditableUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impIdx;
    private String impTitle;
    private String impContent;
    private String impNick;
    private String impAnswer;
    private String impStatus;


}

//create table improvement(
//   imp_idx int primary key auto_increment,
//   imp_title varchar(1000) not null,
//   imp_content varchar(2000) not null,
//   imp_nick varchar(100),
//   imp_answer varchar(2000),
//   imp_status varchar(10) not null,

//   foreign key (imp_nick) references profile (pr_nick) on update cascade on delete cascade
//);
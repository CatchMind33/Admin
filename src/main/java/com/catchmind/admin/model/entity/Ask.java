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

public class Ask extends BaseEntityUpdate implements AuditableUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long askIdx;
    private String askTitle;
    private String askContent;
    private String askNick;
    private String askAnswer;
    private String askStatus;

}

//
//    create table ask(
//        ask_idx int primary key auto_increment,
//        ask_title varchar(1000) not null,
//        ask_content varchar(2000) not null,
//        ask_nick varchar(100),
//        ask_answer varchar(2000),
//        ask_status varchar(10),
//        reg_date datetime default now(),
//        update_date datetime,
//        foreign key (ask_nick) references profile (pr_nick) on update cascade on delete cascade
//        );
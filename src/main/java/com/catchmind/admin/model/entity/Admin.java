package com.catchmind.admin.model.entity;

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
public class Admin extends BaseEntityUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String adUserid;
    private String adUserpw;
    private String adName;
    private String adHp;
    private String adEmail;


//    ad_userid varchar(100) unique primary key,			# 관리자 아이디		# unique**
//    ad_userpw varchar(100) not null, 					# 관리자 비밀번호
//    ad_name varchar(100) not null, 						# 관리자 이름
//    ad_hp varchar(100) not null, 						# 관리자 전화번호
//    ad_email varchar(500) not null, 					# 관리자 이메일
//    reg_date datetime default now()
}

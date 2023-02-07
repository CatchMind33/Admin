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
public class Profile extends BaseEntityUpdate implements AuditableUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prIdx;
    private String prNick;
    private String prName;
    private String prIntro;
    private String prRegion;
    private String prHp;
    private String prUserpw;
    private String prGender;
    private String prBirth;
    private String prMemo;
    private int prReview;
    private int prNoshow;
    private boolean prBlock;
    private String role;

//    @OneToMany(mappedBy = "DeclareReview")
//    List<DeclareReview> declareReviewList;


}

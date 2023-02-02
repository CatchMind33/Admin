package com.catchmind.admin.model.entity;

import com.catchmind.admin.model.config.AuditableUpdate;
import com.catchmind.admin.model.config.BaseEntity;
import com.catchmind.admin.model.config.BaseEntityUpdate;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseEntityUpdate implements AuditableUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long revIdx;
    private Long revLike;
    private String revContent;
    private Double revScore;
    private String orgNm;
    private String savedNm;
    private String savedPath;
    @ManyToOne
    @JoinColumn(name="res_idx")
    private Reserve reserve;
    @ManyToOne
    @JoinColumn(name="pr_idx")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name="resaBisName")
    private ResAdmin resAdmin;
}
package com.catchmind.admin.model.entity;

import com.catchmind.admin.model.config.AuditableUpdate;
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
    private Long resIdx;
    private int revLike;
    private String revContent;
    private double revScore;
    private Long revComm;
    @ManyToOne
    @JoinColumn(name="prIdx")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name="resaBisName")
    private ResAdmin resAdmin;
}
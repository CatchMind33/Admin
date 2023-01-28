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

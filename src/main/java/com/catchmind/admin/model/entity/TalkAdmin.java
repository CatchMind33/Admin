package com.catchmind.admin.model.entity;

import com.catchmind.admin.model.config.Auditable;
import com.catchmind.admin.model.config.BaseEntity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class TalkAdmin extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taaIdx;
    private String taaNick;
    private String taaContent;
}

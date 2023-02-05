package com.catchmind.admin.model.entity;

import com.catchmind.admin.model.config.Auditable;
import com.catchmind.admin.model.config.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor      //매개변수 없는 생성자(AdminUser())
@AllArgsConstructor     //매개변수 다 있는 생성자 (그위에 (Long, String,....))
@Data
@Builder
@ToString(callSuper = true)     //
@EqualsAndHashCode(callSuper = true)    //
@EntityListeners(AuditingEntityListener.class)
public class Reserve extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resIdx;
    private int prIdx;
    private String prName;
    private String resHp;
    private String resRequest;
    private String visitName;
    private String visitHp;
    private String resMonth;
    private String resDay;
    private String resPerson;
    private String resTime;
    private String resStatus;
    private String resReason;
    private boolean revStatus;

    private Long bdIdx;
//    @ManyToOne
//    @JoinColumn(name="resa_bis_name")
//    private ResAdmin resAdmin;
    private String resaBisName;
}

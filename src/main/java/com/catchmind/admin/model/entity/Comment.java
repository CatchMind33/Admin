package com.catchmind.admin.model.entity;

import com.catchmind.admin.model.config.Auditable;
import com.catchmind.admin.model.config.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comIdx;
    private String comNick;
    private String comContent;
    @ManyToOne
    @JoinColumn(name="revIdx")
    private Review review;

}

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
public class DeclareReview extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long derIdx;
    @ManyToOne
    @JoinColumn(name="revIdx")
    private Review review;
    @ManyToOne
    @JoinColumn(name="prIdx")
    private Profile profile;        // 신고함
    private String derTitle;
    private String derNick;     // 신고당함
    private String derContent;
}

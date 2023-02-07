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
public class DeclareComment extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long decIdx;
    @ManyToOne
    @JoinColumn(name="revIdx")
    private Review review;
    @ManyToOne
    @JoinColumn(name="comIdx")
    private Comment comment;    
    @ManyToOne
    @JoinColumn(name="prIdx")
    private Profile profile;        // 신고자
    private String decNick;         // 신고당함
    private String decTitle;
    private String decContent;
}

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
public class BistroInfo extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bisIdx;
    @ManyToOne
    @JoinColumn(name="resaBisName")
    private ResAdmin resAdmin;
    private String bisDesc;
    private String bisCategory;
    private String bisRegion;
    private String bisLunch;
    private String bisDinner;
    private String bisConvenience;
}

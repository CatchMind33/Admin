package com.catchmind.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BistroDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bdIdx;
    private String bdNotice;
    private String bdPark;
    private String bdAddr;
    private String bdHp;
    private String bdIntro;
    private String bdCaution;
    private String bdHour;
    private String bdHoliday;
    private String bdHome;
    @ManyToOne
    @JoinColumn(name="resaBisName")
    private ResAdmin resAdmin;
    @ManyToOne
    @JoinColumn(name="bisIdx", referencedColumnName = "bisIdx")
    private BistroInfo bistroInfo;
}

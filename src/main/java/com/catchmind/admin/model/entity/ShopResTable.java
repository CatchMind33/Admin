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
public class ShopResTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopResId;
    private String shopResStatus;
    private String shopResMonth;
    private String shopResDay;
    private String shopResTime;
    @ManyToOne
    @JoinColumn(name="resaBisName")
    private ResAdmin resAdmin;
}

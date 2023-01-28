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
public class TotalTable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totTableId;
    @ManyToOne
    @JoinColumn(name="resaBisName")
    private ResAdmin resAdmin;
    private String totCapacity;
    private String totTable;
}

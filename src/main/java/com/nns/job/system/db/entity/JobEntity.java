package com.nns.job.system.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="JOB")
@NoArgsConstructor
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "JOB_GROUP_ID", nullable = false)
    private Long jobGroupId;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "JOB_CONFIG_TABLE")
    private String jobConfigTable;

    @Column(name = "IS_ACTIVE")
    private String isActive;

    @Column(name = "LAST_UPDATED_BY")
    private String lastModifiedBy;

    @Column(name = "last_updated_date")
    private LocalDateTime lastModifiedDateTime;



}

package com.nns.job.system.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="JOB_INSTANCE")
@NoArgsConstructor
public class JobInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "JOB_ID")
    private Long jobId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "FAILURE_REASON")
    private String failureReason;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "last_updated_date")
    private LocalDateTime lastModifiedDateTime;



}

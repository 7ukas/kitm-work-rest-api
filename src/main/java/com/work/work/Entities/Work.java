package com.work.work.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="work_type")
    private String workType;

    @Column(name="work_desc")
    private String workDesc;

    @Column(name="hours_worked")
    private Integer hoursWorked;

    @Column(name="worker_name")
    private String workerName;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="last_updated")
    private LocalDateTime lastUpdated;

    public Work() {}

    public Work(Long id, String workType, String workDesc, Integer hoursWorked, String workerName, LocalDateTime createdAt, LocalDateTime lastUpdated) {
        this.id = id;
        this.workType = workType;
        this.workDesc = workDesc;
        this.hoursWorked = hoursWorked;
        this.workerName = workerName;
        this.createdAt = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", workType='" + workType + '\'' +
                ", workDesc='" + workDesc + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", workerName='" + workerName + '\'' +
                ", createdAt=" + createdAt +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}

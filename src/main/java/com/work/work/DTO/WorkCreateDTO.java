package com.work.work.DTO;

import jakarta.validation.constraints.*;

public class WorkCreateDTO {
    @NotBlank(message = "Work must have a type")
    @Size(max = 64)
    private String workType;

    @NotBlank(message = "Work must have a description")
    @Size(max = 128)
    private String workDesc;

    @Min(value = 1, message = "Worked hours must be 1 or more")
    @Max(value = 24, message = "Worked hours must be 24 or less")
    private Integer hoursWorked;

    @NotBlank(message = "Worker must have a name")
    @Size(max = 64, message = "Worker's name must be shorter than 65 characters")
    private String workerName;

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
}

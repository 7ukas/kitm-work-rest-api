package com.work.work.Mappers;

import com.work.work.DTO.WorkCreateDTO;
import com.work.work.DTO.WorkResponseDTO;
import com.work.work.Entities.Work;

import java.time.LocalDateTime;

public class WorkMapper {
    public static Work toEntity(WorkCreateDTO dto) {
        Work work = new Work();

        work.setWorkType(dto.getWorkType());
        work.setWorkDesc(dto.getWorkDesc());
        work.setHoursWorked(dto.getHoursWorked());
        work.setWorkerName(dto.getWorkerName());
        work.setCreatedAt(LocalDateTime.now());
        work.setLastUpdated(LocalDateTime.now());

        return work;
    }

    public static WorkResponseDTO toResponse(Work entity) {
        WorkResponseDTO dto = new WorkResponseDTO();

        dto.setId(entity.getId());
        dto.setWorkType(entity.getWorkType());
        dto.setWorkDesc(entity.getWorkDesc());
        dto.setHoursWorked(entity.getHoursWorked());
        dto.setWorkerName(entity.getWorkerName());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setLastUpdated(entity.getLastUpdated());

        return dto;
    }
}

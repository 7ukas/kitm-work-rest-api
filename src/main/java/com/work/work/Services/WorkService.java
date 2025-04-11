package com.work.work.Services;

import com.work.work.Entities.Work;

import java.util.List;

public interface WorkService {
    List<Work> findAll();

    Work findById(int id);

    Integer findHoursWorkedByName(String workerName);

    Work save(Work work);

    void deleteById(int id);
}

package com.work.work.Services;

import com.work.work.DAO.WorkRepository;
import com.work.work.Entities.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkServiceImpl implements WorkService {
    private WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public List<Work> findAll() {
        return workRepository.findAll();
    }

    @Override
    public Work findById(int id) {
        Optional<Work> result = workRepository.findById(id);
        Work work = null;

        if (result.isPresent()) {
            work = result.get();
        } else {
            throw new RuntimeException("Work was not found by id [id=" + id + "]");
        }

        return work;
    }

    @Override
    public Integer findHoursWorkedByName(String workerName) {
        Optional<Integer> result = Integer.valueOf(
                workRepository.findAll()
                        .stream()
                        .filter(work -> work.getWorkerName().equalsIgnoreCase(workerName))
                        .mapToInt(Work::getHoursWorked).sum()
        ).describeConstable();

        Integer hours = null;

        if (result.get() > 0) {
            hours = result.get();
        } else {
            throw new RuntimeException("Worker does not exist [workerName=" + workerName + "]");
        }

        return hours;
    }

    @Override
    public Work save(Work work) {
        return workRepository.save(work);
    }

    @Override
    public void deleteById(int id) {
        workRepository.deleteById(id);
    }

}

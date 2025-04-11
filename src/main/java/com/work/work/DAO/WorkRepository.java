package com.work.work.DAO;

import com.work.work.Entities.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work,Integer> {
}
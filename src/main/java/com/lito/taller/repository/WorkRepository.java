package com.lito.taller.repository;

import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
}

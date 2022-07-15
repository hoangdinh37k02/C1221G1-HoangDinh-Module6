package com.exam.repository;

import com.exam.model.LoaiTour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoaiTourRepository extends JpaRepository<LoaiTour, Integer> {
}

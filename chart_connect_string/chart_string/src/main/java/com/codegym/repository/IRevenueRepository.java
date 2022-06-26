package com.codegym.repository;

import com.codegym.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRevenueRepository extends JpaRepository<Revenue, Integer> {
}

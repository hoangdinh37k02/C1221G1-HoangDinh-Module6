package com.exam.service;

import com.exam.dto.ThongKe;
import com.exam.model.Tour;

import java.util.List;

public interface ITourService {
    List<Tour> getList();

    void save(Tour tour);

    Tour findById(int id);

    void deleteById(int id);

    List<ThongKe> getThongKe();
}

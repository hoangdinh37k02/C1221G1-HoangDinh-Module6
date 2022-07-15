package com.exam.service.impl;

import com.exam.dto.ThongKe;
import com.exam.model.Tour;
import com.exam.repository.ITourRepository;
import com.exam.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService implements ITourService {
    @Autowired
    private ITourRepository iTourRepository;

    @Override
    public List<Tour> getList() {
        return this.iTourRepository.findAll();
    }

    @Override
    public void save(Tour tour) {
        this.iTourRepository.save(tour);
    }

    @Override
    public Tour findById(int id) {
        return this.iTourRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        this.iTourRepository.deleteById(id);
    }

    @Override
    public List<ThongKe> getThongKe() {
        return this.iTourRepository.getThongKe();
    }
}

package com.exam.service.impl;

import com.exam.model.LoaiTour;
import com.exam.repository.ILoaiTourRepository;
import com.exam.service.ILoaiTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiTourService implements ILoaiTourService {
    @Autowired
    private ILoaiTourRepository iLoaiTourRepository;

    @Override
    public List<LoaiTour> getAll() {
        return this.iLoaiTourRepository.findAll();
    }
}

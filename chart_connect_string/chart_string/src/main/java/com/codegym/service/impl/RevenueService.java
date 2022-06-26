package com.codegym.service.impl;

import com.codegym.model.Revenue;
import com.codegym.repository.IRevenueRepository;
import com.codegym.service.IRevernueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService implements IRevernueService {
    @Autowired
    private IRevenueRepository iRevenueRepository;

    @Override
    public List<Revenue> getList() {
        return this.iRevenueRepository.findAll();
    }
}

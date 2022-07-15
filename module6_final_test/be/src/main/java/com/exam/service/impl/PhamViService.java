package com.exam.service.impl;

import com.exam.model.PhamVi;
import com.exam.repository.IPhamViRepository;
import com.exam.service.IPhamViService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhamViService implements IPhamViService {
    @Autowired
    private IPhamViRepository iPhamViRepository;

    @Override
    public List<PhamVi> getAll() {
        return this.iPhamViRepository.findAll();
    }
}

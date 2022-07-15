package com.codegym.service.impl;

import com.codegym.model.Type;
import com.codegym.repository.ITypeRepository;
import com.codegym.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository iTypeRepository;

    @Override
    public List<Type> getAll() {
        return this.iTypeRepository.findAll();
    }
}

package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.entity.user.UserRole;
import com.c1221g1.pharmacy.repository.user.IUserRoleRepository;
import com.c1221g1.pharmacy.service.user.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Override
    public void save(UserRole userRole) {
        this.iUserRoleRepository.save(userRole);
    }

    @Override
    public UserRole findUserRole(String username) {
        return this.iUserRoleRepository.findUserRoleByUsername(username);
    }
}

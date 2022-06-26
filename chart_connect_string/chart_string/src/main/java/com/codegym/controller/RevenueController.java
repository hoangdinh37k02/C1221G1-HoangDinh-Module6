package com.codegym.controller;

import com.codegym.model.Revenue;
import com.codegym.service.IRevernueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RevenueController {
    @Autowired
    private IRevernueService iRevernueService;
    @GetMapping("/list")
    public ResponseEntity<List<Revenue>> getList(){
        List<Revenue> revenueList = this.iRevernueService.getList();
        if (revenueList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(revenueList, HttpStatus.OK);
    }
}

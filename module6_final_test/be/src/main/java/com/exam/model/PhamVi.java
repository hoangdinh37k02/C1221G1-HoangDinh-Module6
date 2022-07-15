package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"tourList"})
public class PhamVi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenPhamVi;

    @OneToMany(mappedBy = "phamVi")
    private List<Tour> tourList;

    public PhamVi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenPhamVi() {
        return tenPhamVi;
    }

    public void setTenPhamVi(String tenPhamVi) {
        this.tenPhamVi = tenPhamVi;
    }

    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }
}

package com.exam.model;

import javax.persistence.*;

@Entity
public class DangKi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDangKi;
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "tour", referencedColumnName = "maTour")
    private Tour tour;
    @ManyToOne
    @JoinColumn(name = "thanh_vien", referencedColumnName = "maThanhVien")
    private ThanhVien thanhVien;

    public DangKi() {
    }

    public Integer getMaDangKi() {
        return maDangKi;
    }

    public void setMaDangKi(Integer maDangKi) {
        this.maDangKi = maDangKi;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public ThanhVien getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ThanhVien thanhVien) {
        this.thanhVien = thanhVien;
    }
}

package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"dangKiList"})
public class ThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThanhVien;
    private String tenThanhVien;
    @Column(columnDefinition = "Date")
    private String ngaysinh;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private String gioiTinh;

    @OneToMany(mappedBy = "thanhVien")
    private List<DangKi> dangKiList;

    public ThanhVien() {
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(Integer maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getTenThanhVien() {
        return tenThanhVien;
    }

    public void setTenThanhVien(String tenThanhVien) {
        this.tenThanhVien = tenThanhVien;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<DangKi> getDangKiList() {
        return dangKiList;
    }

    public void setDangKiList(List<DangKi> dangKiList) {
        this.dangKiList = dangKiList;
    }
}

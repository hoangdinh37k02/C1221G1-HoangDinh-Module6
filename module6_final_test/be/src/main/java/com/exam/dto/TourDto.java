package com.exam.dto;

import com.exam.model.LoaiTour;
import com.exam.model.PhamVi;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class TourDto {
    private Integer maTour;
    private String tenTour;
    private String diaDiem;
    private String ngayKhoiHanh;
    private String ngayVe;
    private String ngayKTDK;
    @Max(50)
    @Min(5)
    private Integer soNguoiToiDa;
    private String lichTrinh;
    private String yeuCauDT;
    private String chiPhi;
    private LoaiTour loaiTour;
    private PhamVi phamVi;

    public TourDto() {
    }

    public Integer getMaTour() {
        return maTour;
    }

    public void setMaTour(Integer maTour) {
        this.maTour = maTour;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(String ngayVe) {
        this.ngayVe = ngayVe;
    }

    public String getNgayKTDK() {
        return ngayKTDK;
    }

    public void setNgayKTDK(String ngayKTDK) {
        this.ngayKTDK = ngayKTDK;
    }

    public Integer getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(Integer soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public String getLichTrinh() {
        return lichTrinh;
    }

    public void setLichTrinh(String lichTrinh) {
        this.lichTrinh = lichTrinh;
    }

    public String getYeuCauDT() {
        return yeuCauDT;
    }

    public void setYeuCauDT(String yeuCauDT) {
        this.yeuCauDT = yeuCauDT;
    }

    public String getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(String chiPhi) {
        this.chiPhi = chiPhi;
    }

    public LoaiTour getLoaiTour() {
        return loaiTour;
    }

    public void setLoaiTour(LoaiTour loaiTour) {
        this.loaiTour = loaiTour;
    }

    public PhamVi getPhamVi() {
        return phamVi;
    }

    public void setPhamVi(PhamVi phamVi) {
        this.phamVi = phamVi;
    }
}

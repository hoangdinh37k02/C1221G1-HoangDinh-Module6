package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"dangKiList"})
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maTour;
    private String tenTour;
    private String diaDiem;
    @Column(columnDefinition = "Date")
    private String ngayKhoiHanh;
    @Column(columnDefinition = "Date")
    private String ngayVe;
    @Column(columnDefinition = "Date")
    private String ngayKTDK;
    private Integer soNguoiToiDa;
    private String lichTrinh;
    private String yeuCauDT;
    private String chiPhi;
    @ManyToOne
    @JoinColumn(name = "loai_tour", referencedColumnName = "id")
    private LoaiTour loaiTour;
    @ManyToOne
    @JoinColumn(name = "pham_vi", referencedColumnName = "id")
    private PhamVi phamVi;
    @OneToMany(mappedBy = "tour")
    private List<DangKi> dangKiList;

    public Tour() {
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

    public List<DangKi> getDangKiList() {
        return dangKiList;
    }

    public void setDangKiList(List<DangKi> dangKiList) {
        this.dangKiList = dangKiList;
    }
}

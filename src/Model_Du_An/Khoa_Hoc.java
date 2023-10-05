/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Du_An;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Khoa_Hoc {
      private String maKhoaHoc;
  private Chuyen_De chuyenDe; 
  private double hocPhi;
  private int thoiLuong;
  private Date ngayKhaiGiang;
  private String ghiChu;
  private Date ngayTao;
  private Nhan_Vien nhanVien;

    public Khoa_Hoc() {
    }

    public Khoa_Hoc(String maKhoaHoc, Chuyen_De chuyenDe, double hocPhi, int thoiLuong, Date ngayKhaiGiang, String ghiChu, Date ngayTao, Nhan_Vien nhanVien) {
        this.maKhoaHoc = maKhoaHoc;
        this.chuyenDe = chuyenDe;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ngayKhaiGiang = ngayKhaiGiang;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.nhanVien = nhanVien;
    }

    public Khoa_Hoc(String maKhoaHoc, Chuyen_De chuyenDe, double hocPhi, int thoiLuong, Date ngayKhaiGiang, String ghiChu, Nhan_Vien nhanVien) {
        this.maKhoaHoc = maKhoaHoc;
        this.chuyenDe = chuyenDe;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ngayKhaiGiang = ngayKhaiGiang;
        this.ghiChu = ghiChu;
        this.nhanVien = nhanVien;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public Chuyen_De getChuyenDe() {
        return chuyenDe;
    }

    public void setChuyenDe(Chuyen_De chuyenDe) {
        this.chuyenDe = chuyenDe;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Date getNgayKhaiGiang() {
        return ngayKhaiGiang;
    }

    public void setNgayKhaiGiang(Date ngayKhaiGiang) {
        this.ngayKhaiGiang = ngayKhaiGiang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Nhan_Vien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(Nhan_Vien nhanVien) {
        this.nhanVien = nhanVien;
    }
  
}

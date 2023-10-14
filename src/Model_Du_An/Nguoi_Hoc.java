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
public class Nguoi_Hoc {

    private String MaNguoiHoc;
 
    private String HoTen;
    private int GioiTinh;
    private Date NgaySinh;
    private String Email;
    private String DienThoai;
    private String GhiChu;
    private Nhan_Vien MaNhanVien;
    private Date NgayDangKy;

    public Nguoi_Hoc(String MaNguoiHoc, String HoTen, int GioiTinh, Date NgaySinh, String Email, String DienThoai, String GhiChu, Nhan_Vien MaNhanVien, Date NgayDangKy) {
        this.MaNguoiHoc = MaNguoiHoc;
       
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
        this.MaNhanVien = MaNhanVien;
        this.NgayDangKy = NgayDangKy;
    }

    public Nguoi_Hoc(String MaNguoiHoc,String HoTen, int GioiTinh, Date NgaySinh, String Email, String DienThoai, String GhiChu, Nhan_Vien MaNhanVien) {
        this.MaNguoiHoc = MaNguoiHoc;
        
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
        this.MaNhanVien = MaNhanVien;
    }
    
    public Nguoi_Hoc() {
    }

    public String getMaNguoiHoc() {
        return MaNguoiHoc;
    }

    public void setMaNguoiHoc(String MaNguoiHoc) {
        this.MaNguoiHoc = MaNguoiHoc;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Nhan_Vien getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(Nhan_Vien MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    public String Gioi_Tinh() {
        if (GioiTinh == 1) {
            return "Nam";
        } else if (GioiTinh == 0) {
            return "Nữ";
        } else {
            return "Giới tính thứ 3";
        }
    }
    public Object[] todata(){
        return new Object[]{this.MaNguoiHoc,this.HoTen,this.Gioi_Tinh(),this.NgaySinh,this.Email,this.DienThoai,this.GhiChu,this.MaNhanVien.getMa_NV(),this.NgayDangKy};
    }
}

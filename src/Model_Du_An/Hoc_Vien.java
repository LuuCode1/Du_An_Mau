/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Du_An;

/**
 *
 * @author Asus
 */
public class Hoc_Vien {
     private String maHocVien;

  private Nguoi_Hoc maNguoiHoc;

  private Khoa_Hoc maKhoaHoc;
  
  private double diem;

    public Hoc_Vien() {
    }

    public Hoc_Vien(String maHocVien, Nguoi_Hoc maNguoiHoc, Khoa_Hoc maKhoaHoc, double diem) {
        this.maHocVien = maHocVien;
        this.maNguoiHoc = maNguoiHoc;
        this.maKhoaHoc = maKhoaHoc;
        this.diem = diem;
    }

    public String getMaHocVien() {
        return maHocVien;
    }

    public void setMaHocVien(String maHocVien) {
        this.maHocVien = maHocVien;
    }

    public Nguoi_Hoc getMaNguoiHoc() {
        return maNguoiHoc;
    }

    public void setMaNguoiHoc(Nguoi_Hoc maNguoiHoc) {
        this.maNguoiHoc = maNguoiHoc;
    }

    public Khoa_Hoc getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(Khoa_Hoc maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
  
}

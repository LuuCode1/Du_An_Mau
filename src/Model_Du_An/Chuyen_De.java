/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Du_An;

/**
 *
 * @author Asus
 */
public class Chuyen_De {
    private String ma_CD;
    private String ten_CD;
    private double hoc_Phi;
    private int thoi_Luong;
    private String hinh;
    private String mo_Ta;

    public Chuyen_De() {
    }

    public Chuyen_De(String ma_CD, String ten_CD, double hoc_Phi, int thoi_Luong, String hinh, String mo_Ta) {
        this.ma_CD = ma_CD;
        this.ten_CD = ten_CD;
        this.hoc_Phi = hoc_Phi;
        this.thoi_Luong = thoi_Luong;
        this.hinh = hinh;
        this.mo_Ta = mo_Ta;
    }

    public String getMa_CD() {
        return ma_CD;
    }

    public void setMa_CD(String ma_CD) {
        this.ma_CD = ma_CD;
    }

    public String getTen_CD() {
        return ten_CD;
    }

    public void setTen_CD(String ten_CD) {
        this.ten_CD = ten_CD;
    }

    public double getHoc_Phi() {
        return hoc_Phi;
    }

    public void setHoc_Phi(double hoc_Phi) {
        this.hoc_Phi = hoc_Phi;
    }

    public int getThoi_Luong() {
        return thoi_Luong;
    }

    public void setThoi_Luong(int thoi_Luong) {
        this.thoi_Luong = thoi_Luong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMo_Ta() {
        return mo_Ta;
    }

    public void setMo_Ta(String mo_Ta) {
        this.mo_Ta = mo_Ta;
    }
    
}

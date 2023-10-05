/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Du_An;

/**
 *
 * @author Asus
 */
public class Nhan_Vien {
    private String ma_NV;
    private String ho_Ten;
    private String mat_Khau;
    private int vai_Tro;

    public Nhan_Vien() {
    }

    public Nhan_Vien(String ma_NV, String ho_Ten, String mat_Khau, int vai_Tro) {
        this.ma_NV = ma_NV;
        this.ho_Ten = ho_Ten;
        this.mat_Khau = mat_Khau;
        this.vai_Tro = vai_Tro;
    }

    public String getMa_NV() {
        return ma_NV;
    }

    public void setMa_NV(String ma_NV) {
        this.ma_NV = ma_NV;
    }

    public String getHo_Ten() {
        return ho_Ten;
    }

    public void setHo_Ten(String ho_Ten) {
        this.ho_Ten = ho_Ten;
    }

    public String getMat_Khau() {
        return mat_Khau;
    }

    public void setMat_Khau(String mat_Khau) {
        this.mat_Khau = mat_Khau;
    }

    public int getVai_Tro() {
        return vai_Tro;
    }

    public void setVai_Tro(int vai_Tro) {
        this.vai_Tro = vai_Tro;
    }

    public String Vaitro(){
        if (vai_Tro==1) {
            return "trưởng Phòng";
        }else{
            return "nhân viên";
        }
    }
    public Object[] todata(){
        return new Object[]{this.ma_NV,this.ho_Ten,this.mat_Khau,this.Vaitro()};
    }
}

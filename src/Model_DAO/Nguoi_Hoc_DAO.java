/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import java.sql.*;
import Model_Du_An.Nguoi_Hoc;
import Model_Du_An.Nhan_Vien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import service.DBconnect;

/**
 *
 * @author Asus
 */
public class Nguoi_Hoc_DAO extends DAO<Nguoi_Hoc, String> {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    @Override
    public int insert(Nguoi_Hoc nh) {
        sql = "INSERT INTO Nguoi_Hoc (Ma_Nguoi_Hoc, Ho_Ten, Gioi_Tinh, Ngay_Sinh, Email, Dien_Thoai, Ma_Nhan_Vien) VALUES (?,?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nh.getMaNguoiHoc());
            ps.setObject(2, nh.getHoTen());
            ps.setObject(3, nh.getGioiTinh());
            ps.setObject(4, nh.getNgaySinh());
            ps.setObject(5, nh.getEmail());
            ps.setObject(6, nh.getDienThoai());
            ps.setObject(7, nh.getMaNhanVien().getMa_NV());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }   
    }

    @Override
    public Nguoi_Hoc checkMa(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Nguoi_Hoc nh, String manh) {
        sql = "UPDATE Nguoi_Hoc \n"
                + "SET Ho_Ten = ?, Gioi_Tinh = ?, Ngay_Sinh = ?, \n"
                + "    Email = ?, Dien_Thoai = ?, Ghi_Chu = ?\n"
                + "WHERE Ma_Nguoi_Hoc = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nh.getHoTen());
            ps.setObject(2, nh.getGioiTinh());
            ps.setObject(3, nh.getNgaySinh());
            ps.setObject(4, nh.getEmail());
            ps.setObject(5, nh.getDienThoai());
            ps.setObject(6, nh.getGhiChu());
            ps.setObject(7, manh);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int delete(String ma) {
        sql = "DELETE FROM Nguoi_Hoc\n"
                + "WHERE Ma_Nguoi_Hoc = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Nguoi_Hoc> selectAll() {
        sql = "SELECT Nguoi_Hoc.Ma_Nguoi_Hoc, Nguoi_Hoc.Ho_Ten, Nguoi_Hoc.Gioi_Tinh, Nguoi_Hoc.Ngay_Sinh, Nguoi_Hoc.Email, Nguoi_Hoc.Dien_Thoai, Nguoi_Hoc.Ghi_Chu, Nhan_Vien.Ma_Nhan_Vien, Nguoi_Hoc.Ngay_Dang_Ky FROM Nhan_Vien INNER JOIN Nguoi_Hoc ON Nhan_Vien.Ma_Nhan_Vien = Nguoi_Hoc.Ma_Nhan_Vien";

        List<Nguoi_Hoc> list = new ArrayList<>();

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maNhanVien = rs.getString("Ma_Nhan_Vien");
                Nhan_Vien nv = new Nhan_Vien(maNhanVien, null, null, 0);

                String maNguoiHoc = rs.getString("Ma_Nguoi_Hoc");
                String hoTen = rs.getString("Ho_Ten");
                int gioiTinh = rs.getInt("Gioi_Tinh");
                Date ngaySinh = rs.getDate("Ngay_Sinh");
                String email = rs.getString("Email");
                String dienThoai = rs.getString("Dien_Thoai");
                String ghiChu = rs.getString("Ghi_Chu");
                Date ngayDangKy = rs.getDate("Ngay_Dang_Ky");

                Nguoi_Hoc nguoiHoc = new Nguoi_Hoc(maNguoiHoc, hoTen, gioiTinh, ngaySinh, email, dienThoai, ghiChu, nv, ngayDangKy);
                list.add(nguoiHoc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void SelectById(String ma) {
        List<Nguoi_Hoc> list = new ArrayList<>();
        sql = "SELECT Nguoi_Hoc.Ma_Nguoi_Hoc, Nguoi_Hoc.Ho_Ten, Nguoi_Hoc.Gioi_Tinh, Nguoi_Hoc.Ngay_Sinh, Nguoi_Hoc.Email, Nguoi_Hoc.Dien_Thoai, Nguoi_Hoc.Ghi_Chu, Nhan_Vien.Ma_Nhan_Vien, Nguoi_Hoc.Ngay_Dang_Ky FROM Nhan_Vien INNER JOIN Nguoi_Hoc ON Nhan_Vien.Ma_Nhan_Vien = Nguoi_Hoc.Ma_Nhan_Vien where Ma_Nhan_Vien =?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {                
                String maNhanVien = rs.getString("Ma_Nhan_Vien");
                Nhan_Vien nv = new Nhan_Vien(maNhanVien, null, null, 0);

                String maNguoiHoc = rs.getString("Ma_Nguoi_Hoc");
                String hoTen = rs.getString("Ho_Ten");
                int gioiTinh = rs.getInt("Gioi_Tinh");
                Date ngaySinh = rs.getDate("Ngay_Sinh");
                String email = rs.getString("Email");
                String dienThoai = rs.getString("Dien_Thoai");
                String ghiChu = rs.getString("Ghi_Chu");
                Date ngayDangKy = rs.getDate("Ngay_Dang_Ky");

                Nguoi_Hoc nguoiHoc = new Nguoi_Hoc(maNguoiHoc, hoTen, gioiTinh, ngaySinh, email, dienThoai, ghiChu, nv, ngayDangKy);
                list.add(nguoiHoc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ;
        }
        }

    @Override
    protected void selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public List<Nguoi_Hoc> SelectByMa(String ma) {
        List<Nguoi_Hoc> list = new ArrayList<>();
        sql = "SELECT Nguoi_Hoc.Ma_Nguoi_Hoc, Nguoi_Hoc.Ho_Ten, Nguoi_Hoc.Gioi_Tinh, Nguoi_Hoc.Ngay_Sinh,"
                + " Nguoi_Hoc.Email, Nguoi_Hoc.Dien_Thoai, Nguoi_Hoc.Ghi_Chu, Nhan_Vien.Ma_Nhan_Vien,"
                + " Nguoi_Hoc.Ngay_Dang_Ky FROM Nhan_Vien INNER JOIN Nguoi_Hoc ON Nhan_Vien.Ma_Nhan_Vien = Nguoi_Hoc.Ma_Nhan_Vien where Ma_Nguoi_Hoc =?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {                
                String maNhanVien = rs.getString("Ma_Nhan_Vien");
                Nhan_Vien nv = new Nhan_Vien(maNhanVien, null, null, 0);
                String maNguoiHoc = rs.getString("Ma_Nguoi_Hoc");
                String hoTen = rs.getString("Ho_Ten");
                int gioiTinh = rs.getInt("Gioi_Tinh");
                Date ngaySinh = rs.getDate("Ngay_Sinh");
                String email = rs.getString("Email");
                String dienThoai = rs.getString("Dien_Thoai");
                String ghiChu = rs.getString("Ghi_Chu");
                Date ngayDangKy = rs.getDate("Ngay_Dang_Ky");

                Nguoi_Hoc nguoiHoc = new Nguoi_Hoc(maNguoiHoc, hoTen, gioiTinh, ngaySinh, email, dienThoai, ghiChu, nv, ngayDangKy);
                list.add(nguoiHoc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        }
}

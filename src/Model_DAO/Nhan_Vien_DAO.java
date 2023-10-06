/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import java.sql.*;
import Model_Du_An.Nhan_Vien;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import service.DBconnect;

/**
 *
 * @author Asus
 */
public class Nhan_Vien_DAO extends DAO<Nhan_Vien, String> {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    

    @Override
    public int insert(Nhan_Vien sv) {
        sql = "insert into Nhan_Vien(Ma_Nhan_Vien,Mat_Khau,Ho_Ten,Vai_Tro) values (?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getMa_NV());
            ps.setObject(2, sv.getMat_Khau());
            ps.setObject(3, sv.getHo_Ten());
            ps.setObject(4, sv.getVai_Tro());
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        }

    @Override
    public int update(Nhan_Vien nv,String ma) {
        sql = "Update Nhan_Vien set Mat_Khau=? And Vai_Tro =? Where Ma_Nhan_Vien =?";
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Nhan_Vien> selectAll() {
        sql = "SELECT    Ma_Nhan_Vien, Mat_Khau, Ho_Ten, Vai_Tro FROM Nhan_Vien";
        List<Nhan_Vien> listNV = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Nhan_Vien nv = new Nhan_Vien(
                        rs.getString("Ma_Nhan_Vien"),
                        rs.getString("Mat_Khau"),
                        rs.getString("Ho_Ten"),
                        rs.getInt("Vai_Tro")
                );
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void SelectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Nhan_Vien userNameAndpassword(String ma, String pass) {
        String sql = "SELECT * FROM Nhan_Vien WHERE Ma_Nhan_Vien = ? AND Mat_Khau = ? ";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();

            if (rs.next()) {
                // tìm thấy tài khoản
                Nhan_Vien nv = new Nhan_Vien();
                nv.setMa_NV(rs.getString("Ma_Nhan_Vien"));
                nv.setMat_Khau(rs.getString("Mat_Khau"));
                return nv;

            }
            return null;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public Nhan_Vien checkMa(String ma) {
        sql ="SELECT    Ma_Nhan_Vien, Mat_Khau, Ho_Ten, Vai_Tro FROM Nhan_Vien WHERE Ma_Nhan_Vien = ?";
        Nhan_Vien nv = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {                
                nv = new Nhan_Vien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
         }
}

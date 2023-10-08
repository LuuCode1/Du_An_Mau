/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import java.sql.*;
import Model_Du_An.Nguoi_Hoc;
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
    public int insert(Nguoi_Hoc entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Nguoi_Hoc checkMa(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Nguoi_Hoc entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Nguoi_Hoc> selectAll() {
        sql = "SELECT    Ma_Nguoi_Hoc, Ho_Ten, Gioi_Tinh, Ngay_Sinh, Email, Dien_Thoai, Ghi_Chu\n" +
"FROM         Nguoi_Hoc";
        List<Nguoi_Hoc> ListNH = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Nguoi_Hoc nguoiHoc = new Nguoi_Hoc(rs.getString(1),null, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), null, null);
                ListNH.add(nguoiHoc);
            }
            return ListNH;
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

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import java.sql.*;
import Model_Du_An.Chuyen_De;
import java.util.ArrayList;
import java.util.List;
import service.DBconnect;

/**
 *
 * @author Asus
 */
public class Chuyen_De_DAO extends DAO<Chuyen_De, String> {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    @Override
    public int insert(Chuyen_De cd) {
        sql = "INSERT INTO Chuyen_De (Ma_Chuyen_De, Ten_Chuyen_De, Hoc_Phi, Thoi_Luong, Hinh, Mo_Ta) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cd.getMa_CD());
            ps.setObject(2, cd.getTen_CD());
            ps.setObject(3, cd.getHoc_Phi());
            ps.setObject(4, cd.getThoi_Luong());
            ps.setObject(5, cd.getHinh());
            ps.setObject(6, cd.getMo_Ta());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void update(Chuyen_De entity) {
        sql="UPDATE Chuyen_De SET Ten_Chuyen_De = ?, Hoc_Phi = ?, Thoi_Luong = ? WHERE Ma_Chuyen_De = ?";
        try {
            
        } catch (Exception e) {
        }
        }

    @Override
    public int delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Chuyen_De> selectAll() {
        sql = "SELECT  Ma_Chuyen_De, Ten_Chuyen_De, Hoc_Phi, Thoi_Luong, Hinh, Mo_Ta FROM Chuyen_De";
        List<Chuyen_De> listCD = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Chuyen_De cd = new Chuyen_De(
                        rs.getString("Ma_Chuyen_De"),
                        rs.getString("Ten_Chuyen_De"),
                        rs.getFloat("Hoc_Phi"),
                        rs.getInt("Thoi_Luong"),
                        rs.getString("Hinh"),
                        rs.getString("Mo_Ta")
                );
                listCD.add(cd);
            }
            return listCD;
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

    @Override
    public Chuyen_De checkMa(String maCD) {
        Chuyen_De cd = null;
        sql = "SELECT  Ma_Chuyen_De, Ten_Chuyen_De, Hoc_Phi, Thoi_Luong, Hinh, Mo_Ta FROM Chuyen_De where Ma_Chuyen_De =?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maCD);
            rs = ps.executeQuery();
            while (rs.next()) {
                cd = new Chuyen_De(
                        rs.getString("Ma_Chuyen_De"),
                        rs.getString("Ten_Chuyen_De"),
                        rs.getFloat("Hoc_Phi"),
                        rs.getInt("Thoi_Luong"),
                        rs.getString("Hinh"),
                        rs.getString("Mo_Ta"));

            }
            return cd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(Chuyen_De cd, String ma) {
        sql ="UPDATE Chuyen_De SET Ten_Chuyen_De = ?, Hoc_Phi = ?, Thoi_Luong = ?,Hinh =?,Mo_Ta =? WHERE Ma_Chuyen_De = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cd.getTen_CD());
            ps.setObject(2, cd.getHoc_Phi());
            ps.setObject(3, cd.getThoi_Luong());
            ps.setObject(4, cd.getHinh());
            ps.setObject(5, cd.getMo_Ta());
            ps.setObject(6, ma);
            return ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
         }

}

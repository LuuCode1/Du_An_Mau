/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package du_an;

import Model_DAO.Nhan_Vien_DAO;
import Model_Du_An.Nhan_Vien;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Quan_Ly_Nhan_Vien extends javax.swing.JFrame {

    Nhan_Vien_DAO nvd = new Nhan_Vien_DAO();
    Nhan_Vien nv = new Nhan_Vien();
    DefaultTableModel model;
    int mode = -1;

    /**
     * Creates new form Quan_Ly_Nhan_Vien
     */
    public Quan_Ly_Nhan_Vien() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillTable(nvd.selectAll());
        setDefaultCloseOperation(Quan_Ly_Nhan_Vien.DISPOSE_ON_CLOSE);
        name();
    }

    void name() {
        String[] table1 = {"MaNV", "Mật Khẩu", "Tên", "Vai Trò"};
        for (int i = 0; i < table1.length; i++) {
            tbl_bang.getColumnModel().getColumn(i).setHeaderValue(table1[i]);
        }
    }

    void fillTable(List<Nhan_Vien> list) {
        model = (DefaultTableModel) tbl_bang.getModel();
        model.setRowCount(0);
        for (Nhan_Vien nhan_Vien : list) {
            model.addRow(nhan_Vien.todata());
        }
    }

    void show(int index) {
        nv = nvd.selectAll().get(index);
        txtmanv.setText(nv.getMa_NV());
        txtname.setText(nv.getMat_Khau());
        txtpass.setText(nv.getHo_Ten());
        txtpass2.setText(nv.getHo_Ten());
        if (nv.getVai_Tro() == 1) {
            rboTp.setSelected(true);
        } else {
            rboNv.setSelected(true);
        }
    }

    Nhan_Vien read() {
        nv.setMat_Khau(txtpass.getText());
        nv.setMa_NV(txtmanv.getText());
        nv.setHo_Ten(txtname.getText());
        if (rboTp.isSelected()) {
            nv.setVai_Tro(1);
        } else {
            nv.setVai_Tro(0);
        }
        return nv;
    }

    void reset() {
        txtmanv.setText(null);
        txtname.setText(null);
        txtpass.setText(null);
        txtpass2.setText(null);
        rboNv.setSelected(true);

    }

    boolean check() {
        if (txtmanv.getText().equals(null)) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        } else if (txtmanv.getText().trim().length() < 3 || txtmanv.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(this, "Không hợp lệ");
            return false;

        } else if (!txtmanv.getText().trim().matches("[a-zA-Z0-9]+")) {
            JOptionPane.showMessageDialog(this, "Không được để kí tự đặc biệt");
            return false;
        }
        if (txtname.getText().equals(null)) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        } else if (!txtname.getText().trim().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Tên Không có Số");
            return false;
        }
        if (txtname.getText().equals(null)) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        } else if (txtpass.getText().trim().length() < 3 || txtpass.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(this, "Không hợp lệ");
            return false;
        }
        if (!txtpass2.getText().equals(txtpass.getText())) {
            JOptionPane.showMessageDialog(this, "Không trùng");
            return false;
        }
        return true;
    }

    void exit() {
        try {
            mode = tbl_bang.getSelectedRow();
            this.show(mode);
        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtmanv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rboTp = new javax.swing.JRadioButton();
        rboNv = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        tbn_reset = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        txtpass2 = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bang);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 186, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DANH SÁCH", jPanel6);

        txtmanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanvActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setText("Mật Khẩu");

        jLabel3.setText("Xác nhận lại mật khẩu");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel4.setText("Họ và tên");

        jLabel5.setText("Vai Trò");

        buttonGroup1.add(rboTp);
        rboTp.setText("Trưởng Phòng");

        buttonGroup1.add(rboNv);
        rboNv.setSelected(true);
        rboNv.setText("Nhân Viên");

        btn_add.setText("Thêm ");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel4.add(btn_add);

        btn_Update.setText("Sửa");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Update);

        btn_Delete.setText("Xóa");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Delete);

        tbn_reset.setText("Mới");
        tbn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_resetActionPerformed(evt);
            }
        });
        jPanel4.add(tbn_reset);

        jButton10.setText("|<");
        jButton10.setMaximumSize(new java.awt.Dimension(50, 30));
        jButton10.setMinimumSize(new java.awt.Dimension(40, 20));
        jButton10.setPreferredSize(new java.awt.Dimension(50, 23));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton10);

        jButton13.setText("<<");
        jButton13.setMaximumSize(new java.awt.Dimension(50, 30));
        jButton13.setMinimumSize(new java.awt.Dimension(40, 20));
        jButton13.setPreferredSize(new java.awt.Dimension(50, 23));
        jButton13.setRequestFocusEnabled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton13);

        jButton14.setText(">>");
        jButton14.setMaximumSize(new java.awt.Dimension(50, 30));
        jButton14.setMinimumSize(new java.awt.Dimension(40, 20));
        jButton14.setPreferredSize(new java.awt.Dimension(50, 23));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton14);

        jButton15.setText(">|");
        jButton15.setMaximumSize(new java.awt.Dimension(50, 30));
        jButton15.setMinimumSize(new java.awt.Dimension(40, 20));
        jButton15.setPreferredSize(new java.awt.Dimension(50, 23));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton15);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rboTp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rboNv, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtpass, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                                .addComponent(txtmanv)
                                .addComponent(txtpass2)
                                .addComponent(txtname))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 267, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpass2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rboTp)
                    .addComponent(rboNv))
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CẬP NHẬT", jPanel3);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangMouseClicked
        mode = tbl_bang.getSelectedRow();
        this.show(mode);
    }//GEN-LAST:event_tbl_bangMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (check()) {
            Nhan_Vien nv = this.read();
            if (nvd.checkMa(nv.getMa_NV()) != null) {
                JOptionPane.showMessageDialog(this, "mã trùng");
            } else {

                if (nvd.insert(nv) > 0) {
                    JOptionPane.showMessageDialog(this, "them thanh cong");
                    fillTable(nvd.selectAll());
                    this.reset();
                } else {
                    JOptionPane.showMessageDialog(this, "thêm thất bại");
                }
            }
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtmanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanvActionPerformed

    private void tbn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_resetActionPerformed
        this.reset();
    }//GEN-LAST:event_tbn_resetActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        if (check()) {
            Nhan_Vien nv = this.read();
            if (nvd.update(nv, nv.getMa_NV()) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                fillTable(nvd.selectAll());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
//        if (check()) {
        String nv = tbl_bang.getValueAt(mode, 0).toString();
        if (nvd.delete(nv) > 0) {
            JOptionPane.showMessageDialog(this, "delete thanh cong");
            fillTable(nvd.selectAll());
            this.reset();
        } else {
            JOptionPane.showMessageDialog(this, "delete thất bại");
        }
//        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        mode = 0; // Điều hướng đến bản ghi đầu tiên
        show(mode);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (mode > 0) {
            mode--; // Điều hướng đến bản ghi trước đó (nếu có)
            show(mode);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (mode < tbl_bang.getRowCount() - 1) {
            mode++; // Điều hướng đến bản ghi tiếp theo (nếu có)
            show(mode);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        mode = tbl_bang.getRowCount() - 1; // Điều hướng đến bản ghi cuối cùng
    show(mode);
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Nhan_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Nhan_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Nhan_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Nhan_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quan_Ly_Nhan_Vien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_add;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rboNv;
    private javax.swing.JRadioButton rboTp;
    private javax.swing.JTable tbl_bang;
    private javax.swing.JButton tbn_reset;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpass2;
    // End of variables declaration//GEN-END:variables
}

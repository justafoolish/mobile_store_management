/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author Gyn
 */
public class Payment extends javax.swing.JFrame {
    private static String maHD;
    private QuanLyChiTietHoaDonBus qlcthdBUS;
    private QuanLyKhachHangBUS qlkhBUS;
    private QuanLyHoaDonBUS qlhdBUS;
    private QuanLyNhanVienBUS qlnvBUS;
    private QuanLySanPhamBUS qlspBUS;
    private String tenKH;
    private String tenNV;
    private int total;

    /**
     * Creates new form Payment
     */
    public Payment() {
        initComponents();
        qlcthdBUS = new QuanLyChiTietHoaDonBus();
        qlhdBUS = new QuanLyHoaDonBUS();
        qlkhBUS = new QuanLyKhachHangBUS();
        qlnvBUS = new QuanLyNhanVienBUS();
        qlspBUS = new QuanLySanPhamBUS();
    }
    public void getTenNV() {
        String maNV = qlhdBUS.getMaNV(maHD);
        System.out.println(maNV);
        tenNV = qlnvBUS.getTenNV(maNV);
    }
    public void getTenKH() {
        String maKH = qlhdBUS.getMaKH(maHD);
        System.out.println(maKH);
        tenKH = qlkhBUS.getTenKH(maKH);
    }
    public void getTotal() {
        total = qlhdBUS.getTotal(maHD);
    }
    public void initReceipt() {
        jTextArea2.setEditable(false);
        jTextArea2.setText("*************************** Hóa Đơn Thanh Toán ************************\n");
        jTextArea2.append("\nMã hóa đơn: " + maHD + "\n");
        jTextArea2.append("\nTên khách hàng: " + tenKH + "\n");
        jTextArea2.append("\nTên nhân viên: " + tenNV + "\n");
        jTextArea2.append("\nDanh sách mua hàng\n");
        jTextArea2.append("—————————————————————————————\n");
        String header = String.format("%-40s%-10s%-10s\n", "Sản Phẩm","SL","Thành Tiền");



        jTextArea2.append(header);
        for(ChiTietHoaDon cthd : qlcthdBUS.getCTbyID(maHD)) {
            String tenSP = qlspBUS.getPName(cthd.getMaSanPham());
            int soLuong = cthd.getSoLuong();
            int tongTien = cthd.getThanhTien();
            String pInfo = String.format("\n%-40s%-10d%-10d\n", tenSP.trim(),soLuong,tongTien);
            jTextArea2.append(pInfo);

        }
        jTextArea2.append("—————————————————————————————\n");
        HoaDon hd = qlhdBUS.getHoaDon(maHD);
        jTextArea2.append("Chiết khấu: " + hd.getTongTienGiamGia() +"\n");
        jTextArea2.append("\nTổng tiền: " + hd.getTongTien() + "\n");


    }
    public void setUpReceipt(String maHD) {
        this.maHD = maHD;

        getTenNV();
        getTenKH();
        getTotal();

        initReceipt();

        jTextField1.setText(tenNV);
        jTextField3.setText(String.valueOf(total));
    }
    public void setMaHD(String maHD) {
        Payment.maHD = maHD;
    }
   
    public void print() {
        System.out.println(maHD);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Tên khách hàng:");

        jLabel2.setText("Số tiền khách đưa:");

        jLabel3.setText("Tổng tiền phải trả:");

        jLabel4.setText("Tiền thừa:");

        jTextField1.setEditable(false);

        jTextField2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField2InputMethodTextChanged(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jTextField3.setEditable(false);

        jTextField4.setEditable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/icons8_order_history_30px.png"))); // NOI18N
        jButton1.setText("Xuất hoá đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tình trạng");

        jLabel6.setFont(new java.awt.Font("iCiel Novecento sans SemBd", 1, 36)); // NOI18N
        jLabel6.setText("Thanh Toán");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("*************************** Hóa Đơn Thanh Toán ************************\n\nMã hóa đơn: \n\nTên khách hàng: \n\nTên nhân viên:\n\nDanh sách mua hàng\n———————————————————————————————————\nTên sản phẩm \t| \tSố lượng \t| \tGiá thành\n\n\n———————————————————————————————————\nSố tiền giảm:\n\nTổng tiền:");
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTextField4.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Nhập số tiền nhận từ khách");
        }
        else {
            String file = maHD + ".txt";

            try (BufferedWriter fileOut = new BufferedWriter(new FileWriter(file))) {
                jTextArea2.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField2InputMethodTextChanged
        // TODO add your handling code here:
        int get = Integer.parseInt(jTextField2.getText().trim());
        if(get >= total) {
            jTextField4.setText(String.valueOf(get-total));
        }
    }//GEN-LAST:event_jTextField2InputMethodTextChanged

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        int get = Integer.parseInt(jTextField2.getText().trim());
        if(get >= total) {
            int sub = get - total;
            jTextField4.setText(String.valueOf(sub));
            jTextArea2.append("\nNhận tiền: " + get + "\n");
            jTextArea2.append("\nTiền thừa: " + sub + "\n");
        }
    }//GEN-LAST:event_jTextField2KeyPressed

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
           UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (Exception e) {
            System.out.println(e);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}

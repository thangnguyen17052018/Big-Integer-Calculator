/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigcalculator;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL OS
 */
public class ResultForm extends javax.swing.JFrame {
    public Calculation calc;
    private MainCalc previousMain;
    /**
     * Creates new form ResultForm
     */
    public ResultForm() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL OS\\Desktop\\BigCalculator\\src\\bigcalculator\\img\\iconframe1.png");    
        setIconImage(icon);    
        setTitle("BigInteger Calculator");
    }
    
    public ResultForm(MainCalc c, Calculation ca) {
        initComponents();
        this.previousMain = c;
        this.calc = ca;
        operatorLabel.setText(String.valueOf(this.calc.getOperator()));
        if (this.calc.getNum1().getSign() == true)
            number1Txt.setText("-"+this.calc.getNum1().toString());
        else
            number1Txt.setText(this.calc.getNum1().toString());
        
        if (this.calc.getNum2().getSign() == true)
            number2Txt.setText("-"+this.calc.getNum2().toString());
        else
            number2Txt.setText(this.calc.getNum2().toString());
        
        if (this.calc.getAns().getSign() == true)
            resultTxt.setText("-"+this.calc.getAns().toString());
        else {
            resultTxt.setText(this.calc.getAns().toString());   
        }
        remainder.setVisible(false);
        jScrollPane4.setVisible(false);
        remainderTxt.setVisible(false);
        System.out.println(this.calc.getOperator().charAt(0));
        if (this.calc.getOperator().charAt(0) == ':') {
            System.out.println("CHIA");
            remainder.setEnabled(true);
            remainderTxt.setEnabled(true);
            remainderTxt.setText(this.calc.getRemainder().toString());
            remainder.setVisible(true);
            jScrollPane4.setVisible(true);
            remainderTxt.setVisible(true);
        }

        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        operatorLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        number1Txt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        number2Txt = new javax.swing.JTextArea();
        equalLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTxt = new javax.swing.JTextArea();
        remainder = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        remainderTxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/icons8-back-to-48.png"))); // NOI18N
        backBtn.setText("Quay l???i");
        backBtn.setToolTipText("");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        insertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/database.png"))); // NOI18N
        insertBtn.setText("L??u v??o CSDL");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        exportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/file.png"))); // NOI18N
        exportBtn.setText("Xu???t file");
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("UTM Swiss Condensed", 1, 22)); // NOI18N
        jLabel1.setText("K???T QU???");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        operatorLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        operatorLabel.setText("+");

        number1Txt.setColumns(20);
        number1Txt.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        number1Txt.setRows(5);
        jScrollPane1.setViewportView(number1Txt);

        number2Txt.setColumns(20);
        number2Txt.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        number2Txt.setRows(5);
        jScrollPane2.setViewportView(number2Txt);

        equalLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        equalLabel.setText("=");

        resultTxt.setColumns(20);
        resultTxt.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        resultTxt.setRows(5);
        jScrollPane3.setViewportView(resultTxt);

        remainder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        remainder.setText("d??");
        remainder.setEnabled(false);
        remainder.setOpaque(true);

        remainderTxt.setColumns(20);
        remainderTxt.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        remainderTxt.setRows(5);
        remainderTxt.setEnabled(false);
        jScrollPane4.setViewportView(remainderTxt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(remainder)
                    .addComponent(equalLabel)
                    .addComponent(operatorLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(operatorLabel)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(equalLabel)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(remainder)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exportBtn)
                        .addComponent(insertBtn)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.previousMain.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        String dbURL = "jdbc:mysql://localhost/big_calculator";
        String username = "root";
        String password = "";
        try (Connection connection = DriverManager.getConnection(dbURL, username, password)){
            Statement stmt;
            Class.forName("com.mysql.jdbc.Driver");

            stmt = connection.createStatement();
            String sql = "INSERT INTO datacalculate (m, n, type, result, remainder, date_calc) " +
                    "VALUES ('" + number1Txt.getText()  + "','"+ number2Txt.getText() +"','"+ operatorLabel.getText() +"','"+ resultTxt.getText() +"','"+ remainderTxt.getText() +"', now())";
            stmt.executeUpdate(sql);

        } catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"Insert v??o database th??nh c??ng !!!");  
    }//GEN-LAST:event_insertBtnActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        try {
            FileWriter fw = new FileWriter("C:\\Users\\DELL OS\\Desktop\\BigCalculator\\src\\bigcalculator\\file\\output.txt");
            fw.write("a = " + number1Txt.getText()+"\n");
            fw.write("b = " + number2Txt.getText() +"\n");
            fw.write("a " + operatorLabel.getText() + " b -> K???t qu???: ");
            fw.write(resultTxt.getText() + "\n");
            if (operatorLabel.getText().charAt(0) == ':')
                fw.write("D??: " + remainderTxt.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,"Xu???t file th??nh c??ng !!!");  
    }//GEN-LAST:event_exportBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel equalLabel;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea number1Txt;
    private javax.swing.JTextArea number2Txt;
    private javax.swing.JLabel operatorLabel;
    private javax.swing.JLabel remainder;
    private javax.swing.JTextArea remainderTxt;
    private javax.swing.JTextArea resultTxt;
    // End of variables declaration//GEN-END:variables
}

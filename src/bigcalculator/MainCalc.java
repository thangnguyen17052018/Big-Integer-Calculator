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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL OS
 */
public class MainCalc extends javax.swing.JFrame {
    
    public Calculation calc;
    /**
     * Creates new form MainCalc
     */
    public MainCalc() {
        initComponents();
        calc = new Calculation();
        jRadioButton1.setActionCommand("+");
        jRadioButton2.setActionCommand("-");
        jRadioButton3.setActionCommand("x");
        jRadioButton4.setActionCommand(":");
        jRadioButton1.setSelected(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL OS\\Desktop\\BigCalculator\\src\\bigcalculator\\img\\iconframe1.png");    
        setIconImage(icon);    
        setTitle("BigInteger Calculator");
//        System.out.println(buttonGroup1.getSelection().getActionCommand());
    }
    
    public MainCalc(String number1, String number2, String operator) {
        initComponents();
        calc = new Calculation();
        jRadioButton1.setActionCommand("+");
        jRadioButton2.setActionCommand("-");
        jRadioButton3.setActionCommand("x");
        jRadioButton4.setActionCommand(":");
        if (jRadioButton1.getActionCommand().equals(operator))
            jRadioButton1.setSelected(true);
        else if (jRadioButton2.getActionCommand().equals(operator))
                jRadioButton2.setSelected(true);
            else if (jRadioButton3.getActionCommand().equals(operator))
                    jRadioButton3.setSelected(true);
                else
                    jRadioButton4.setSelected(true);
        number1Txt.setText(number1);
        number2Txt.setText(number2);
//        System.out.println(buttonGroup1.getSelection().getActionCommand());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        calcBtn = new javax.swing.JButton();
        inputFileBtn = new javax.swing.JButton();
        inputDbBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        number1Txt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        number2Txt = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("TÍNH TOÁN");

        calcBtn.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        calcBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/calc666666.png"))); // NOI18N
        calcBtn.setText("Tính");
        calcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcBtnActionPerformed(evt);
            }
        });

        inputFileBtn.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        inputFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/txt.png"))); // NOI18N
        inputFileBtn.setText("Nhập File");
        inputFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFileBtnActionPerformed(evt);
            }
        });

        inputDbBtn.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        inputDbBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/icons8-database-48.png"))); // NOI18N
        inputDbBtn.setText("Nhập từ CSDL");
        inputDbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDbBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(218, 238, 239));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        number1Txt.setColumns(20);
        number1Txt.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        number1Txt.setRows(5);
        jScrollPane1.setViewportView(number1Txt);
        number1Txt.getAccessibleContext().setAccessibleDescription("");

        number2Txt.setColumns(20);
        number2Txt.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        number2Txt.setRows(5);
        jScrollPane2.setViewportView(number2Txt);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel1.setText("Số A");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Số B");

        jPanel2.setBackground(new java.awt.Color(199, 199, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn phép tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 51, 0));

        jRadioButton1.setBackground(new java.awt.Color(199, 199, 226));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jRadioButton1.setText("Phép Cộng");
        jRadioButton1.setName(""); // NOI18N

        jRadioButton2.setBackground(new java.awt.Color(199, 199, 226));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jRadioButton2.setText("Phép Trừ");

        jRadioButton3.setBackground(new java.awt.Color(199, 199, 226));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jRadioButton3.setText("Phép Nhân");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(199, 199, 226));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jRadioButton4.setText("Phép Chia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jRadioButton1)
                .addGap(86, 86, 86)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jRadioButton3)
                .addGap(83, 83, 83)
                .addComponent(jRadioButton4)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setForeground(new java.awt.Color(204, 204, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/ques1.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        refreshBtn.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bigcalculator/img/refresh.png"))); // NOI18N
        refreshBtn.setText("Làm Mới");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(306, 306, 306)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(inputFileBtn)
                        .addGap(40, 40, 40)
                        .addComponent(inputDbBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputDbBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void inputFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFileBtnActionPerformed
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        String path = dialog.getDirectory() + dialog.getFile();
        File file1 = new File(path);//lấy ra file dữ liệu, nếu không hợp lệ sẽ xảy ra ngoại lệ IO
 
       try{
            InputStream inputStream;
            inputStream = new FileInputStream(file1); //khởi tạo một FileInputStream để chuẩn bị cho việc đọc file
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//từ file inputStream tạo ra một đối tượng có thể đọc được (đọc từng kí tự)
            BufferedReader reader = new BufferedReader(inputStreamReader);//sử dụng để tăng hiệu suất đọc (nhờ readline())->đọc văn bản từ một input stream dựa trên các ký tự  
//            String line = "";
//            while((line = reader.readLine()) != null){
//                System.out.println(line);
//            }
            number1Txt.setText(reader.readLine());
            number2Txt.setText(reader.readLine());
            System.out.println(number1Txt.getText());
            System.out.println(number2Txt.getText());
        } catch(IOException ioException){
            //ioException.printStackTrace();
        }
        
    }//GEN-LAST:event_inputFileBtnActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void inputDbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDbBtnActionPerformed
        // TODO add your handling code here:
        DataForm datafrm = new DataForm(this);
        this.setVisible(false);
        datafrm.pack();
        datafrm.setLocationRelativeTo(null);
        datafrm.setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL OS\\Desktop\\BigCalculator\\src\\bigcalculator\\img\\iconframe1.png");    
        datafrm.setIconImage(icon);    
        datafrm.setTitle("Data Form");
    }//GEN-LAST:event_inputDbBtnActionPerformed

    private void calcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcBtnActionPerformed
        // TODO add your handling code here:
        String str1 = number1Txt.getText();
        String str2 = number2Txt.getText();
        
        if (str1.equals("") || str2.equals("")){
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"Không được để trống !!!");  
        } else {
            char ope = buttonGroup1.getSelection().getActionCommand().toCharArray()[0];
            this.calc = new Calculation();
            this.calc.readCalc1(str1, str2, ope);
            ResultForm rf = new ResultForm(this, this.calc);
            rf.setVisible(true);
            rf.pack();
            rf.setLocationRelativeTo(null);
            Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL OS\\Desktop\\BigCalculator\\src\\bigcalculator\\img\\iconframe1.png");    
            rf.setIconImage(icon);    
            rf.setTitle("BigInteger Calculator");
            this.setVisible(false);            
        }
    }//GEN-LAST:event_calcBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        number1Txt.setText("");
        number2Txt.setText("");
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,"Bạn hãy nhập hai số nguyên lớn ở hai textArea và chọn phép tính để tính nhé ! Ta có thể nhập kể cả số âm nhé.\n"
                + "1.Chọn 'Tính' để thực hiện phép tính (Không được nhập trống nhé!!!)\n"
                + "2.Chọn 'Làm Mới' để làm mới 2 textArea và đưa lựa chọn phép toán về mặc định.\n"
                + "3.Chọn 'Nhập File' để chọn file input nhập vào.\n"
                + "4.Chọn 'Nhập từ Database' để chọn dữ liệu nhập vào từ cơ sở dữ liệu.");
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(MainCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainCalc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calcBtn;
    private javax.swing.JButton inputDbBtn;
    private javax.swing.JButton inputFileBtn;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea number1Txt;
    private javax.swing.JTextArea number2Txt;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}

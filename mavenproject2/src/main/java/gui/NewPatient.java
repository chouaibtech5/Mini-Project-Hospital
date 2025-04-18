package gui;

import models.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class NewPatient extends javax.swing.JFrame {
    private Object cmbPatientType;  
    private JCheckBox chkOutpatient;
    private JCheckBox chkEmergency;
    private JTextArea txtPatientCondition;
    private javax.swing.JCheckBox chkInpatient;
    private JTable patientTable;
    private DefaultTableModel tableModel;
    private HospitalRecordManager hospitalRecordManager;
    private ArrayList<Patient> patientList = new ArrayList<>();

    public NewPatient(HospitalRecordManager hospitalRecordManager) {
        initComponents();
        this.hospitalRecordManager = hospitalRecordManager;
        initBlockComboBox() ; 
        
        // Initialize text area for condition
        
        txtPatientCondition = new JTextArea(5, 20);
        txtPatientCondition.setLineWrap(true);
        txtPatientCondition.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtPatientCondition);
        getContentPane().add(scrollPane);
        // Initialize checkboxes
        chkInpatient = jCheckBox1;
        chkOutpatient = jCheckBox2;
        chkEmergency = jCheckBox3;
        
        // Initialize table model
        String[] columnNames = {"Name", "Age", "Type", "Condition"};
        tableModel = new DefaultTableModel(columnNames, 0);
        
        pack();
    }
    private void initBlockComboBox() {
    Hospital hospital = HospitalRecordManager.getCurrentHospital();
    if (hospital != null) {
        jComboBox3.removeAllItems();
        for (HospitalBlock block : hospital.getBlocks()) {
            jComboBox3.addItem(block.getBlockName());
        }
    }
}

    private void clearFields() {
        txtPatientName.setText("");
        txtPatientAge.setText("");
        txtPatientCondition.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtPatientAge = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDays = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDailyRate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtConsultationFee = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmergencyFee = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAdditionalCharges = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Add New Patient");

        jLabel8.setText(" Name :");

        jLabel9.setText("Gender :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "f" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Age :");

        txtPatientAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientAgeActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Block Location  :");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jCheckBox1.setText("Inpatient");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jCheckBox2.setText("Outpatient");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jCheckBox3.setText("Emergency");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("Days (Inp) :");

        txtDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaysActionPerformed(evt);
            }
        });

        jLabel13.setText("Daily rate :(Inp) :");

        txtDailyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDailyRateActionPerformed(evt);
            }
        });

        jLabel14.setText("Consultation fee (out):");

        txtConsultationFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultationFeeActionPerformed(evt);
            }
        });

        jLabel15.setText("emergency fee(eme) :");

        txtEmergencyFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmergencyFeeActionPerformed(evt);
            }
        });

        jLabel16.setText("Additional Charges(eme) :");

        txtAdditionalCharges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdditionalChargesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDailyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtConsultationFee, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmergencyFee, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAdditionalCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtDailyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtConsultationFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEmergencyFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtAdditionalCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
         txtAdditionalCharges.setVisible(false);
          txtConsultationFee.setVisible(false);
          txtDays.setVisible(true);
          txtDailyRate.setVisible(true);
          txtEmergencyFee.setVisible(false);
           
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        
         txtAdditionalCharges.setVisible(false);
          txtConsultationFee.setVisible(true);
          txtDays.setVisible(false);
          txtDailyRate.setVisible(false);
          txtEmergencyFee.setVisible(false);
          
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
           txtAdditionalCharges.setVisible(true);
          txtConsultationFee.setVisible(false);
          txtDays.setVisible(false);
          txtDailyRate.setVisible(false);
          txtEmergencyFee.setVisible(true);
        
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         try {
        // Get input values
        String name = txtPatientName.getText();
        int age = Integer.parseInt(txtPatientAge.getText());
        String gender = jComboBox2.getSelectedItem().toString();
        String blockName = jComboBox3.getSelectedItem().toString();
//        String daysText = txtDays.getText().trim();
//        String dailyRateText = txtDailyRate.getText().trim();
//        String consultationFeeText = txtConsultationFee.getText().trim();
//        String emergencyFeeText = txtEmergencyFee.getText().trim();
//        String additionalChargesText = txtAdditionalCharges.getText().trim();

        
        // Get current hospital
        Hospital hospital = HospitalRecordManager.getCurrentHospital();
        if (hospital == null) {
            JOptionPane.showMessageDialog(this, "Hospital not configured!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Find the selected block
        HospitalBlock selectedBlock = null;
        for (HospitalBlock block : hospital.getBlocks()) {
            if (block.getBlockName().equals(blockName)) {
                selectedBlock = block;
                break;
            }
        }
        
        if (selectedBlock == null) {
            JOptionPane.showMessageDialog(this, "Invalid block selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Create appropriate patient type
        Patient newPatient;
         double totalBill = 0; 
        if (jCheckBox1.isSelected()) { // Inpatient
              
             int dailyCharge = Integer.parseInt(txtDays.getText());
            double numberOfDaysAdmitted = Double.parseDouble(txtDailyRate.getText());
            Inpatient inpatient = new Inpatient(name, age, gender, 
                selectedBlock, "RM-101", "2023-01-01", dailyCharge, (int) numberOfDaysAdmitted);
            totalBill = inpatient.calculateBill();
            newPatient = inpatient;
            
        } 
        else if (jCheckBox2.isSelected()) { // Outpatient
        
             double consultationFee = Double.parseDouble(txtConsultationFee.getText());
            
            Outpatient outpatient = new Outpatient(name, age, gender, 
                selectedBlock, "2023-01-01", consultationFee);
            totalBill = outpatient.calculateBill();
            newPatient = outpatient;
        } 
        else if (jCheckBox3.isSelected()) { // Emergency
             double emergencyFee = Double.parseDouble(txtEmergencyFee.getText());
            double additionalCharges = Double.parseDouble(txtAdditionalCharges.getText());
            
            EmergencyPatient emergencyPatient = new EmergencyPatient(name, age, gender, selectedBlock ,"RM-101"  ,emergencyFee, additionalCharges);
            totalBill = emergencyPatient.calculateBill();
            newPatient = emergencyPatient;
        } 
        else {
            JOptionPane.showMessageDialog(this, "Select patient type!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
           if (!jCheckBox1.isSelected()) {
        
        txtDays.setText("");
        txtDailyRate.setText("");
        
    }
    if (!jCheckBox2.isSelected()) {
        txtConsultationFee.setText("");
    }
    if (!jCheckBox3.isSelected()) {
        txtEmergencyFee.setText("");
        txtAdditionalCharges.setText("");
    }

        
        // Add patient to system
        HospitalRecordManager.addPatient(newPatient);
        JOptionPane.showMessageDialog(this, "Patient added successfully!");
        this.dispose();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid age format!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtPatientAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientAgeActionPerformed

    private void txtDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaysActionPerformed

    private void txtDailyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDailyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDailyRateActionPerformed

    private void txtConsultationFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultationFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultationFeeActionPerformed

    private void txtEmergencyFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmergencyFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmergencyFeeActionPerformed

    private void txtAdditionalChargesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdditionalChargesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdditionalChargesActionPerformed

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
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               HospitalRecordManager hrm = new HospitalRecordManager();
                new NewPatient(hrm).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAdditionalCharges;
    private javax.swing.JTextField txtConsultationFee;
    private javax.swing.JTextField txtDailyRate;
    private javax.swing.JTextField txtDays;
    private javax.swing.JTextField txtEmergencyFee;
    private javax.swing.JTextField txtPatientAge;
    private javax.swing.JTextField txtPatientName;
    // End of variables declaration//GEN-END:variables

    private void print(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

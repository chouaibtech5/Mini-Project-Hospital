package gui;
import models.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HospitalRecordManager extends javax.swing.JFrame {
    // Data
    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static Hospital hospital;
    private static HospitalRecordManager instance;
    private static Hospital currentHospital;
    
    
    // UI Components - Preserving your exact variable names
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientTable;
    private javax.swing.JLabel lblHospitalName;
    private javax.swing.JLabel lblHospitalCapacity;
    private javax.swing.JLabel lblHospitalState;
    private javax.swing.JTextField jTextField1;
private javax.swing.JLabel jLabel6;
private javax.swing.JButton jButton5;
private javax.swing.JButton btnDelete;
private javax.swing.JLabel jLabel7;
private javax.swing.JButton jButton6;
private javax.swing.JComboBox<String> jComboBox3;

// Add these to your class variables
private javax.swing.JComboBox<String> cmbHospitals;



   public HospitalRecordManager() {
    initComponents();
    instance = this;
    

    
    // Initialize with default hospital if none exists
    if(currentHospital == null) {
        currentHospital = createDefaultHospital();
    }
   

    
    setupTable();
    setupFilters();
    refreshHospitalData();
    
  

    jTextField1.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) { search(); }
    public void removeUpdate(DocumentEvent e) { search(); }
    public void insertUpdate(DocumentEvent e) { search(); }
    
    private void search() {
        if (jTextField1.getText().trim().isEmpty()) {
            refreshPatientTable(); // Show all if search is empty
        } else {
            btnSearchActionPerformed(null); // Trigger search
        }
    }
});
  
}

   private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                         
    String searchTerm = jTextField1.getText().trim().toLowerCase();
    String selectedBlock = jComboBox1.getSelectedItem().toString();
    String selectedType = jComboBox2.getSelectedItem().toString();
    
    DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
    model.setRowCount(0);
    
    for (Patient patient : patientList) {
        boolean nameMatch = searchTerm.isEmpty() || 
                          patient.getName().toLowerCase().contains(searchTerm);
        boolean blockMatch = selectedBlock.equals("All") || 
                           (patient.getLocation() != null && 
                            patient.getLocation().getBlockName().equals(selectedBlock));
        boolean typeMatch = selectedType.equals("All") || 
                           getPatientType(patient).equals(selectedType);
        
        if (nameMatch && blockMatch && typeMatch) {
            model.addRow(createPatientRow(patient));
        }
    }
    
    if (model.getRowCount() == 0 && !searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No matching patients found", 
                                    "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }
}

private Hospital createDefaultHospital() {
    Hospital hospital = new Hospital("Unnamed Hospital", 50, "Unknown State");
    hospital.addBlock(new HospitalBlock("General", 1, "General Medicine"));
    return hospital;
}
     public static Hospital getCurrentHospital() {
        return currentHospital;
    }
      public static void setCurrentHospital(Hospital hospital) {
        currentHospital = hospital;
        if(instance != null) {
            instance.refreshHospitalData();
       
            
        }
    }
      private void initBlockComboBox() {
    Hospital hospital = HospitalRecordManager.getCurrentHospital();
    if (hospital != null) {
        jComboBox1.removeAllItems();
         jComboBox1.addItem("All");
        for (HospitalBlock block : hospital.getBlocks()) {
            jComboBox1.addItem(block.getBlockName());
        }
    }
}
       private void refreshHospitalData() {
        if(currentHospital != null) {
            // Make sure these labels exist in your form
            if(lblHospitalName != null) {
                lblHospitalName.setText("Hospital: " + currentHospital.getName());
            }
            if(lblHospitalCapacity != null) {
                lblHospitalCapacity.setText("Capacity: " + currentHospital.getMaxPatients());
            }
            if(lblHospitalState != null) {
                lblHospitalState.setText("State: " + currentHospital.getState());
            }
          
            // Refresh any patient tables or other UI elements
            refreshPatientTable();
        }
    }
    private void setupTable() {
        patientTable.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Name", "Age", "Gender", "Type", "Location" , "Bill"}
        ));
    }
    private  void setupFilters() {
        // Clear existing items
        jComboBox2.removeAllItems();
        jComboBox1.removeAllItems();
        
        // Add patient types
        jComboBox2.addItem("All");
        jComboBox2.addItem("Inpatient");
        jComboBox2.addItem("Outpatient");
        jComboBox2.addItem("Emergency");
        
        // Add hospital blocks
        jComboBox1.addItem("All");
        Hospital  blocksint = HospitalRecordManager.getCurrentHospital();
        if (blocksint != null) {
            for (HospitalBlock block : blocksint.getBlocks()) {
                jComboBox1.addItem(block.getBlockName());
            }
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Hospital Patient Record System");

        jButton1.setText("Add Patient");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Hospitol Information");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
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
        patientTable.setToolTipText("");
        jScrollPane1.setViewportView(patientTable);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setText("Patient List");

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel3.setText("Search & Filter :");

        jLabel4.setText("search : ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Filter By Patient Type : ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Show filter result ");
        jButton4.setActionCommand("Show filter result ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Filter By Block : ");

        jButton5.setText("Show search result ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Patient");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
 NewPatient newPatientWindow = new NewPatient(this);
newPatientWindow.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     HospitalInformation hospitalInfo = new HospitalInformation();
     hospitalInfo.setVisible(true);
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String selectedBlock = jComboBox1.getSelectedItem().toString();
        String selectedType = jComboBox2.getSelectedItem().toString();
        
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        model.setRowCount(0);
        
        for (Patient p : patientList) {
            boolean blockMatch = selectedBlock.equals("All") || 
                               p.getLocation().getBlockName().equals(selectedBlock);
            boolean typeMatch = selectedType.equals("All") || 
                               p.getClass().getSimpleName().equals(selectedType);
            
            if (blockMatch && typeMatch) {
                model.addRow(new Object[]{
                    p.getName(),
                    p.getAge(),
                    p.getGender(),
                    p.getClass().getSimpleName(),
                    p.getLocation().getBlockName() ,
                    p.getbill() ,
                });
            }
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String searchTerm = jTextField1.getText().trim().toLowerCase();
    DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
    model.setRowCount(0);
    
    for (Patient patient : patientList) {
        if (patient.getName().toLowerCase().contains(searchTerm)) {
            model.addRow(new Object[]{
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                getPatientType(patient),
                patient.getLocation() != null ? patient.getLocation().getBlockName() : "N/A" , 
                patient.getbill() , 
            });
        }
    }
    
    if (model.getRowCount() == 0 && !searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No patients found matching '" + searchTerm + "'", 
                                    "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
private Object[] createPatientRow(Patient patient) {
    return new Object[]{
        patient.getName(),
        patient.getAge(),
        patient.getGender(),
        getPatientType(patient),
        patient.getLocation() != null ? patient.getLocation().getBlockName() : "N/A" , 
        patient.getbill() , 
    };
}

private String getPatientType(Patient patient) {
    if (patient instanceof Inpatient) return "Inpatient";
    if (patient instanceof Outpatient) return "Outpatient";
    if (patient instanceof EmergencyPatient) return "Emergency";
    return "Unknown";
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
           int selectedRow = patientTable.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, 
            "Please select a patient to delete",
            "No Selection", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Confirm deletion
    int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this patient?",
        "Confirm Deletion",
        JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Get patient name from selected row
            String patientName = (String) patientTable.getValueAt(selectedRow, 0);
            
            // Find and remove the patient
            Patient toRemove = null;
            for (Patient p : patientList) {
                if (p.getName().equals(patientName)) {
                    toRemove = p;
                    break;
                }
            }
            
            if (toRemove != null) {
                patientList.remove(toRemove);
                refreshPatientTable();
                JOptionPane.showMessageDialog(this,
                    "Patient deleted successfully",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error deleting patient: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnDeleteActionPerformed
 // Data Methods
   
    public static void addPatient(Patient patient) {
        patientList.add(patient);
        refreshTable();
    }
    private void refreshHospitalComboBox() {
    DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbHospitals.getModel();
    model.removeAllElements();
    
    // Add your actual hospitals from data source
    model.addElement("General Hospital");
    model.addElement("City Medical");
    model.addElement("Regional Center");
    
    // Select current hospital
    if(HospitalRecordManager.getCurrentHospital() != null) {
        cmbHospitals.setSelectedItem(HospitalRecordManager.getCurrentHospital().getName());
    }
}
private void refreshPatientTable() {
    DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
    model.setRowCount(0);
    
    if (patientList != null) {
        for (Patient patient : patientList) {
            HospitalBlock location = patient.getLocation();
            model.addRow(new Object[]{
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                getPatientTypeName(patient),
                location != null ? location.getBlockName() : "N/A" , 
                patient.getbill() , 
            });
        }
    }
    autoResizeColumns();
}

private String getPatientTypeName(Patient patient) {
    if (patient instanceof Inpatient) return "Inpatient";
    if (patient instanceof Outpatient) return "Outpatient";
    if (patient instanceof EmergencyPatient) return "Emergency";
    return "Unknown";
}

private void autoResizeColumns() {
    for (int i = 0; i < patientTable.getColumnCount(); i++) {
        patientTable.getColumnModel().getColumn(i).setPreferredWidth(150);
    }
}
    public JTable getPatientTable() {
    return patientTable;
}
    public static void setHospital(Hospital h) {
        hospital = h;
        if (instance != null) {
            instance.setupFilters();
        }
    }

    public static void refreshTable() {
        if (instance != null) {
            instance.jButton4ActionPerformed(null);
        }
    }
      public static void main(String args[]) {
        // Initialize sample data
        
        
        java.awt.EventQueue.invokeLater(() -> {
            HospitalRecordManager manager = new HospitalRecordManager();
            manager.setSize(1000, 600);
            manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            manager.setVisible(true);
        });
    }

    /**
     * @param args the command line

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable patientTable;
    // End of variables declaration//GEN-END:variables

**/
}
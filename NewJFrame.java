
package javaapp;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class NewJFrame extends javax.swing.JFrame {

        private final List<Country> countries;

    public NewJFrame() {
    countries = new ArrayList<>();       
    initComponents();
    populateArrayList();
        showData();
       getTotalCases();
       getTotalDeaths();
       getTotalRecovered();
       
    }

        private void showData() {
         DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < countries.size(); i++) {
            Country c1 = countries.get(i);

            List<String> data = new ArrayList<>();
            data.add(c1.getCountry());
            data.add(c1.getCases());
            data.add(c1.getDeaths());
            data.add(c1.getCritical());
            data.add(c1.getRecovered());
            data.add(c1.getActive());
           
            String list [] = {c1.getCountry(), c1.getCases(), c1.getDeaths(), c1.getRecovered(), c1.getCases(), c1.getCritical()};
            tableModel.addRow(list);

        }
        }
        //Exception Handling
         private void populateArrayList() {
        try {
            FileInputStream file = new FileInputStream("MedDatabase.txt");
            ObjectInputStream inputfile = new ObjectInputStream(file);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    countries.add((Country) inputfile.readObject());
                } catch (IOException e) {
                    endOfFile = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }

            file.close();
            inputfile.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

         public void getTotalCases(){
         
             int sum = 0;
    for (int i = 0; i < jTable1.getRowCount(); i++){
        sum = sum + Integer.parseInt((String) jTable1.getValueAt(i, 1));
    }
    Tsum.setText(Integer.toString(sum));
    
         }
         
         public void getTotalDeaths(){
         
             int sum = 0;
    for (int i = 0; i < jTable1.getRowCount(); i++){
        sum = sum + Integer.parseInt((String) jTable1.getValueAt(i, 2));
    }
    Tdeaths.setText(Integer.toString(sum));
    
         }
         
          public void getTotalRecovered(){
         
            int sum = 0;
    for (int i = 0; i < jTable1.getRowCount(); i++){
        sum = sum + Integer.parseInt((String) jTable1.getValueAt(i, 3));
    }
    re.setText(Integer.toString(sum));
    
         }
         
          
         
           
        public void saveDataToFile() {
        try {
            FileOutputStream file = new FileOutputStream("MedDatabase.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            for (int i = 0; i < countries.size(); i++) {
                outputFile.writeObject(countries.get(i));
            }

        
            file.close();
            outputFile.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void clearTextField() {
        jTextFieldCountry.setText("");
        jTextFieldCases.setText("");
        jTextFieldDeaths.setText("");
        jTextFieldRecovered.setText("");
        jTextFieldActive.setText("");
        jTextFieldCritical.setText("");
    }  
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCountry = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCases = new javax.swing.JTextField();
        jTextFieldDeaths = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldRecovered = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldActive = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCritical = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aboutLabel = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Tsum = new javax.swing.JTextField();
        Tdeaths = new javax.swing.JTextField();
        re = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COVID -19 CORONAVIRUS PANDEMIC");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("COUNTRY");

        jLabel2.setText("TOTAL CASES");

        jLabel3.setText("TOTAL DEATHS");

        jTextFieldCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCountryActionPerformed(evt);
            }
        });

        jLabel4.setText("ADD/EDIT CORONAVIRUS CASES ");

        jLabel5.setText("TOTAL RECOVERED");

        jLabel6.setText("ACTIVE CASES");

        jLabel7.setText("CRITICAL");

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldActive, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldRecovered, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldDeaths, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCases, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCountry, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCritical))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCases, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDeaths, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldRecovered, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActive, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCritical, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COUNTRY", "TOTAL CASES", "TOTAL DEATHS", "RECOVERED", "ACTIVE CASES", "CRITICAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        aboutLabel.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        aboutLabel.setForeground(new java.awt.Color(255, 255, 255));
        aboutLabel.setText("       About ( ? )");
        aboutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutLabelMouseClicked(evt);
            }
        });

        search.setText("Search country: ");

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel8.setText("TOTAL CASES");

        jLabel9.setText("DEATHS");

        jLabel10.setText("TOTAL RECOVERED");

        Tsum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TsumActionPerformed(evt);
            }
        });

        Tdeaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TdeathsActionPerformed(evt);
            }
        });

        re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tsum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(Tdeaths, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(re, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aboutLabel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aboutLabel)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Tdeaths, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tsum, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(re))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutLabelMouseClicked
        JOptionPane.showMessageDialog(null, "GROUP MEMBERS\n"
            + "\nMATRIX NO: 269877"
            + "\nNAME: AMANIL IZZAH BINTI ABDUL AFEEF\n"
            + "\nMATRIX NO: 271616"
            + "\nNURUL FATIN SHAHIRA BINTI RAHIM\n"
            + "\nMATRIX NO: 271810"
            + "\nANIS ADILA BINTI MUSA", "About", JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_aboutLabelMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
          DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRowCount() == 1) {
            int index = jTable1.getSelectedRow();

            String Country = jTextFieldCountry.getText();
            String Cases = jTextFieldCases.getText();
            String Deaths = jTextFieldDeaths.getText();
            String Recovered = jTextFieldRecovered.getText();
            String Active = jTextFieldActive.getText();
            String Critical = jTextFieldCritical.getText();
            if (Country.isEmpty() || Cases.isEmpty() || Deaths.isEmpty() || Recovered.isEmpty() || Active.isEmpty() || Critical.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill in the form properly!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                tableModel.setValueAt(Country, jTable1.getSelectedRow(), 0);
                tableModel.setValueAt(Cases, jTable1.getSelectedRow(), 1);
                tableModel.setValueAt(Deaths, jTable1.getSelectedRow(), 2);
                tableModel.setValueAt(Recovered, jTable1.getSelectedRow(), 3);
                tableModel.setValueAt(Active, jTable1.getSelectedRow(), 4);
                tableModel.setValueAt(Critical, jTable1.getSelectedRow(), 5);

                Country c1 = countries.get(index);
                c1.setCountry(Country);
                c1.setCases(Cases);
                c1.setDeaths(Deaths);
                c1.setRecovered(Recovered);
                c1.setActive(Active);
                c1.setCritical(Critical);
                
            saveDataToFile();
            clearTextField();
              
            }
        }
    }//GEN-LAST:event_editActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

      String Country = jTextFieldCountry.getText();
        String Cases = jTextFieldCases.getText();
        String Deaths = jTextFieldDeaths.getText();
        String Recovered = jTextFieldRecovered.getText();
        String Active = jTextFieldActive.getText();
        String Critical = jTextFieldCritical.getText();

        if (Country.isEmpty() || Cases.isEmpty() || Deaths.isEmpty() || Recovered.isEmpty() || Active.isEmpty() || Critical.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill in the form properly!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Country c1 = new Country(Country, Cases, Deaths, Recovered, Active, Critical);
            countries.add(c1);
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            //tableModel.addRow(new Object[]{c1.getCountry(), c1.getCases(), c1.getDeaths(),c1.getRecovered(), c1.getCases(), c1.getCritical()});
            JOptionPane.showMessageDialog(this," DATA SUCCESSFULLY ADD");

            String data[] = {Country, Cases, Deaths, Recovered, Active, Critical};
            tableModel.addRow(data);

            
            saveDataToFile();
            clearTextField();
        }


    }//GEN-LAST:event_addActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchField.getText().trim()));
        
          
    }//GEN-LAST:event_searchFieldKeyPressed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldKeyReleased

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRowCount() == 1) {
            int index = jTable1.getSelectedRow();
            tableModel.removeRow(index);
            
            
            saveDataToFile();
            clearTextField();
        }

    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
         if (evt.getButton() == MouseEvent.BUTTON1) {
            int index = jTable1.getSelectedRow();
            Country c1 = countries.get(index);

            jTextFieldCountry.setText(c1.getCountry());
            jTextFieldCases.setText(c1.getCases());
            jTextFieldDeaths.setText(c1.getDeaths());
            jTextFieldRecovered.setText(c1.getRecovered());
            jTextFieldActive.setText(c1.getActive());
            jTextFieldCritical.setText(c1.getCritical());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextFieldCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCountryActionPerformed

    private void TdeathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TdeathsActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_TdeathsActionPerformed

    private void TsumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TsumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TsumActionPerformed

    private void reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reActionPerformed

   
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tdeaths;
    private javax.swing.JTextField Tsum;
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldActive;
    private javax.swing.JTextField jTextFieldCases;
    private javax.swing.JTextField jTextFieldCountry;
    private javax.swing.JTextField jTextFieldCritical;
    private javax.swing.JTextField jTextFieldDeaths;
    private javax.swing.JTextField jTextFieldRecovered;
    private javax.swing.JTextField re;
    private javax.swing.JLabel search;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}

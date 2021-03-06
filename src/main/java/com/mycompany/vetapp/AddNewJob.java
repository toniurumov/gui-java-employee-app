/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vetapp;

import javax.swing.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author anton
 */
public class AddNewJob extends javax.swing.JFrame {
    
     
     ArrayList<job> jobs;
    /**
     * Creates new form AddNewJob
     */
    public AddNewJob() {
        initComponents();
        jobs = new ArrayList<job>();
        populateArraylist();
    }
    public void populateArraylist()
    {
    try
    {
        FileInputStream file = new FileInputStream("Jobs.dat");
        ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false ;
        while (!endOfFile)
        {
            try              
            {
                jobs.add((job)inputFile.readObject());
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
            catch (Exception f)
                    {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                    }
            }
           inputFile.close();
        }
         
    catch (IOException e)
    {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
    public void saveJobsToFile()
    {
        try
        {
            FileOutputStream file = new FileOutputStream("Jobs.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (int i = 0 ; i < jobs.size() ; i ++)
            {
                outputFile.writeObject(jobs.get(i));
            }
            outputFile.close();
            JOptionPane.showMessageDialog(null, "Successfully saved");
            this.dispose();
        }
        catch (IOException e)
                {
                 JOptionPane.showMessageDialog(null, e.getMessage());   
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
        jLabel2 = new javax.swing.JLabel();
        jobName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jobSalary = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new job");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("To create a new job enter the data below : ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel2.setText("Name of the job:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel3.setText("Salary for this job:");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\anton\\Downloads\\Pics\\Pics\\save.png")); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jobSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(jobName))))))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jobName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jobSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (jobName.getText().isEmpty() || jobSalary.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null, "Please enter all fields");
       }
       else{
        String name = jobName.getText().trim();
        String salary = jobSalary.getText();
        job job1 = new job(Double.parseDouble(salary), name);
        jobs.add(job1);
        
        saveJobsToFile();
    }//GEN-LAST:event_jButton1ActionPerformed
    }
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
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jobName;
    private javax.swing.JTextField jobSalary;
    // End of variables declaration//GEN-END:variables
}

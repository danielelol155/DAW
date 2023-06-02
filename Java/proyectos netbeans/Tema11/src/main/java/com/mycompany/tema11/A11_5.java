/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tema11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class A11_5 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public A11_5() {
        initComponents();
    }

    public String toString(List<Integer> a) {
        return a + ""; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        mostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Introduce numeros enteros separados por un espacio");

        guardar.setText("Guardar en datos.dat");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        mostrar.setText("Mostar datos de datos.dat");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guardar)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(mostrar)
                    .addComponent(jScrollPane1))
                .addContainerGap(315, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(mostrar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        ObjectOutputStream flujosalida = null;

        try {
            String numeros = jTextField1.getText() + "";
            Integer[] t = new Integer[0];
            String[] nums = numeros.split(" ");

            for (int i = 0; i < nums.length; i++) {
                t = Arrays.copyOf(t, t.length + 1);
                t[i] = Integer.parseInt(nums[i]);
            }

            flujosalida = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\com\\mycompany\\tema11\\datos.dat"));
            flujosalida.writeObject(t);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            JOptionPane.showMessageDialog(rootPane, "trabajo terminado");
            System.out.println("trabajo terminado");
            if (flujosalida != null) {
                try {
                    flujosalida.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        // TODO add your handling code here:
        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("src\\main\\java\\com\\mycompany\\tema11\\datos.dat")) {
        }) {
            Integer[] f={};
            try {
                f = (Integer[]) flujoEntrada.readObject();
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(A11_5.class.getName()).log(Level.SEVERE, null, ex);
            }

            List<Integer> integ = new ArrayList<>();

            integ = Arrays.asList(f);

            jTextArea.setText(toString(integ));
        } catch (IOException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_mostrarActionPerformed

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
            java.util.logging.Logger.getLogger(A11_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A11_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A11_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A11_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A11_5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton mostrar;
    // End of variables declaration//GEN-END:variables
}

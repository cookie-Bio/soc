/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business.Message;
import business.PrivateMessage;
import business.User;
import db.DataDBException;
import db.MessagesDBWorker;
import db.UserDBWorker;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brasha
 */
public class MessegesJPanel extends javax.swing.JPanel {

    
    private User user;
    private MessagesDBWorker mdb;
    private ArrayList<PrivateMessage> LM;
    private MessageJPanel messageJPanel;
    Vector elements;
    
    /**
     * Creates new form MessegesJPanel
     */
    public MessegesJPanel(User us) {
        initComponents();
        setBounds(10,20,300,300);
        user =us;
        mdb = new MessagesDBWorker();
        try {
            LM = mdb.GetPrivateMessageTo(user.getID());
        } catch (DataDBException ex) {
            Logger.getLogger(MessegesJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        int size = LM.size();
        elements = new Vector<String>();
        for(int i=0;i<size;i++)
        {
            elements.add(String.valueOf(LM.get(i).getMessageID()) + " " + LM.get(i).getSender().getFirstName() + " " + LM.get(i).getSender().getLastName());
        }
        
        jList1.setListData(elements);
        
        messageJPanel = new MessageJPanel();
        this.add(messageJPanel);
        messageJPanel.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("Прочитать");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setText("Удалить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jLabel2.setText("From");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            messageJPanel.setText(LM.get(jList1.getSelectedIndex()));
            jPanel1.setVisible(false);
            messageJPanel.setVisible(true);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(null, "Сообщение не выбрано!", "Ошибка", 1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            elements.remove(jList1.getSelectedIndex());
            try {
                mdb.DeleteMessage(LM.get(jList1.getSelectedIndex()).getMessageID());
            } catch (DataDBException ex) {
                Logger.getLogger(MessegesJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                LM = mdb.GetPrivateMessageTo(user.getID());
            } catch (DataDBException ex) {
                Logger.getLogger(MessegesJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            jList1.updateUI();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(null, "Сообщение не выбрано!", "Ошибка", 1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void startPress()
    {
        try {
            LM = mdb.GetPrivateMessageTo(user.getID());
        } catch (DataDBException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка при чтении сообщений!", "Ошибка", 1);
        }
        int size = LM.size();
        elements.clear();
        for(int i=0;i<size;i++)
        {
            elements.add(String.valueOf(LM.get(i).getMessageID()) + " " + LM.get(i).getSender().getFirstName() + " " + LM.get(i).getSender().getLastName());
        }
        jList1.setListData(elements);
        jList1.setListData(elements);
        messageJPanel.setVisible(false);
        jPanel1.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

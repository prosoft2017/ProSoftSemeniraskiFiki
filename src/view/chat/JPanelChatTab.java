/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.chat;

import domain.user.AppUser;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import transfer.TransferObjectResponse;

/**
 *
 * @author Filip
 */
public class JPanelChatTab extends javax.swing.JPanel {

    /**
     * Creates new form JPanelChatTab
     */
    public JPanelChatTab() {
        initComponents();
        initCustomComponents();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextFieldMessage = new javax.swing.JTextField();
        jButtonSendMessage = new javax.swing.JButton();
        jButtonAttachFile = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("All Users"));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat Panel"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jTextFieldMessage.setMaximumSize(new java.awt.Dimension(2147483647, 25));
        jTextFieldMessage.setMinimumSize(new java.awt.Dimension(4, 25));
        jTextFieldMessage.setPreferredSize(new java.awt.Dimension(55, 25));

        jButtonSendMessage.setText("Send Message");
        jButtonSendMessage.setMaximumSize(new java.awt.Dimension(110, 25));
        jButtonSendMessage.setMinimumSize(new java.awt.Dimension(110, 25));
        jButtonSendMessage.setPreferredSize(new java.awt.Dimension(110, 25));
        jButtonSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendMessageActionPerformed(evt);
            }
        });

        jButtonAttachFile.setText("Attach File");
        jButtonAttachFile.setEnabled(false);
        jButtonAttachFile.setMaximumSize(new java.awt.Dimension(110, 25));
        jButtonAttachFile.setMinimumSize(new java.awt.Dimension(110, 25));
        jButtonAttachFile.setPreferredSize(new java.awt.Dimension(110, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAttachFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAttachFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 2) {

            AppUser selectedUser = jList1.getSelectedValue();
            controller.GUIController.getController().setActiveChat(jTextArea1, selectedUser);

            try {

                TransferObjectResponse objectResponse = controller.Controller.getController().getAllMessagesForThread(selectedUser);
                if (objectResponse.getMesssage() == constant.ConstantOperations.SUCCESS_MSG) {
                    jTextArea1.setText(
                            "Chat with :"
                            + selectedUser.toString()
                            + (String) objectResponse.getResult()
                            + System.lineSeparator()
                            + System.lineSeparator()
                    );
                }
            } catch (IOException | ClassNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButtonSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendMessageActionPerformed
        String message = jTextFieldMessage.getText().trim();
        jTextFieldMessage.setText(null);
        jTextArea1.append("@" + controller.Controller.getController().getLogedUser().getUsername() + ": " + message + System.lineSeparator() + System.lineSeparator());
        try {
            controller.Controller.getController().sendMessageTo(jList1.getSelectedValue(), message);
        } catch (IOException | ClassNotFoundException ex) {
        }
    }//GEN-LAST:event_jButtonSendMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAttachFile;
    private javax.swing.JButton jButtonSendMessage;
    private javax.swing.JList<AppUser> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldMessage;
    // End of variables declaration//GEN-END:variables

    private void initCustomComponents() {
        try {
            TransferObjectResponse tor = controller.Controller.getController().getAllUsers();
            if (tor.getMesssage() == constant.ConstantOperations.SUCCESS_MSG) {
                List<AppUser> list = (List<AppUser>) tor.getResult();
                DefaultListModel<AppUser> listModel = new DefaultListModel<>();
                for (AppUser appUser : list) {
                    listModel.addElement(appUser);
                }
                jList1.setModel(listModel);
            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.chat.Message;
import domain.user.AppUser;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Nikola
 */
public class GUIController {

    private JTextArea textAreaChat;
    private AppUser chatUser;
    private static GUIController instance;

    private GUIController() {
    }

    public void setActiveChat(JTextArea area, AppUser appUser) {
        this.textAreaChat = area;
        this.chatUser = appUser;
    }

    public void addMessageToChat(AppUser appUser, String message) {
        if (chatUser != null && chatUser.equals(appUser)) {
            textAreaChat.append("@" + appUser.getUsername() + ": " + message + System.lineSeparator() + System.lineSeparator());
        } else {
            String notification = "New message from: " + appUser.getUsername();
            notification += System.lineSeparator() + (message.length() > 10 ? message.substring(0, 10) + "..." : message);
            JOptionPane.showMessageDialog(null, notification, "New Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static GUIController getController() {
        if (instance == null) {
            instance = new GUIController();
        }

        return instance;
    }

    public void performCommand(String q) throws URISyntaxException, IOException {
        Controller.getController().performCommand(q);
    }

    public void openApplicationFrame() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.main.JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            javax.swing.JFrame jfr = new view.main.JFrameMain();
            jfr.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
            jfr.setVisible(true);
        });
    }

    public void promtNewMessage(Message message) {
        switch (message.getMessageType()) {
            case GLOBAL:
            case IMPORTANT:
                JOptionPane.showMessageDialog(null, message.getMessageContent(), "Global/Import Message", JOptionPane.INFORMATION_MESSAGE);
                break;
            case PRIVATE:
                addMessageToChat(message.getAppUserSender(), message.getMessageContent());
                break;
        }
    }
}

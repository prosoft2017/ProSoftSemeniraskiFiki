/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.chat.Message;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikola
 */
public class GUIController {

    private static GUIController instance;

    private GUIController() {
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
            case Global:
            case Important:
                JOptionPane.showMessageDialog(null, message.getMessageContent(), "Global/Import Message", JOptionPane.INFORMATION_MESSAGE);
                break;
            case Private:
                break;
        }
    }
}

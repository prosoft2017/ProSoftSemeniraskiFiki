/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JDialog;
import view.login.JDialogLoginWindow;

/**
 *
 * @author Nikola
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JDialog loginDialog = new JDialogLoginWindow(null, true);
        loginDialog.setLocationRelativeTo(null);
        loginDialog.setVisible(true);
    }
}

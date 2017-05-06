/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URISyntaxException;

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
}

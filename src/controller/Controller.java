/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URISyntaxException;
import system_operation.SOGoogleSearch;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getController() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public void performCommand(String q) throws URISyntaxException, IOException {
        int index = q.indexOf(" ");
        String command;
        String params;
        if (index == -1) {
            command = "g";
            params = q;
        } else {
            command = q.substring(0, index);
            params = q.substring(index);
        }

        switch (command) {
            case "g":
            case "google":
                SOGoogleSearch.execute(params);
                break;
            default:
                SOGoogleSearch.execute(q);
                break;
        }

    }
}

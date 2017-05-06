/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_operation;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Nikola
 */
public class SOGoogleSearch {

    private static final String GOOGLE_URL = "http://www.google.com/search?q=";
    private static final String CHARSET = "UTF-8";

    public static void execute(String q) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            desktop.browse(new URI(GOOGLE_URL+q.replace(" ", "%20")));
        }
    }
}

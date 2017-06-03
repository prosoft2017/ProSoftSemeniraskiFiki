/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.ConstantOperations;
import domain.AppUser;
import transfer.TransferObjectRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import system_operation.SOGoogleSearch;
import transfer.TransferObjectResponse;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;
    private AppUser logedUser;

    private Controller() {
    }

    public static Controller getController() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }
    
    public TransferObjectResponse validateUser(AppUser appUser) throws IOException, ClassNotFoundException {
        TransferObjectRequest request = new TransferObjectRequest()
                .setOperation(ConstantOperations.VALIDATED_USER)
                .setParameter(appUser);
        communication.Communication.getInstance().sendRequest(request);
        
        return communication.Communication.getInstance().reciveResponse();
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

    public AppUser getLogedUser() {
        return logedUser;
    }

    public void setLogedUser(AppUser logedUser) {
        this.logedUser = logedUser;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.ConstantOperations;
import domain.chat.Message;
import domain.chat.MessageType;
import domain.issue.Issue;
import domain.user.AppUser;
import transfer.TransferObjectRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import system_operation.SOGoogleSearch;
import transfer.TransferObjectResponse;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;

    public void sendMessageTo(AppUser selectedValue, String message) throws IOException, ClassNotFoundException {
        List<AppUser> list = new LinkedList<>();
        list.add(selectedValue);
        TransferObjectRequest request = new TransferObjectRequest()
                .setOperation(ConstantOperations.SEND_PRIVATE_MESSAGE)
                .setParameter(new Message(logedUser, list, message, MessageType.PRIVATE));
        communication.Communication.getInstance().sendMessage(request);
    }
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

    public TransferObjectResponse getAllUsers() throws IOException, ClassNotFoundException {
        TransferObjectRequest request = new TransferObjectRequest()
                .setOperation(ConstantOperations.GET_ALL_USERS_FRONTEND);
        communication.Communication.getInstance().sendRequest(request);

        return communication.Communication.getInstance().reciveResponse();
    }

    public TransferObjectResponse getAllCountries() throws IOException, ClassNotFoundException {
        TransferObjectRequest request = new TransferObjectRequest()
                .setOperation(ConstantOperations.GET_ALL_COUNTRIES_FRONTEND);
        communication.Communication.getInstance().sendRequest(request);

        return communication.Communication.getInstance().reciveResponse();
    }

    public TransferObjectResponse reportIssue(Issue sue) throws IOException, ClassNotFoundException {
        TransferObjectRequest request = new TransferObjectRequest()
                .setOperation(ConstantOperations.REPORT_ISSUE)
                .setParameter(sue);
        communication.Communication.getInstance().sendRequest(request);

        return communication.Communication.getInstance().reciveResponse();
    }

    public TransferObjectResponse editUser(AppUser editedUser) throws IOException, ClassNotFoundException {
        TransferObjectRequest request = new TransferObjectRequest()
                .setOperation(ConstantOperations.UPDATE_LOGED_USER)
                .setParameter(editedUser);
        communication.Communication.getInstance().sendRequest(request);

        return communication.Communication.getInstance().reciveResponse();
    }

    public TransferObjectResponse getAllMessagesForThread(AppUser selectedUser) throws IOException, ClassNotFoundException {
        TransferObjectRequest request = new TransferObjectRequest()
                .setOperation(ConstantOperations.GET_ALL_MESSAGES)
                .setParameter(selectedUser);
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

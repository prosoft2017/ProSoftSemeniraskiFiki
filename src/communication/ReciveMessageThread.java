/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import controller.GUIController;
import domain.chat.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import transfer.TransferObjectResponse;

/**
 *
 * @author Nikola
 */
public class ReciveMessageThread extends Thread {

    private final Socket socket;
    private boolean clientConnected;

    public ReciveMessageThread(Socket socket) {
        this.socket = socket;
        this.clientConnected = true;
    }

    @Override
    public void run() {
        try {
            runThread();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            clientConnected = false;
        }
        System.out.println("Client disconnected.");
    }

    private void runThread() throws IOException, ClassNotFoundException {
        while (clientConnected) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjectResponse response = (TransferObjectResponse) inSocket.readObject();

            if (response.getMesssage() == constant.ConstantOperations.SUCCESS_MSG) {
                GUIController.getController().promtNewMessage((Message) response.getResult());
            }
        }
    }

}

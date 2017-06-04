/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.TransferObjectRequest;
import transfer.TransferObjectResponse;

/**
 *
 * @author student1
 */
public class Communication {

    private final Socket socket;
    private final Socket chatSocket;
    private static Communication instance;

    private Communication() throws IOException {
        socket = new Socket("127.0.0.1", 9000);
        chatSocket = new Socket("127.0.0.1", 9001);
        System.out.println("Client connected");
    }

    public static Communication getInstance() throws IOException {
        if (instance == null) {
            instance = new Communication();
            new ReciveMessageThread(instance.chatSocket).start();
        }
        return instance;
    }

    public void sendRequest(TransferObjectRequest request) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(request);
    }

    public TransferObjectResponse reciveResponse() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        return (TransferObjectResponse) inSocket.readObject();
    }

    public void sendMessage(TransferObjectRequest request) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(chatSocket.getOutputStream());
        outSocket.writeObject(request);
    }
}

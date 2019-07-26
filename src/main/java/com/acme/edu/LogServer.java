package com.acme.edu;

/**
 * Created by Java_1 on 26.07.2019.
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.acme.edu.Logger.*;


public class LogServer {
    private static BufferedWriter out;
    private static DataInputStream in;
    /*public void sendToClient() {
        out.
    }*/
    public static void main(String[] args) throws IOException {
        try {final ServerSocket serverSocket = new ServerSocket(666);

                Socket client = serverSocket.accept();
                try {in =
                        new DataInputStream(
                                client.getInputStream());
                    out =
                            new BufferedWriter(
                                    new OutputStreamWriter(
                                            new BufferedOutputStream(
                                                    client.getOutputStream())));

                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            String name = in.readUTF();
            switch (name){
                case("Integer "):
                    int i = in.readInt();
                    log(i);
                    System.out.println("I'm here!" + i);
                    break;
                case("String "):
                    log(in.readUTF());
                    break;
                case("Reference "):
                    log(new Object());
                    break;
                default:
                    System.out.println("WRONG TYPE NAME");
            }
        }
    }
}
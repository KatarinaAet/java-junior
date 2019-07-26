package com.acme.edu;

/**
 * Created by Java_1 on 26.07.2019.
 */

import java.io.*;
import java.net.Socket;
    public class LogClient {
        private DataOutputStream out;
        private BufferedReader in;
        public LogClient(){
            try{final Socket server = new Socket("localhost", 666);
                try {in =
                             new BufferedReader(
                                     new InputStreamReader(
                                             new BufferedInputStream(
                                                     server.getInputStream())));
                out =
                             new DataOutputStream(
                                                     server.getOutputStream());

                        /*while (true) {
                            //out.write(">>> " + console.readLine());
                            out.newLine();
                            out.flush();
                            System.out.println(in.readLine());
                        }*/


                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void sendToServer(int message) throws IOException {
            out.writeUTF("Integer ");
            out.writeInt(message);
            out.flush();
        }

        public void sendToServer(String message) throws IOException {
            out.writeUTF("String ");
            out.writeUTF(message);
            out.flush();
        }

        public void sendToServer(Object message) throws IOException {
            out.writeUTF("Reference ");
            //out.writeUTF(message.toString());
            out.flush();
        }

    }

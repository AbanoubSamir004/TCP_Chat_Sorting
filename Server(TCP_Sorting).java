package com.mycompany.task_4;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    Server() {
         try{
            ServerSocket server = new ServerSocket(22000);
            Socket client=server.accept();
            
            DataInputStream clientReadSource=new DataInputStream(client.getInputStream());
            DataOutputStream clientWriteSource=new DataOutputStream(client.getOutputStream());
            
            clientWriteSource.writeUTF("you are connected but not for long");
            clientWriteSource.writeUTF("you can only ask me once");
            clientWriteSource.writeUTF("please enter your 10 numbers");
            System.out.println("Client wants to sorted this array: ");

            
            int[]array=new int[10];
            for(int i=0;i<10;i++){
                array[i]=clientReadSource.readInt();
                System.out.println(array[i]);
            }
            int temp=0;
            for(int a=0;a<10;a++){
                for(int b=a+1;b<10;b++ ){
                    if(array[a]>array[b]){
                        temp=array[a];
                        array[a]=array[b];
                        array[b]=temp;
                    }
                }
            }
            for(int i=0;i<10;i++){
            	clientWriteSource.writeInt(array[i]);
            }
            clientWriteSource.close();
            clientReadSource.close();
            client.close();
        } 
         catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



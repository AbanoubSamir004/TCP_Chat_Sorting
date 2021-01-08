package com.mycompany.task_4;
import java.net.InetAddress;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;

public class Client {
    Client() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
            Socket other = new Socket(ip, 22000);
            
            DataInputStream otherReadSource = new DataInputStream(other.getInputStream());
            DataOutputStream otherWriteSource = new DataOutputStream(other.getOutputStream());            
            
            String str = "";
            str = otherReadSource.readUTF();
            System.out.println(str);
            str = otherReadSource.readUTF();
            System.out.println(str);
            str = otherReadSource.readUTF();
            System.out.println(str);
                        
            Scanner input=new Scanner(System.in);
            int[]array=new int[10];
            for(int i=0;i<10;i++){
                array[i]=input.nextInt();
                otherWriteSource.writeInt(array[i]);
            }
            
            int [] asc = new int[10]; 
		System.out.print("Ascending output : ");
            for(int i=0; i<10; i++) {
                asc[i] = otherReadSource.readInt();
		System.out.print(asc[i]+" ");
            }		
            System.out.println(""); 		 
            System.out.print("Descending output : ");
            for(int i=9; i>=0; i--) {
                System.out.print(asc[i]+" ");
            }
            otherReadSource.close();
            otherWriteSource.close();
            other.close();
        } 
        catch (IOException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

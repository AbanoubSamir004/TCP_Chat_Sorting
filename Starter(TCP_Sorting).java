package com.mycompany.task_4;
import java.util.Scanner;

public class Starter {
    public static void main (String[] args){
         Scanner scan= new Scanner(System.in);
         if(scan.next().equals("server")){
             Server s=new Server();
         }
         else{
             Client c = new Client();
         }
    }
}


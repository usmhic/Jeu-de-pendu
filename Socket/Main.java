package Socket;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        try{

            // la creation dun ServerSocket server qui va acooute le port 300 pour les demande des client
            ServerSocket server = new ServerSocket(3000);
            
            //un variabele de type int qui va donner le nombre des clinet connecte
            int n=0;
            
            while(true){
                Socket socket = server.accept(); //Récupération de la socket

                System.out.println("Client: "+n);// aficcher le nombre des client connecte
                Thread t = new Thread(new Serveur(socket));// creation d un neuveau thread
                t.start();// initiation de thread
                n++;// la joute de 1 quand un neuvau clinet connecte ou serveur
            }
        }

        catch(IOException e){
            System.out.println(e);
        }
    }
}

package Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        try{
            ServerSocket server = new ServerSocket(3000);
            int n=0;
            while(true){
                Socket socket = server.accept(); //Récupération de la socket
                n++;
                System.out.println("Client: "+n);
                Thread t = new Thread(new Serveur(socket));
                t.start();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}

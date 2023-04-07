package Socket;

import java.net.*;

public class MainServeur {
    public static void main(String[] args) throws InterruptedException{
        try{
            ServerSocket server = new ServerSocket(3000);
            // la creation d'une ServerSocket server qui va ecoute sur le port 3000 pour les demande des clients

            int n = 1;
            // une variable de type int qui va donner le nombre des client connecte

            while(n < 10){
                Socket socket = server.accept(); 
                //Récupération de la socket

                System.out.println("Client: "+n);
                // affcher le nombre des clients connectee

                Thread t = new Thread(new Serveur(socket));
                // creation d un nouveau thread

                t.start();
                // initiation de thread

                n++;
                // l'ajoute de 1 quand un nouveau clinet connecte au serveur
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

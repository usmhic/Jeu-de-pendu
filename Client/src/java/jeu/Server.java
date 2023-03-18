package jeu;

import serveur.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   
    public static void main(String[] args) throws IOException {
        
        System.out.println("Serveur démarré");
        
        // Mis le port 3000 a l'ecout
        ServerSocket ss = new ServerSocket(3000);
        Socket cs = ss.accept();
        
        while(true){
            // Afficher l'adresse IP de client connecte
            InetAddress clientAddr = cs.getInetAddress();
            System.out.println("Client connecté depuis l'adresse : " + clientAddr.getHostAddress());
            
            // Demander au client d'entrer le nom
            PrintStream out = new PrintStream(cs.getOutputStream());
            out.println("Veuillez saisir votre compte : ");
            
            // Lire et Afficher le nom
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            String compte = in.readLine();            
            System.out.println("Compte d'utilisateur : " + compte);
            out.println("Bienvenue " + compte);
            
            //
            in.close();
            out.close();
            cs.close();
            ss.close();
            
        }
    }
}

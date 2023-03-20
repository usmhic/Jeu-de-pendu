package Socket;

import Jeu.Jeu;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serveur implements Runnable {
    
    public Socket socket;
    
    public Serveur(Socket s){
        this.socket=s;
    }
    
    @Override
    public void run(){
        try {
            
            System.out.println("Serveur démarré");
            // Afficher l'adresse IP de client connecte
            InetAddress clientAddr = socket.getInetAddress();

            System.out.println(" Client connecté depuis l'adresse : " + clientAddr.getHostAddress());
                
            // Demander au client d'entrer le nom
            PrintStream send = new PrintStream(socket.getOutputStream());
    
            Jeu jeu = new Jeu();       
            String selectedWord = jeu.getWord();
                
            int n=10, i=0, l = selectedWord.length();
            String inputWord = jeu.maskWord(l, selectedWord); 
                                
            while(i<n && !inputWord.equals(selectedWord)) {
                send.println("("+(n-i)+" Attempts left) Your word is: "+inputWord);
                    
                BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String letter = request.readLine();
                   
                inputWord = jeu.updateWord(selectedWord, inputWord, n, i, letter );
                i++;
            }
              
            send.close();
            socket.close();
       
        } 
        catch (IOException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
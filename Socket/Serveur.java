package Socket;

import Jeu.Jeu;

import java.net.*;
import java.io.*;

public class Serveur implements Runnable {
    
    public Socket socket;
    
    public Serveur(Socket s){
        this.socket = s;
    }
    
    @Override
    public void run(){
        try {
            
            // Afficher un message indiquant que le serveur est démarré
            System.out.println("Serveur démarré");
            
            // Afficher l'adresse IP de client connecte
            InetAddress clientAddr = socket.getInetAddress();
            System.out.println(" Client connecté depuis l'adresse : " + clientAddr.getHostAddress());
                
            // Demander au client d'entrer le nom
            PrintStream send = new PrintStream(socket.getOutputStream());
            
            // Créer une instance de la classe Jeu pour jouer
            Jeu jeu = new Jeu();       
            String selectedWord = jeu.getWord();
                
            int n=10, i=0;
            String word, inputWord = jeu.maskWord(selectedWord); 
                        
            while(i<n && !inputWord.equals(selectedWord)) {
                send.println("("+(n-i)+" Attempts left) Your word is: "+inputWord);
                    
                BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream()));               
                String input = request.readLine();
                // Vérifier que l'entrée est valide
                while(!jeu.checkInput(input)){
                    send.println("Input must be one letter");  
                    BufferedReader newRequest = new BufferedReader(new InputStreamReader(socket.getInputStream()));               
                    input = newRequest.readLine();
                }  
                word = jeu.updateWord(selectedWord, inputWord, input);
                if (word.equals(inputWord)) i++;
                inputWord = word;
            }
              
            send.close();
            socket.close();
       
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
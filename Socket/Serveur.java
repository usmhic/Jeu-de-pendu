package Socket;

import Jeu.Jeu;

import java.io.*;
import java.net.*;

public class Serveur implements Runnable {
    
    public Socket socket;
    
    public Serveur(Socket s){
        this.socket = s;
    }
    
    @Override
    public void run(){
        try {            
            // Afficher l'adresse IP de client connecte
            InetAddress clientAddr = socket.getInetAddress();
            System.out.println(" Client connecté depuis l'adresse : " + clientAddr.getHostAddress());
                
            // Definiton des read et send
            PrintStream ps = new PrintStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));               

            Jeu jeu = new Jeu();       
            // Créer une instance de la classe Jeu pour jouer

            String selectedWord = jeu.getWord();
            // Appeler la methode getWord() de la class jeu pour selectioner un pays random
            
            int n=10, i=0;
            // n: nombre des tentatives
            // i: counter

            String input, word, inputWord = jeu.maskWord(selectedWord);
            // inputword: 
                        
            while(i<n && !inputWord.equals(selectedWord)) {
                ps.println("("+(n-i)+" Tentatives restantes) Votre mot est: " + inputWord);
                    
                input = br.readLine();
                // lire l'entrer de l'utilisateur
                
                while(!jeu.checkInput(input)){
                    ps.println("L'entrée doit être une seule lettre");  
                    input = br.readLine();
                }
                // Vérifier que l'entrée est valide

                word = jeu.updateWord(selectedWord, inputWord, input);
                // Changer le mot si vrai

                if (word.equals(inputWord)) i++;
                // Si rien change, on elimine un tentative
                
                else inputWord = word;
                // Sinon, ajouter le(s) nouveau(s) character(s)
            }

            if(inputWord.equals(selectedWord)) ps.println("Vous avez Gagner! le pays choisi est: "+selectedWord);
            else ps.println("Vous avez Perdu! le pays choisi est: " + selectedWord);

            ps.close();
            br.close();
            socket.close();
       
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
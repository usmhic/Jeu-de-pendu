package Jeu;

import java.io.IOException;
import java.util.Scanner;

public class JeuConsole {
        
    public String inputLetterConsole(String word, int n, int i){
        Scanner input = new Scanner(System.in);
        String letter = ""; 
        while(!checkInputConsole(letter)){
            System.out.println("Input must be one letter");  
            letter = input.nextLine();
        }  
        return letter;
    }
    
    private boolean checkInputConsole(String letter){
        if(letter.length() == 1) {
            if( Character.isLetter(letter.charAt(0)) ){
                return true;
            }
        }
        return false;
    }
    
    public void runConsole(){
        Jeu jeu = new Jeu();
        String selectedWord = jeu.getWord();            
        int n=10, i=0, l = selectedWord.length();
        String inputWord = jeu.maskWord(selectedWord); // assign a random string from list to word               
        while(i<n && !inputWord.equals(selectedWord)) {
            System.out.println("Your word is: " + inputWord);            
            System.out.println("You have " + (n-i) + " left.");  
            String letter = inputLetterConsole( inputWord, n, i);       
            inputWord = jeu.updateWord(selectedWord,inputWord, letter );
            i++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        Jeu jeu = new Jeu();
        jeu.runConsole();
    }
}

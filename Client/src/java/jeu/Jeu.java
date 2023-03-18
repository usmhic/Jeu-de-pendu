package jeu;

import java.util.Random;
import java.util.Scanner;

public class Jeu {

    public String getWord(){
        String[] list = {"Finland", "Russia", "Latvia", "Lithuania", "Poland"}; // list of String containing all the countries.        
        Random r = new Random(); // create an object name r from Random Class
        int ranint = r.nextInt(list.length); // use object r to generate random integer between 0 and list length
        String word = list[ranint]; // assign a random string from list to word
        return word;
    }
    
    public String maskWord(int l, String selectedWord){
        int i;
        String word = selectedWord.substring(0,1);
        for(i=1;i<l-1;i++){
            word = word +"-";
        }
        word = word + selectedWord.substring(selectedWord.length()-1,selectedWord.length());
        return word;
    }
    
    private boolean checkInput(String letter){
        if(letter.length() == 1) {
            if( Character.isLetter(letter.charAt(0)) ){
                return true;
            }
        }
        return false;
    }
    
    public String runInsideLoop(String word, String newWord, int n, int i, String letter){
        int j = 1;
        int p = word.indexOf(letter,j);
        while (p != -1 && (j < newWord.length()-1)){
            newWord = newWord.substring(0,p)+letter+newWord.substring(p+1);
            p = word.indexOf(letter,(j+1));
            j = p;
        }
        return newWord;
    }
    
    public void runWeb(){
        String word = getWord();            
        int n=10, i, l = word.length();
        String newWord = maskWord(l,word); // assign a random string from list to word               
        for(i=0;i<n;i++) {
            Scanner input = new Scanner(System.in);
            String letter = "";
            System.out.println("Your word is: " + newWord);            
            System.out.println("You have " + (n-i) + " left.");   
            while(!checkInput(letter)){
                System.out.println("Input must be one letter");  
                letter = input.nextLine();
            }          
            newWord = runInsideLoop(word,newWord,n,i,letter);           
        }
    }
    
    public void runConsole() {
        String word = getWord();     
        System.out.println(" Can you guess the country?\n");
        
        int n=10, i, l = word.length();
        String newWord = maskWord(l,word); // assign a random string from list to word
        
        for(i=0;i<n;i++){
            
            System.out.println("Your word is: " + newWord);            
            System.out.println("You have " + (n-i) + " left.");            
            
            Scanner input = new Scanner(System.in);
            String letter = "";

            while(!checkInput(letter)){
                System.out.println("Input must be one letter");  
                letter = input.nextLine();
            }
                       
            int j = 1;
            int p = word.indexOf(letter,j);
            
            while (p != -1 && (j < newWord.length()-1)){
                newWord = newWord.substring(0,p)+letter+newWord.substring(p+1);
                p = word.indexOf(letter,(j+1));
                j = p;
            }
        }
    }
}

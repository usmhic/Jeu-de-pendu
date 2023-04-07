package com.example.messagingstompwebsocket;

import java.util.*;
import java.io.*;


public class Jeu {

    public String[] getWordList() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/usama/Documents/GitHub/Jeu-de-pendu-Client-Serveur/Jeu/file.txt")); 
        ArrayList<String> listOfLines = new ArrayList<>();

        String line = br.readLine(); 
        while (line != null) { 
            listOfLines.add(line); 
            line = br.readLine(); 
        }
        br.close();

        String[] newlist = listOfLines.toArray(new String[0]);
        return newlist;
    }

    public String getWord() throws IOException{
        String[] list = getWordList();
        // list of String containing all the countries.        
        Random r = new Random(); 
        // create an object name r from Random Class
        int ranint = r.nextInt(list.length); // use object r to generate random integer between 0 and list length
        String word = list[ranint]; // assign a random string from list to word
        return word;
    }
                
    public String maskWord(String selectedWord){
        int i;
        String word = selectedWord.substring(0,1);
        for(i=1;i<(selectedWord.length()-1);i++){
            word = word +"-";
        }
        word = word + selectedWord.substring(selectedWord.length()-1,selectedWord.length());
        return word;
    }
    
    public String updateWord(String selectedWord, String inputWord, String letter){
        int j = 1;
        int p = selectedWord.indexOf(letter,j);
        while (p != -1 && (j < inputWord.length()-1)){
            inputWord = inputWord.substring(0,p)+letter+inputWord.substring(p+1);
            p = selectedWord.indexOf(letter,(j+1));
            j = p;
        }
        return inputWord;
    }
    
    public boolean checkInput(String input){
        if(input.length() == 1) {
            if( Character.isLetter(input.charAt(0)) ){
                return true;
            }
        }
        return false;
    }
}

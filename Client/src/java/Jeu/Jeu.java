package Jeu;

import java.util.Random;

public class Jeu {
    public String getWord(){
        String[] list = {"Finland", "Russia", "Latvia", "Lithuania", "Poland","Morocco", "Spain", "France", "Portugal"}; // list of String containing all the countries.        
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
    
    public String updateWord(String selectedWord, String inputWord, int n, int i, String letter){
        int j = 1;
        int p = selectedWord.indexOf(letter,j);
        while (p != -1 && (j < inputWord.length()-1)){
            inputWord = inputWord.substring(0,p)+letter+inputWord.substring(p+1);
            p = selectedWord.indexOf(letter,(j+1));
            j = p;
        }
        return inputWord;
    }
}

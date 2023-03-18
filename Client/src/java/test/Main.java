package test;

import java.util.Random;
import java.util.Scanner;

public class Main {
    
    private static String dash_word(int l, String word_list){
        int i;
        String word = word_list.substring(0,1);
        for(i=1;i<l-1;i++){
            word= word +"-";
        }
        word = word + word_list.substring(word_list.length()-1,word_list.length());
        return word;
    }
    
    public static void main(String[] args) {

        String[] list = {"Finland", "Russia", "Latvia", "Lithuania", "Poland"}; // list of String containing all the countries.
        
        Random r = new Random(); // create an object name r from Random Class
        int ranint = r.nextInt(list.length); // use object r to generate random integer between 0 and list length
        String word = list[ranint]; // assign a random string from list to word
        
        System.out.println(" Can you guess the country?\n");
        
        int n=10, i, l = word.length();
        String new_word = dash_word(l,word); // assign a random string from list to word
        
        for(i=0;i<n;i++){
            
            System.out.println("Your word is: " + new_word);            
            System.out.println("You have " + (n-i) + " left.");
             
            Scanner input = new Scanner(System.in);
            String letter = "";

            while(letter.length() != 1){
                System.out.println("Input must be only and only one letter");  
                letter = input.nextLine();
            }
            int j = 1;
            int p = word.indexOf(letter,j);
            
            while (p != -1 && (j < new_word.length()-1)){
                new_word = new_word.substring(0,p)+letter+new_word.substring(p+1);
                p = word.indexOf(letter,(j+1));
                j = p;
            }
        }
    }
}

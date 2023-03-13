package com.mycompany.mavenproject1;

import java.util.Arrays;
import java.util.List;
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
        Random r = new Random();      
        String[] list = {"Finland", "Russia", "Latvia", "Lithuania", "Poland"};
        int ranint = r.nextInt(list.length);
        String word = list[ranint];
        
        System.out.println(word+" Can you guess the word?\n");
        int n=10, i, l = word.length();
        
        String new_word = dash_word(l,word);
        
        for(i=0;i<n;i++){
            
            System.out.println("Your word is: " + new_word);            
            System.out.println("You have " + (n-i) + " left.");
            
            Scanner input = new Scanner(System.in); 
            String letter = input.nextLine();
            int j = 1;
            int p = word.indexOf(letter,j);
            while (p != -1 && (j < new_word.length()-1)){
                new_word = new_word.substring(0,p)+letter+new_word.substring(p+1);
                p = word.indexOf(letter,(j+1));
                j = p;
                System.out.println(p);
            }
        }
    }
}

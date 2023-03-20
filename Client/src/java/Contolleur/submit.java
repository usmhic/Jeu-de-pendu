package Contolleur;

import Jeu.Jeu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "submit", urlPatterns = {"/submit"})

public class submit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        Jeu jeu = new Jeu();       
        String selectedWord = jeu.getWord();        
        
        int n=10, i=0, l = selectedWord.length();
        String inputWord = jeu.maskWord(l,selectedWord); // assign a random string from list to word               

        while(i<n && !inputWord.equals(selectedWord)) {        
            request.getRequestDispatcher("index.jsp").forward(request, response);
            String letter = request.getParameter("inputLetter");  
            inputWord = jeu.updateWord(selectedWord, inputWord, n, i, letter );
            
            session.setAttribute("word", inputWord);
            System.out.println("Your word is: " + inputWord);         
            
            System.out.println("You have " + (n-i) + " left.");  
            i++;
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

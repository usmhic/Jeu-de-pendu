package controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jeu.Jeu;


@WebServlet(name = "submit", urlPatterns = {"/submit"})
public class submit extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Jeu jeu = new Jeu();       
        String word = jeu.getWord();            
        int n=10, i, l = word.length();
        String newWord = jeu.maskWord(l,word); 
        session.setAttribute("PicNum", request.getParameter("Input"));
        session.setAttribute("Random", jeu.getWord());        
        for(i=0;i<n;i++){
            
        }        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

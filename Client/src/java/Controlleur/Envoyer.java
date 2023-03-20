/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usama
 */
@WebServlet(name = "Envoyer", urlPatterns = {"/Envoyer"})
public class Envoyer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        String input = request.getParameter("input");
        boolean vide = false;
        if(Transport != null){
            List<String> TL = Arrays.asList(Transport); 
            session.setAttribute("TransportListe", TL);
            vide = true;
            session.setAttribute("vide",vide);
        }
        session.setAttribute("output", output);
        request.getRequestDispatcher("index.jsp").forward(request, response);        
    }
}

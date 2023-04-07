package Socket;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // la creattion d une socket client qui va connecter ou port 3000 de serveur
            Socket connectSocket = new Socket("localhost", 3000);
            
            //creation d une bufferedReader request qui va lire le flux d’entrée
            BufferedReader request = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));
            
            //creation d une bufferedReader request qui va lire le flux de sortie
            PrintStream send = new PrintStream(connectSocket.getOutputStream());
            
            while(true){
                String message = request.readLine();
                System.out.println(message);
            
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                String letter = console.readLine();
                send.println(letter);
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

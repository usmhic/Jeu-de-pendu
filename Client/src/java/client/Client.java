package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class Client {
    
    public static void main(String[] args) throws IOException {
        
        Socket cs = new Socket("192.168.0.100", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintStream out = new PrintStream(cs.getOutputStream());

        String message = in.readLine();
        System.out.println(message);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String compte = console.readLine();
        out.println(compte);

        message = in.readLine();
        System.out.println(message);

        in.close();
        out.close();
        cs.close();
    }
}

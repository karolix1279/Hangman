package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Input {




    public Input(Socket socket) {

    }

    public static String readFromClients(){

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            Socket socket = serverSocket.accept();
            //System.out.println("Accepted");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //System.out.println(input.readLine());
            return input.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;

        }



    }

    public static String scanLetter() {
        Scanner scanner = new Scanner(System.in);

        return scanner
                .nextLine()
                .trim()
                .toLowerCase();
    }




}

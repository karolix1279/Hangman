import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StartApp {

    public void start() {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToServer = new PrintWriter(socket.getOutputStream(), true);

            String messageFromServer = inputFromServer.readLine();
            System.out.println(messageFromServer);

            while (true) {

                if (messageFromServer.equals("Game Over") || messageFromServer.equals("Congratulation your guess was right"))
                    break;
                Scanner scanner = new Scanner(System.in);
                String echoString = scanner.nextLine();

                stringToServer.println(echoString.trim().toLowerCase());
                messageFromServer = inputFromServer.readLine();
                System.out.println(messageFromServer);

                Thread.sleep(10);

            }

        } catch (IOException | InterruptedException e) {
            e.getMessage();
        }

    }
}

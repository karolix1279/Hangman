import gameLogic.GameThread;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);
        while(true) {
            new GameThread(serverSocket.accept()).start();
        }

    }
}

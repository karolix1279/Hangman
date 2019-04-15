package gameLogic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameThread extends Thread {

    Socket socket;

    public GameThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Game game = new Game();
        try {
            game.startGame(socket);
        } catch (NullPointerException | IOException e){
            e.getMessage();
        }
    }
}

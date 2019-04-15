package gameLogic;

import prepareWord.PrepareWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Game {

    private String word;
    private String[] category;
    private StringBuilder floorsInstedOfLetters;



    public Game() {
        PrepareWord input = new PrepareWord();
        this.word = input.getWord();
        this.category = input.getCategory();
        this.floorsInstedOfLetters = input.createFloorInsteadOfLetters(this.word);

    }

    public void startGame(Socket source) throws IOException {


        Socket socket = source;
        System.out.println("Connected");
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < category.length; i++)
            sb.append(category[i] + " ");

        printWriter.println("Category: " + sb.toString() + ":\t \t" + floorsInstedOfLetters);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int lifes = 5;
        boolean rightGuess;

        while (lifes > 0) {

            if(!(floorsInstedOfLetters.toString().contains("_")))
                break;
            String guess = bufferedReader.readLine().toLowerCase().trim();

            rightGuess = word.trim().contains(guess) && (word.trim().length() == guess.length());

            if (guess.length() == 1 && word.trim().contains(guess)) {

                createStringBuilder(guess);
                printWriter.println(floorsInstedOfLetters.toString());


            } else if (rightGuess) {
                break;
            } else {
                lifes--;
                printWriter.println("Remaining lifes " + lifes);
            }


            if(!(floorsInstedOfLetters.toString().contains("_"))) {
                printWriter.println("Congratulation your guess was right");
                break;
            }
        }


        if (lifes == 0)
            printWriter.println("gameLogic.Game Over");
        else
            printWriter.println("Congratulation your guess was right");

    }


    private void createStringBuilder(String guess) {

        int spaceCounter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ')
                spaceCounter++;
            if (word.charAt(i) == guess.charAt(0)) {
                floorsInstedOfLetters.replace(i * 2 - spaceCounter, i * 2 + 1 - spaceCounter, guess);
            }
        }

    }
}

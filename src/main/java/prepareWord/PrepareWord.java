package prepareWord;

import prepareWord.LoadWords;

import java.util.Random;

public class PrepareWord {

    private String[] category;
    private String word;

    public String getWord() {
        return word;
    }

    public String[] getCategory() {
        return category;
    }

    public PrepareWord() {
        randomWord();
    }

    public void randomWord() {



        String[] words = new LoadWords("words.txt")
                .loadWordFromFile();



        int randomChoice = new Random().nextInt(words.length);

        String[] sentence = words[randomChoice].split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i < sentence.length ; i++){
            sb.append(sentence[i]);
            sb.append(" ");
        }


        System.out.println(sb.toString());
        this.word = sb.toString();
        this.category = words[randomChoice].split(" ")[0].toUpperCase().split("<");

    }

    public StringBuilder createFloorInsteadOfLetters(String word){

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < word.length(); i++){
            if(word.charAt(i) == ' ')
                sb.append(" ");
            else
                sb.append("_ ");
        }

        return sb;
    }

}

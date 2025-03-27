import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String word = getWord();
            String guess;

            int lives = 7;

            ArrayList<String> userGuess = new ArrayList<>();
            ArrayList<String> usedLetters = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                userGuess.add("_");
            }

            while (true) {
                displayGuess(userGuess);

                if (lives <= 0) {
                    System.out.println("\nYou lose! The correct word was " + word + "!");
                    break;
                }

                System.out.print("\nEnter Guess (Lives: " + lives + "): ");
                guess = scanner.nextLine().toLowerCase();

                if (guess.length() != 1) {
                    System.out.println("\nInvalid guess\n");
                    continue;
                }
    
                if (!usedLetters.contains(guess)) {
                    usedLetters.add(guess);
                }
    
                else {
                    System.out.println("\nYou have already used this letter\n");
                    continue;
                }
    
                userGuess = checkGuess(userGuess, word, guess);

                if (!userGuess.contains("_")) {
                    displayGuess(userGuess);
                    System.out.println("\nYou won!");
                    break;
                }

                else {
                    lives--;
                }
            }
        }
    }

    static ArrayList<String> checkGuess(ArrayList<String> userGuess, String word, String guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                userGuess.set(i, String.valueOf(word.charAt(i)));
            }
        }

        return userGuess;
    }

    static void displayGuess(ArrayList<String> userGuess) {
        for (String letter : userGuess) {
            System.out.print(letter + " ");
        }

        System.out.println();
    }

    static String getWord() {
        Random random = new Random();

        String line;
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

            return words.get(random.nextInt(words.size()));
        }

        catch (FileNotFoundException e) {
            System.out.println("Path was invalid or could not be found");
        }

        catch (IOException e) {
            System.out.println("Could not read file");
        }

        return null;
    }
}

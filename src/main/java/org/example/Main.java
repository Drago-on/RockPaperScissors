package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.Scanner;

@Slf4j
public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static String[] choices = {"Rock", "Paper", "Scissors"};
    static int playerScore;
    static int computerScore;

    public static void main(String[] args) {
        int numberOfGames = gamePreparation();
        scanner.nextLine();
        gameStart(numberOfGames);
        gameLog(numberOfGames);
    }

    public static int gamePreparation() {
        System.out.println("How many rounds would you like to play?");
        return scanner.nextInt();
    }

    public static void gameStart(int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("Choose your weapon: Rock, Paper, Scissors or type 'exit' in case you're a pacifist :>");
            String yourChoice = scanner.nextLine().toLowerCase();
            if (yourChoice.equals("exit")) {
                System.out.println("Bye");
                log.info("Game ended by player");
                break;
            }
            int computerIndexChoice = random.nextInt(3);
            String computerChoice = choices[computerIndexChoice];

            if (yourChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("TIE!");
                log.info("Round {}: TIE. Player: {}, Computer: {}. Score - Player: {}, Computer: {}",
                        i + 1, yourChoice, computerChoice, playerScore, computerScore);
            } else if ((yourChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                    (yourChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
                    (yourChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
                playerScore++;
                log.info("Round {}: Player wins. Player: {}, Computer: {}. Score - Player: {}, Computer: {}",
                        i + 1, yourChoice, computerChoice, playerScore, computerScore);
                System.out.println("You win");
                System.out.println(playerScore + " : " + computerScore);
            } else {
                computerScore++;
                log.info("Round {}: Computer wins. Player: {}, Computer: {}. Score - Player: {}, Computer: {}",
                        i + 1, yourChoice, computerChoice, playerScore, computerScore);
                System.out.println("You lose!");
                System.out.println(playerScore + " : " + computerScore);
            }
        }
    }

    public static void gameLog(int numberOfGames){
        log.info("Game ended lasted only {} rounds", numberOfGames);
        if (playerScore > computerScore){
            log.info("Player won the game {} : {}", playerScore, computerScore);
        } else if (computerScore > playerScore) {
            log.info("Computer won the game {} : {}", computerScore, playerScore);
        }
        else {
            log.info("TIE! {} : {}", playerScore, computerScore);
        }
    }
}
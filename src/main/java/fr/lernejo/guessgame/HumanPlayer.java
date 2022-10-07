package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("player");
    @Override
    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
        long numberplayer = scanner.nextLong();
        return numberplayer;
    }

    @Override
    public void respond(boolean lowerOrGreater) {

        this.logger.log(String.valueOf(lowerOrGreater));
    }
}

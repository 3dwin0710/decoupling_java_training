package fr.lernejo.guessgame;

public interface Player {
    long askNextGuess();

    boolean respond(boolean lowerOrGreater);
}

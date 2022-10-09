package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;


public class ComputerPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("ComputerPlayer");
    private long Bornesup = 100;

    private long Borninf;

    private long milieu;
    @Override
    public long askNextGuess() {

        this.milieu = (this.Bornesup+this.Borninf)/2;
        System.out.println("Le robot a choisi:"+this.milieu);
        return this.milieu;
    }

    @Override
    public boolean respond(boolean lowerOrGreater) {
        if(lowerOrGreater){

            this.logger.log("Greater");
            this.Bornesup = this.milieu;
            return true;
            // Sup


        }else {
            this.logger.log("Lower");
            this.Borninf= this.milieu;
            return false;// Inf
        }
    }
}

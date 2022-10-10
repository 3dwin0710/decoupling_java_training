package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;


public class ComputerPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("ComputerPlayer");
    private long Bornesup = Long.MAX_VALUE;
    //private int interation;

    private long Borninf= Long.MIN_VALUE;

    private long milieu;
    @Override
    public long askNextGuess() {
        this.milieu = (this.Bornesup+this.Borninf)/2;
        //System.out.println("Le robot a choisi:"+this.milieu);
        this.logger.log("Le robot a choisi:"+this.milieu);
        //this.interation +=1;
        //this.logger.log("Compteur:"+this.interation);
        return this.milieu;
    }

    @Override
    public boolean respond(boolean lowerOrGreater) {
        if(lowerOrGreater){

            //this.logger.log("Nombre devine plus grand");
            this.Bornesup = this.milieu;
            return true;
            // Sup


        }else {
            //this.logger.log("Nombre devine plus petit");
            this.Borninf= this.milieu;
            return false;// Inf
        }
    }
}

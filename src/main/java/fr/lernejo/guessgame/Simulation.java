package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;


public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("Simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        //System.out.println("Devinez l'âge du capitaine: \n");
        long number = player.askNextGuess();
        //this.logger.log("Le player choisit le nombre: "+number+"\n");
        //System.out.println("Le player choisit le nombre:"+number+"\n");
        if (number == this.numberToGuess) {
           // this.player.respond(true);
            this.logger.log("C'est le bon numéro"+"\n");
           //System.out.println("Le player a deviné le bon numéro\n");
            return true;

        }else if(number < this.numberToGuess){
            this.player.respond(false);
            this.logger.log("Le choix d'âge est plus petit que celle du capitaine"+"\n");
            //System.out.println("Le choix d'âge du player est plus petit que celle du capitaine "+"\n");
           // System.out.println("Trop Petit");
            return false;
        }else {
            this.player.respond(true);
            this.logger.log("Le choix d'âge est plus grand que celle du capitaine "+"\n");
            //System.out.println("Le choix d'âge du player est plus grand que celle du capitaine "+"\n");
            //System.out.println("Trop Grand");
            return false;


        }

    }
    public void loopUntilPlayerSucceed(long maxboucle) {
        //TODO implement me

        long timestamp = System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");

       int compteur = 0;

       while(!nextRound()){
           //nextRound();
           if(compteur>maxboucle){
               this.logger.log("Trop d'itérations...");
               break;
           }
           compteur++;
       }

        long elapsed = System.currentTimeMillis() - timestamp;
        this.logger.log("Le temps émis est de "+ simpleDateFormat.format(elapsed));
        this.logger.log("done");
        //System.out.println("done");
        //this.logger.log(minutes+":"+seconds);

    }
}

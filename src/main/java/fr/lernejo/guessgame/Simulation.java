package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.lang.Math;


public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
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
        System.out.println("Devinez l'âge du capitaine: \n");
        long number = player.askNextGuess();
        this.logger.log("Le player choisit le nombre: "+number+"\n");
        //System.out.println("Le player choisit le nombre:"+number+"\n");

        if (number == this.numberToGuess) {
            this.player.respond(true);
            this.logger.log("Good job!"+"\n");
            //System.out.println("Good Job!"+"\n");
            return true;

        }else if(number < this.numberToGuess){
            this.player.respond(false);
            this.logger.log("Le choix d'âge du player est plus petit que celle du capitaine"+"\n");
            //System.out.println("Le choix du numéro de player est plus petit "+"\n");

           // System.out.println("Trop Petit");
            return false;

        }else {
            this.player.respond(false);
            this.logger.log("Le choix d'âge du player est plus grand que celle du capitaine "+"\n");
            //System.out.println("Le choix du numéro de player est plus grand "+"\n");
            //System.out.println("Trop Grand");
            return false;

        }

    }
    public void loopUntilPlayerSucceed() {
        //TODO implement me
       // do{
         //   nextRound();

        //}
        while(!nextRound()){
            nextRound();
        }
        this.logger.log("Vous avez deviné l'âge du capitaine ^^ !");
    }
}

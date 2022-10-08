package fr.lernejo.guessgame;

import java.security.SecureRandom;



public class Launcher {

    public static boolean VerifNumerique(String valeur){
        try {
            Double.parseDouble(valeur);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) {


        HumanPlayer player = new HumanPlayer();
        ComputerPlayer computer = new ComputerPlayer();
        Simulation simulationcomputer = new Simulation(computer);
        Simulation simulation = new Simulation(player);
        SecureRandom random = new SecureRandom();

        if(args[0].equals("-interactive")) {
            long randomNumber = random.nextInt(100);// génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
            //long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
            System.out.println(randomNumber);

            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

        }

        else if(args[0].equals("-auto")) {
            if(VerifNumerique(args[1])){
                Long FixeNumber = Long.parseLong(args[1]);
                System.out.println(FixeNumber);
                simulationcomputer.initialize(FixeNumber);
                simulationcomputer.loopUntilPlayerSucceed(1000);
            }else{
                System.out.println("Le Deuxième argument n'est pas numérique");
            }

        }
        else{
            System.out.println("Soit -interactive en argument ou -auto avec un autre argument\n");




        }

        //System.out.println("Hello world!");
    }


}

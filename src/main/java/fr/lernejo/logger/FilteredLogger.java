package fr.lernejo.logger;
import java.util.function.Predicate;


public class FilteredLogger implements Logger{

    private Logger delegatelog;
    private Predicate <String> condition;

    //Predicate<String> conditon = message -> !message.contains("player");
    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        //TODO assign arguments to fields
        this.delegatelog = delegate;
        this.condition = condition;

    }

    @Override
    public void log(String message) {
        if(this.condition.test(message)){

            this.delegatelog.log(message);

        }



    }
}

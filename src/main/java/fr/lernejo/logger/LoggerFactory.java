package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        //Logger logger = new ConsoleLogger();
        Logger logger = new FileLogger("Logs.txt");
        return new ContextualLogger(name,logger);
        //return new FileLogger("Log.txt");
    }
}

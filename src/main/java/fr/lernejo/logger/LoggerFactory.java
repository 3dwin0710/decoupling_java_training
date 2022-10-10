package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        Logger logger1 = new ConsoleLogger();
        Logger logger2 = new FileLogger("Logs.txt");
        //Logger logger = new CompositeLogger(logger1,logger2);
        Logger loggerconsole = new ContextualLogger(name,logger1);
        Logger loggerfile = new ContextualLogger(name,logger2);
        return new CompositeLogger(loggerconsole,loggerfile);
        //return new FileLogger("Log.txt");
    }
}

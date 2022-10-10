package fr.lernejo.logger;

import java.util.function.Predicate;
public class LoggerFactory {
    public static Logger getLogger(String name){
        Predicate<String> condition = message -> !message.contains("player");
        Logger logger1 = new ConsoleLogger();
        Logger logger2 = new FileLogger("Logs.txt");
        //Logger logger = new CompositeLogger(logger1,logger2);
        Logger loggerconsole = new ContextualLogger(name,logger1);
        Logger loggerfile = new ContextualLogger(name,logger2);

        Logger loggerfiltrefile = new FilteredLogger(loggerfile,condition);
        return new CompositeLogger(loggerconsole,loggerfiltrefile);
        //return new FileLogger("Log.txt");


    }
}

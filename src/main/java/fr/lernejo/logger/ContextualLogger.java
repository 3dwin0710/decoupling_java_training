package fr.lernejo.logger;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{

    private Logger delegateLogger;
    private String callerClass;
    public ContextualLogger(String class_name, Logger logger){
        this.delegateLogger = logger;
        this.callerClass = class_name;

    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public void log(String message) {
            delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);

    }
}

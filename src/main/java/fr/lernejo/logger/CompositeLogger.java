package fr.lernejo.logger;

public class CompositeLogger implements Logger {

    private Logger delegatelogger1;
    private Logger delegatelogger2;



    public CompositeLogger(Logger logger1, Logger logger2){
        this.delegatelogger1 = logger1;
        this.delegatelogger2 = logger2;
    }
    @Override
    public void log(String message) {
        this.delegatelogger1.log(message);
        this.delegatelogger2.log(message);

    }
}

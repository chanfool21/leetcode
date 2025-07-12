package designpattern.chainofresponsibility;

import designpattern.chainofresponsibility.enums.LogType;
import designpattern.chainofresponsibility.impl.DebugLogger;
import designpattern.chainofresponsibility.impl.ErrorLogger;
import designpattern.chainofresponsibility.impl.InfoLogger;

public class LoggingService {
    static void initializeLoggerChain(LoggerHandler debuggerHandler) {

        LoggerHandler infoHandler = new InfoLogger();
        LoggerHandler errorHandler = new ErrorLogger();

        debuggerHandler.setNextHandler(infoHandler);
        infoHandler.setNextHandler(errorHandler);
        errorHandler.setNextHandler(null);
    }
    public static void main(String[] args) {
        LoggerHandler loggerHandler = new DebugLogger();
        initializeLoggerChain(loggerHandler);
        loggerHandler.logRequest(LogType.DEBUG, "log1");
        loggerHandler.logRequest(LogType.INFO, "log2");
        loggerHandler.logRequest(LogType.ERROR, "log3");
        loggerHandler.logRequest(null, "log4");
    }
}

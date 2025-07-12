package designpattern.chainofresponsibility.impl;

import designpattern.chainofresponsibility.LoggerHandler;
import designpattern.chainofresponsibility.enums.LogType;

public class InfoLogger implements LoggerHandler {
    private LoggerHandler nextLoggerHandler;
    @Override
    public void logRequest(LogType type, String request) {
        if(type != LogType.INFO) {
            if(nextLoggerHandler == null) {
                System.out.println("Cannot log this request as its not of recognised type");
                return;
            }
            nextLoggerHandler.logRequest(type, request);
        } else {
            System.out.println("InfoLogger: log = " + request);
        }
    }

    @Override
    public void setNextHandler(LoggerHandler loggerHandler) {
        this.nextLoggerHandler = loggerHandler;
    }
}

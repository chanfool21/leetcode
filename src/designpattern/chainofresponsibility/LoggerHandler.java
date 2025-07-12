package designpattern.chainofresponsibility;

import designpattern.chainofresponsibility.enums.LogType;

public interface LoggerHandler {
    void logRequest(LogType type, String request);
    void setNextHandler(LoggerHandler loggerHandler);
}

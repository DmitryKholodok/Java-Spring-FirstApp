package com.kholodok.spring.loggers;

import com.kholodok.spring.beans.Event;

public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

}

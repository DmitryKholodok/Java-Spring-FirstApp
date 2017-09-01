package com.kholodok.spring.loggers;

import com.kholodok.spring.beans.Event;

public interface EventLogger {
    void logEvent(Event event);
}

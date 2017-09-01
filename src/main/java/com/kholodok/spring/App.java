package com.kholodok.spring;

import com.kholodok.spring.beans.Client;
import com.kholodok.spring.beans.Event;
import com.kholodok.spring.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("beans.xml");

        App app = (App) ctx.getBean("app");


        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for user 0");

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for user 1");

        ctx.close();

    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }

}

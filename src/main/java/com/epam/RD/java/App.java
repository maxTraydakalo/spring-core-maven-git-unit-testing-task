package com.epam.RD.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;

    App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event) {
        event.setMsg(event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName()));
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = (Event) ctx.getBean("event");
        event.setMsg("Some event from user 1");
        app.logEvent(event);

    }
}

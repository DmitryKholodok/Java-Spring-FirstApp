package com.kholodok.spring.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private String message;
    private Date date;
    private DateFormat df;
    private int id;

    public Event(Date date, DateFormat df) {
        this.id = AUTO_ID.getAndIncrement();

        this.date = date;
        this.df = df;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "message='" + message + '\'' +
                ", date=" + df.format(date) +
                ", id=" + id +
                '}' + "\n";
    }
}

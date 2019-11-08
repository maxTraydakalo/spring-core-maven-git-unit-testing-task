package com.epam.RD.java;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private long id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    {
        id = (int) (Math.random()*Integer.MAX_VALUE);
    }

    Event(Date date, DateFormat dateFormat){
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    @Override
    public String toString() {
        return dateFormat.format(date)+" - "+id+": "+msg;
    }
}

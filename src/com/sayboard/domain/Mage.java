package com.sayboard.domain;

public class Mage {
    private int id;
    private String sendname;
    private String time;
    private String acceptname;
    private String say;

    public Mage() {
    }

    public Mage(int id, String sendname, String time, String acceptname, String say) {
        this.id = id;
        this.sendname = sendname;
        this.time = time;
        this.acceptname = acceptname;
        this.say = say;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAcceptname() {
        return acceptname;
    }

    public void setAcceptname(String acceptname) {
        this.acceptname = acceptname;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }
}

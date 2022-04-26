package com.example.springsecurityfivecass.enumpackage;

public enum StudyFormat {
    ONLINE("online"),
    OFFLINE("offline");

    String a;

    StudyFormat(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}

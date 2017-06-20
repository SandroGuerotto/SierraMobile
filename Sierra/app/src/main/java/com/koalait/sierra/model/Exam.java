package com.koalait.sierra.model;


import java.util.Date;

public class Exam {
    private String theme;
    private Date date;
    private double mark;

    public Exam(String theme, Date date, double mark) {
        this.theme = theme;
        this.date = date;
        this.mark = mark;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}

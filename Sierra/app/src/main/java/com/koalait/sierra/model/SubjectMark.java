package com.koalait.sierra.model;

import com.koalait.sierra.R;

import java.util.ArrayList;

public class SubjectMark {

    private int color;
    private String name;
    private double avgmark;
    private ArrayList<Exam> marks;

    public SubjectMark(String name, ArrayList<Exam> marks) {
        this.name = name;
        this.marks = marks;
        calcAvg();
    }

    private void calcAvg() {
        for (Exam exam : marks) {
            this.avgmark += exam.getMark();
        }
        this.avgmark = this.avgmark / marks.size();
    }

    public void addMark(Exam mark) {
        this.marks.add(mark);
    }

    public int getColor() {
        switch (name) {
            case "Mathematik":
                return R.color.mathe;
            case "Deutsch":
                return R.color.german;
            case "Sport":
                return R.color.sport;
            case "Französisch":
                return R.color.french;
            default:
                return R.color.colorAccent;
        }
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgmark() {
        return avgmark;
    }

    public void setAvgmark(double avgmark) {
        this.avgmark = avgmark;
    }

    public ArrayList<Exam> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Exam> marks) {
        this.marks = marks;
    }
}

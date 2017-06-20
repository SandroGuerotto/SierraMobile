package com.koalait.sierra.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.koalait.sierra.BR;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Model extends BaseObservable {
    private static Model model;
    private String nextLesson;
    private ArrayList<SubjectMark> marks = new ArrayList<>();
    private User currentUser;
    private ArrayList<String> valueList;

    private Model() {

        currentUser = new User("Sandro", "Guerotto", "06.01.1998", "Bühlwiesenstrasse 8", "8600", "Dübendorf", "079 842 28 78", "044 820 11 59", "s.guerotto@gmail.com");
        valueList = new ArrayList<String>();
        initMarks();

    }
    public static Model getInstance(){
        if (model == null){
            model = new Model();
            return model;
        }else{
            return model;
        }
    }

    private void initMarks() {
        Calendar c = Calendar.getInstance();
        ArrayList<Exam> exams = new ArrayList<>();
        Exam exam = new Exam("Trigonometrie 1", new Date(), 3.8);
        exams.add(exam);
        exam = new Exam("Logorithmus", new Date(), 4.5);
        exams.add(exam);
        exam = new Exam("Geometrie 1", new Date(), 5);
        exams.add(exam);
        exam = new Exam("Trigonometrie 2", new Date(), 4.5);
        exams.add(exam);

        SubjectMark subject = new SubjectMark("Mathematik", exams);
        this.marks.add(subject);


        exams = new ArrayList<>();
        exam = new Exam("Gedicht", new Date(), 3.8);
        exams.add(exam);
        exam = new Exam("Aufsatz", new Date(), 4.5);
        exams.add(exam);
        exam = new Exam("Drama & Lyrik", new Date(), 5);
        exams.add(exam);
        subject = new SubjectMark("Deutsch", exams);
        this.marks.add(subject);
    }

    @Bindable
    public String getNextLesson() {
        return this.nextLesson;
    }
    public void setNextLesson(String nextLesson){ this.nextLesson = nextLesson; notifyPropertyChanged(BR.nextLesson); }

    public ArrayList<SubjectMark> getMarks() {
        return marks;
    }

    public User getUser() {
        return currentUser;
    }

    public List<String> getMarkslist() {
        return valueList;
    }
}

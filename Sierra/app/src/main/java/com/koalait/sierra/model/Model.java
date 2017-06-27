package com.koalait.sierra.model;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.koalait.sierra.BR;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Model extends BaseObservable {
    private static Model model;
    public ArrayList<String> notify = new ArrayList<>();
    private String nextLesson;
    private ArrayList<SubjectMark> marks = new ArrayList<>();
    private User currentUser;
    private ArrayList<String> valueList;
    private ArrayList<String> scheduleHeader = new ArrayList<>();
    private ArrayList<ArrayList<String>> schedule = new ArrayList<>();
    private Context context;

    private Model() {

        currentUser = new User("Sandro", "Guerotto", "06.01.1998", "Bühlwiesenstrasse 8", "8600", "Dübendorf", "079 842 28 78", "044 820 11 59", "s.guerotto@gmail.com");
        valueList = new ArrayList<String>();
        initMarks();
        initSchedule();

        notify.add("sfasdf");
        notify.add("sfasdf");
        notify.add("sfasdf");
        notify.add("sfasdf");
        notify.add("sfasdf");

    }

    public static Model getInstance(Context context) {
        if (model == null) {
            model = new Model();
            model.context = context;
            return model;
        } else {
            return model;
        }
    }

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
            return model;
        } else {
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

    public void setNextLesson(String nextLesson) {
        this.nextLesson = nextLesson;
        notifyPropertyChanged(BR.nextLesson);
    }

    public ArrayList<SubjectMark> getMarks() {
        return marks;
    }

    public User getUser() {
        return currentUser;
    }

    public List<String> getMarkslist() {
        return valueList;
    }

    public ArrayList<ArrayList<String>> getSchedule() {
        return schedule;
    }

    public void initSchedule() {
        // create header row
        scheduleHeader.add(" ");
        scheduleHeader.add("MO");
        scheduleHeader.add("DI");
        scheduleHeader.add("MI");
        scheduleHeader.add("DO");
        scheduleHeader.add("FR");
//        schedule.add(scheduleHeader);

        ArrayList<String> lessons = new ArrayList<>();
        lessons.add("07:15 08:00");
        lessons.add("Mathematik");
        lessons.add("Englisch");
        lessons.add("Handarbeit");
        lessons.add("Englisch");
        lessons.add("Deutsch");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("08:05 08:50");
        lessons.add("Mathematik");
        lessons.add("Englisch");
        lessons.add("Handarbeit");
        lessons.add("Englisch");
        lessons.add("Deutsch");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("08:55 09:40");
        lessons.add("Deutsch");
        lessons.add("Mathematik");
        lessons.add("Wirtschaft");
        lessons.add("Chemie");
        lessons.add("Biologie");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("10:10 10:55");
        lessons.add("Deutsch");
        lessons.add("Mathematik");
        lessons.add("Wirtschaft");
        lessons.add("Chemie");
        lessons.add("Biologie");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("11:00 11:45");
        lessons.add("Sport");
        lessons.add("Französisch");
        lessons.add("Geschichte");
        lessons.add("Französisch");
        lessons.add("Erdkunde");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("11:50 12:35");
        lessons.add("");
        lessons.add("");
        lessons.add("");
        lessons.add("");
        lessons.add("Erdkunde");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("12:40 13:25");
        lessons.add("");
        lessons.add("");
        lessons.add("");
        lessons.add("");
        lessons.add("");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("13:30 14:15");
        lessons.add("Physik");
        lessons.add("Musik");
        lessons.add("");
        lessons.add("Sport");
        lessons.add("Geschichte");
        schedule.add(lessons);

        lessons = new ArrayList<>();
        lessons.add("13:30 14:15");
        lessons.add("Physik");
        lessons.add("Musik");
        lessons.add("");
        lessons.add("Sport");
        lessons.add("");
        schedule.add(lessons);
    }

}

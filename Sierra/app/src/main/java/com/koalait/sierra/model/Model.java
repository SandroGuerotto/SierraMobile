package com.koalait.sierra.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.koalait.sierra.BR;


public class Model extends BaseObservable {
    private String nextLesson;
    private static Model model;
    private String[][] marks;

    private Model() {
        marks = new String[][]{
                {"Mathematik",  "Trigonometrie 5", "06.06.2017", "5.4", "mathe"},
                {"Deutsch", "Aufsatz", "30.05.2017", "4.3", "german"},
                {"Französisch", "Aufsatz", "30.05.2017", "4.3", "french"},
                {"Sport", "Aufsatz", "30.05.2017", "4.3", "sport"}
        };
    }
    public static Model getInstance(){
        if (model == null){
            model = new Model();
            return model;
        }else{
            return model;
        }
    }
    @Bindable
    public String getNextLesson() {
        return this.nextLesson;
    }
    public void setNextLesson(String nextLesson){ this.nextLesson = nextLesson; notifyPropertyChanged(BR.nextLesson); }

    public String[][] getMarks(){ return marks; }

    public String[] getHeaderMarks(){ return new String[]{ "Fach", "Thema", "Datum", "Note"}; };


}

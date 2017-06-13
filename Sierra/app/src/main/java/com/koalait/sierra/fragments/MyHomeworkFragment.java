package com.koalait.sierra.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koalait.sierra.R;


/**
 * A simple {@link Fragment} subclass.

 */
public class MyHomeworkFragment extends Fragment {

    public MyHomeworkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_homework, container, false);
    }

}

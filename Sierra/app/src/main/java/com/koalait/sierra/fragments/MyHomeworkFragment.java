package com.koalait.sierra.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.koalait.sierra.ExpandableListDataPump;
import com.koalait.sierra.ListAdapter.CustomExpandableListAdapter;
import com.koalait.sierra.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.

 */
public class MyHomeworkFragment extends Fragment {

    @InjectView(R.id.listView_mywork_next)
    ExpandableListView lv_next;
    @InjectView(R.id.listView_mywork_all)
    ExpandableListView lv_all;

    public MyHomeworkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_homework, container, false);
        ButterKnife.inject(this, view);

        HashMap<String, List<String>> expandableListDetail = ExpandableListDataPump.getData();
        List<String> expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        ExpandableListAdapter expandableListAdapter = new CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);

        lv_next.setAdapter(expandableListAdapter);
        lv_all.setAdapter(expandableListAdapter);
        return view;
    }

}

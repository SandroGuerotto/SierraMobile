package com.koalait.sierra.fragments;

import android.databinding.DataBindingUtil;
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
import com.koalait.sierra.databinding.FragmentDashboardBinding;
import com.koalait.sierra.model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    private ExpandableListView lv_work, lv_news;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;


    public DashboardFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Binding klasse setzten
        FragmentDashboardBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        // Inflate the layout for this fragment
        View view = binding.getRoot();

        // hausaufgaben auf morgen
        lv_work = (ExpandableListView) view.findViewById(R.id.listView_dash_work);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);


        lv_work.setAdapter(expandableListAdapter);

        // news
        lv_news = (ExpandableListView) view.findViewById(R.id.listView_dash_news);
        expandableListAdapter = new CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        lv_news.setAdapter(expandableListAdapter);

        // next lesson
        lv_news = (ExpandableListView) view.findViewById(R.id.listView_dash_news);
        expandableListAdapter = new CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        lv_news.setAdapter(expandableListAdapter);

        binding.setModel(Model.getInstance());

        return view;
    }


}

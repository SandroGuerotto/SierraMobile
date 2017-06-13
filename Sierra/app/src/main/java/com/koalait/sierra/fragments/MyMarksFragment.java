package com.koalait.sierra.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.koalait.sierra.GridAdapter.GridViewAdapter;
import com.koalait.sierra.R;
import com.koalait.sierra.model.Model;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyMarksFragment extends Fragment {


    private GridView gridView;
    private GridViewAdapter gridAdapter;

    public MyMarksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mymarks, container, false);

////        TableView tableView = (TableView) view.findViewById(R.id.tableView_marks);
//        TableView<String[]> tableView = (TableView<String[]>) view.findViewById(R.id.tableView_marks);
//
//        tableView.setDataAdapter(new SimpleTableDataAdapter(getContext(), Model.getInstance().getMarks()));
//        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), Model.getInstance().getHeaderMarks()));


        gridView = (GridView) view.findViewById(R.id.grid_marks);
        gridAdapter = new GridViewAdapter(this.getContext(), R.layout.grid_item_layout, Model.getInstance().getMarks());
        gridView.setAdapter(gridAdapter);
        return view;
    }


}

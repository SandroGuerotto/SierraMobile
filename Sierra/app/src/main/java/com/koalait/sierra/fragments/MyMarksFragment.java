package com.koalait.sierra.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.koalait.sierra.GridAdapter.GridViewAdapter;
import com.koalait.sierra.ListAdapter.MarkListAdapter;
import com.koalait.sierra.R;
import com.koalait.sierra.model.Model;
import com.koalait.sierra.model.SubjectMark;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyMarksFragment extends Fragment {

    private static final String TAG = "MyMarksFragment";

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
        // set data to grid view
        gridView = (GridView) view.findViewById(R.id.grid_marks);
        gridAdapter = new GridViewAdapter(this.getContext(), R.layout.grid_item_layout, Model.getInstance().getMarks());
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener((adapterView, view1, pos, id) -> {
            SubjectMark item = Model.getInstance().getMarks().get(pos);
            showPopup(view, item);
        });
        return view;
    }

    // The method that displays the popup.
    private void showPopup(View view, SubjectMark subjectMark) {
        int popupHeight = 1200;

        // Inflate the popup_layout.xml
        LayoutInflater layoutInflater = (LayoutInflater) view.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_marks, null);
        //define layout color
        layout.setBackgroundResource(subjectMark.getColor());

        // Creating the PopupWindow
        PopupWindow popup = new PopupWindow(view);


        popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);
        popup.setBackgroundDrawable(null);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = 50;
        int OFFSET_Y = 600;

        TextView tv = (TextView) layout.findViewById(R.id.popup_title);
        tv.setText(subjectMark.getName());

        MarkListAdapter adapter = new MarkListAdapter(view.getContext(), android.R.layout.simple_list_item_1, subjectMark.getMarks());
        ListView lv_marks = (ListView) layout.findViewById(R.id.listView_marks);
        lv_marks.setAdapter(adapter);

        popup.setContentView(layout);
        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, OFFSET_X, OFFSET_Y);
    }
}

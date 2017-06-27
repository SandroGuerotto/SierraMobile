package com.koalait.sierra.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.koalait.sierra.R;
import com.koalait.sierra.helper.ColorPicker;
import com.koalait.sierra.model.Model;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    @InjectView(R.id.grid_schedule)
    TableLayout grid;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        ButterKnife.inject(this, view);

        for (ArrayList<String> lesson : Model.getInstance().getSchedule()) {
            TableRow rowView = new TableRow(view.getContext());
            inflater.inflate(R.layout.grid_row_schedule, rowView);

            RowHolder rowHolder = new RowHolder();
            rowHolder.time = (TextView) rowView.findViewById(R.id.schedule_time);
            rowHolder.days.add((TextView) rowView.findViewById(R.id.day1));
            rowHolder.days.add((TextView) rowView.findViewById(R.id.day2));
            rowHolder.days.add((TextView) rowView.findViewById(R.id.day3));
            rowHolder.days.add((TextView) rowView.findViewById(R.id.day4));
            rowHolder.days.add((TextView) rowView.findViewById(R.id.day5));

            rowHolder.time.setText(lesson.get(0));

            for (int i = 1; i <= 5; i++) {
                TextView cell = rowHolder.days.get(i - 1);
                cell.setText(lesson.get(i));
                cell.setBackgroundResource(ColorPicker.getColor(lesson.get(i)));
                int finalI = i;
                if (lesson.get(i).length() > 1)
                    cell.setOnClickListener(view1 -> Toast.makeText(view1.getContext(), lesson.get(finalI), Toast.LENGTH_LONG).show());
            }
            grid.addView(rowView, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
        return view;
    }


    private class RowHolder {
        TextView time;
        ArrayList<TextView> days = new ArrayList<>();
    }
}

package com.koalait.sierra.GridAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koalait.sierra.R;
import com.koalait.sierra.model.SubjectMark;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter {

    private static final String TAG = "GridViewAdapter";
    private Context context;
    private int layoutResourceId;
    private ArrayList<SubjectMark> data = new ArrayList<>();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList<SubjectMark> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;

        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.subject = (TextView) row.findViewById(R.id.subject);
            holder.mark = (TextView) row.findViewById(R.id.mark);
            holder.item = (LinearLayout) row.findViewById(R.id.mark_item);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        SubjectMark item = data.get(position);
        holder.subject.setText(item.getName());
        holder.mark.setText(new DecimalFormat("##.##").format(item.getAvgmark()));
        holder.item.setBackgroundColor(context.getColor(item.getColor()));
        return row;
    }

    private static class ViewHolder {
        TextView subject, mark;
        LinearLayout item;
    }
}
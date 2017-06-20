package com.koalait.sierra.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.koalait.sierra.R;
import com.koalait.sierra.model.Exam;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class MarkListAdapter extends BaseAdapter {

    private static final String TAG = "MarkListAdapter";
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflater;
    private ArrayList<Exam> data = new ArrayList<>();

    public MarkListAdapter(Context context, int layoutResourceId, ArrayList<Exam> data) {
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.inflater = ((Activity) context).getLayoutInflater();
        this.data = data;
        Log.println(Log.DEBUG, TAG, "Grösse: " + data.size());
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_marks, null);
        }
        ViewHolder holder = new ViewHolder();
        holder.theme = (TextView) convertView.findViewById(R.id.list_marks_theme);
        holder.date = (TextView) convertView.findViewById(R.id.list_marks_date);
        holder.mark = (TextView) convertView.findViewById(R.id.list_marks_mark);

        Exam exam = data.get(position);
        holder.theme.setText(exam.getTheme());
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        holder.date.setText(format.format(exam.getDate()));
        holder.mark.setText(new DecimalFormat("##.##").format(exam.getMark()));

        return convertView;
    }

    private static class ViewHolder {
        TextView theme, date, mark;
    }
}

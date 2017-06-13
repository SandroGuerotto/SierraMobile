package com.koalait.sierra.GridAdapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koalait.sierra.R;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter {

    private static final String TAG = "GridViewAdapter";
    private Context context;
    private int layoutResourceId;
    private String[][] data = new String[][]{};

    public GridViewAdapter(Context context, int layoutResourceId, String[][] data) {
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
            holder.theme = (TextView) row.findViewById(R.id.theme);
            holder.mark = (TextView) row.findViewById(R.id.mark);
            holder.date = (TextView) row.findViewById(R.id.date);
            holder.item = (LinearLayout) row.findViewById(R.id.mark_item);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        String[] item = data[position];
        holder.subject.setText(item[0]);
        holder.theme.setText(item[1]);
        holder.mark.setText(item[2]);
        holder.date.setText(item[3]);

        int color = context.getResources().getIdentifier(item[4],"color", context.getPackageName());
//        color = color == 0 ? R.color.Sport : color;
        Log.println(Log.DEBUG, TAG, "colorkey: " + color);
        holder.item.setBackgroundColor(context.getColor(color));
        return row;
    }

    static class ViewHolder {
        TextView subject, theme, mark, date;
        LinearLayout item;
    }
}
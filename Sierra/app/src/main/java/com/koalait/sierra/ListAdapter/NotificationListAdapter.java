package com.koalait.sierra.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.koalait.sierra.R;

import java.util.ArrayList;


public class NotificationListAdapter extends BaseAdapter {

    private static final String TAG = "NotificationListAdapter";
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflater;
    private ArrayList<String> data = new ArrayList<>();

    public NotificationListAdapter(Context context, int layoutResourceId, ArrayList<String> data) {
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
            convertView = layoutInflater.inflate(R.layout.list_item_notification, null);
        }
        return convertView;
    }
}

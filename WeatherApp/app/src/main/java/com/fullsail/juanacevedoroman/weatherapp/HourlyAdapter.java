package com.fullsail.juanacevedoroman.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.ArrayList;

/**
 * Created by davidamalfitano on 8/28/14.
 */
public class HourlyAdapter extends BaseAdapter {

    private final long ID_CONSTANT = 0x0000;
    private Context mContext;
    private ArrayList<HourlyPull> mObjects;
    private int mlayout;

    public HourlyAdapter(Context c, ArrayList<HourlyPull> objects, int _layout) {
        mContext = c;
        mObjects = objects;
        mlayout = _layout;

    }


    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public HourlyPull getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ID_CONSTANT + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mlayout, parent, false);
        }

        // object item based on the position
        if (mlayout == R.layout.hour_list_cell) {

            HourlyPull item = getItem(position);


            SmartImageView myImage = (SmartImageView) convertView.findViewById(R.id.hour_cellImage);
            TextView civilT = (TextView) convertView.findViewById(R.id.hour_cellTime);
            TextView tempT = (TextView) convertView.findViewById(R.id.hour_cellTemp);



            myImage.setImageUrl(item.icon_urlPull);
            civilT.setText(item.civilPull);
            tempT.setText("High: " + item.tempPull);



        }

        return convertView;
    }
}

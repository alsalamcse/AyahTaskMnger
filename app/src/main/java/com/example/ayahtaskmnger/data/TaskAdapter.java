package com.example.ayahtaskmnger.data;

import android.content.Context;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ayahtaskmnger.R;

public class TaskAdapter extends ArrayAdapter<MyTask> {

    public TaskAdapter(@NonNull Context context) {
        super(context, R.layout.taskitem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //building item view

        View viem = LayoutInflater.from(getContext()).inflate(R.layout.taskitem, parent, true);
        TextView tvTittle = viem.findViewById(R.id.itmTvtittle);
        TextView tvSupject = viem.findViewById(R.id.itmTvsupject);
        RatingBar rbPrio = viem.findViewById(R.id.itmRatingPrio);
        CheckBox chIsCompleted = viem.findViewById(R.id.itmChbxlsCompleted);

        ImageView ivInfo = viem.findViewById(R.id.itmImageInfo);
        //geting data source
        MyTask myTask = getItem(position);

        //connect item view to data source
        tvTittle.setText(myTask.getTittle());

        //*
        //TODO

         tvSupject.setText(myTask.getSubject());

        rbPrio.setRating(myTask.getImportant());
        chIsCompleted.setChecked(false);



        return viem;

    }

}

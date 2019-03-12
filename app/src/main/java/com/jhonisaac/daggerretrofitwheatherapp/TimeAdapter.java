package com.jhonisaac.daggerretrofitwheatherapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Time;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewHolder> {

    private List<Time> meteorology;

    public TimeAdapter() {
        meteorology = new ArrayList<>();
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_time, parent, false);
        return new TimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {
            Time time = new Time();
            time = meteorology.get(position);
            Long timeLong = Long.parseLong(time.getDt());
        Date date = new Date(timeLong*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeString = simpleDateFormat.format(date);
        holder.litDate.setText(timeString);
        holder.litHumid.setText(time.getMain().getHumidity());
        holder.litTemperature.setText(time.getMain().getTemp());

    }

    @Override
    public int getItemCount() {
        return meteorology.size();
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder {

        private TextView litDate;
        private TextView litHumid;
        private TextView litTemperature;


        public TimeViewHolder(View itemView) {
            super(itemView);
            litDate = itemView.findViewById(R.id.litDate);
            litHumid = itemView.findViewById(R.id.litHumid);
            litTemperature = itemView.findViewById(R.id.litTemperature);
        }
    }

    public void setData(List<Time> data){
        this.meteorology.addAll(data);
        notifyDataSetChanged();
    }

}

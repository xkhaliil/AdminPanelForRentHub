package com.example.adminrenthub;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AcceptedViewHolder extends RecyclerView.ViewHolder {
    TextView CarName,startdate,enddate,location,total;
    ImageView imageView;
    public AcceptedViewHolder(@NonNull View itemView) {
        super(itemView);
        CarName = itemView.findViewById(R.id.carname);
        startdate = itemView.findViewById(R.id.startdate);
        enddate = itemView.findViewById(R.id.enddate);
        location = itemView.findViewById(R.id.location);
        total = itemView.findViewById(R.id.total);
        imageView = itemView.findViewById(R.id.imageview);
    }
}
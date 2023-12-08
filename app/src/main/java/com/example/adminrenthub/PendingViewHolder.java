package com.example.adminrenthub;
import com.example.adminrenthub.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PendingViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView CarName, startdate, enddate,location, total, status;


    public PendingViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        CarName = itemView.findViewById(R.id.carname);
        startdate = itemView.findViewById(R.id.startdate);
        enddate = itemView.findViewById(R.id.enddate);
        location = itemView.findViewById(R.id.location);
        total = itemView.findViewById(R.id.total);
    }
}

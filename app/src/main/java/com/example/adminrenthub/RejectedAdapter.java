package com.example.adminrenthub;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RejectedAdapter extends RecyclerView.Adapter<RejectedViewHolder> {
    private Context context;
    private List<Rents> rents;

    public RejectedAdapter(Context context, List<Rents> rents) {
        this.context = context;
        this.rents = rents;
    }

    @NonNull
    @Override
    public RejectedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rejected_item,parent,false);
        return new RejectedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RejectedViewHolder holder, int position) {
        holder.CarName.setText(rents.get(position).getCarName());
        holder.startdate.setText(rents.get(position).getStartDate());
        holder.enddate.setText(rents.get(position).getEndDate());
        holder.location.setText(rents.get(position).getLocation());
        holder.total.setText(rents.get(position).getTotal());
        String status = rents.get(position).getStatus();
        if(status.equals("rejected")) {
            holder.imageView.setImageResource(R.drawable.rejected);
        }
        holder.itemView.setOnClickListener(v -> {
            String id = rents.get(position).getId();
            String carUID = rents.get(position).getCarUID();
            String userUID = rents.get(position).getUserID();
            String start = rents.get(position).getStartDate();
            String end = rents.get(position).getEndDate();
            String total = rents.get(position).getTotal();
            String location = rents.get(position).getLocation();
            String status1 = rents.get(position).getStatus();
            String carName = rents.get(position).getCarName();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Rent Details");
            builder.setMessage("Car Name: " + carName + "\n"
                    + "Start Date: " + start + "\n"
                    + "End Date: " + end + "\n"
                    + "Total: " + total + "\n"
                    + "Location: " + location + "\n"
                    + "Status: " + status1 + "\n"
            );
            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return rents.size();
    }
}
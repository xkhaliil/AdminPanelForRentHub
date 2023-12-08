package com.example.adminrenthub;
import com.example.adminrenthub.R;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminrenthub.Rents;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class PendingAdapter extends RecyclerView.Adapter<PendingViewHolder> {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Context context;
    List<Rents> rentsList;
    public PendingAdapter(Context context, List<Rents> rentsList) {
        this.context = context;
        this.rentsList = rentsList;
    }
       @NonNull
    @Override
    public PendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PendingViewHolder(LayoutInflater.from(context).inflate(R.layout.pending_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PendingViewHolder holder, int position) {
        holder.CarName.setText(rentsList.get(position).getCarName());
        holder.startdate.setText(rentsList.get(position).getStartDate() );
        holder.enddate.setText(rentsList.get(position).getEndDate());
        holder.location.setText(rentsList.get(position).getLocation());
        holder.total.setText(rentsList.get(position).getTotal());
        String status = rentsList.get(position).getStatus();
        if(status.equals("pending")) {
            holder.imageView.setImageResource(R.drawable.pending);
        }
        //on click
        holder.itemView.setOnClickListener(v -> {
            String id = rentsList.get(position).getId();
            String carUID = rentsList.get(position).getCarUID();
            String userUID = rentsList.get(position).getUserID();
            String start = rentsList.get(position).getStartDate();
            String end = rentsList.get(position).getEndDate();
            String total = rentsList.get(position).getTotal();
            String location = rentsList.get(position).getLocation();
            String status1 = rentsList.get(position).getStatus();
            String carName = rentsList.get(position).getCarName();
            //open a simple pop up dialog to show the details and show two buttons to accept or reject
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Rent Details");
            builder.setMessage("Car Name: " + carName + "\n"
                    + "Start Date: " + start + "\n"
                    + "End Date: " + end + "\n"
                    + "Total: " + total + "\n"
                    + "Location: " + location + "\n"
                    + "Status: " + status1);

            // Add buttons for accept and reject
            builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.collection("rents").document(id).update("status", "approved");
                }
            });

            builder.setNegativeButton("Reject", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.collection("rents").document(id).update("status", "rejected");
                }
            });

            // Create and show the dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return rentsList.size();
    }

}

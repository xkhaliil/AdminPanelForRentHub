package com.example.adminrenthub;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminrenthub.R;

public class CarsrvViewHolder extends RecyclerView.ViewHolder {
    TextView name, details, price;
    ImageView image;

    public CarsrvViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        details = itemView.findViewById(R.id.details);
        price = itemView.findViewById(R.id.price);
        image = itemView.findViewById(R.id.imageView);
    }
}

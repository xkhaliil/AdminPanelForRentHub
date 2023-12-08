package com.example.adminrenthub;

import com.example.adminrenthub.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminrenthub.Cars;

import java.util.List;

public class CarsrvAdapter extends RecyclerView.Adapter<CarsrvViewHolder> {
    public static String idCar;
    Context context;
    List<Cars> cars;
    public CarsrvAdapter(Context context, List<Cars> cars) {
        this.context = context;
        this.cars = cars;
    }
@NonNull
@Override
    public CarsrvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarsrvViewHolder(LayoutInflater.from(context).inflate(R.layout.carsrv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarsrvViewHolder holder, int position) {
        holder.name.setText(cars.get(position).getName());
        holder.details.setText(cars.get(position).getType());
        holder.price.setText(cars.get(position).getAvailibility());
        holder.itemView.setOnClickListener(v -> {
            String id = cars.get(position).getId();
            String name = cars.get(position).getName();
            String price = cars.get(position).getAvailibility();
            String status = cars.get(position).getAvailibility();
            String type = cars.get(position).getType();
            idCar = id;
            Toast.makeText(context, "Car: "+name+"  has been selected", Toast.LENGTH_SHORT).show();
            holder.image.setImageResource(R.drawable.selected);
        });
    }


    @Override
    public int getItemCount() {
        return cars.size();
    }
}

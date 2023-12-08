package com.example.adminrenthub;

import static com.example.adminrenthub.CarsrvAdapter.idCar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ManageCarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        setContentView(R.layout.manage_cars_main);
        Button DeleteCar = findViewById(R.id.button2);
        Button AddCar = findViewById(R.id.button5);
        Button refresh = findViewById(R.id.button10);
        Spinner spinner = findViewById(R.id.spinner2);
        Button yes = findViewById(R.id.button11);
        Button no = findViewById(R.id.button12);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CarTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        RecyclerView recyclerView = findViewById(R.id._dynamiccarsrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Cars> cars = new ArrayList<Cars>();
        CarsrvAdapter carsrvAdapter = new CarsrvAdapter(this, cars);
        recyclerView.setAdapter(carsrvAdapter);

        refresh.setOnClickListener(v -> {
            String cartype = spinner.getSelectedItem().toString();
            cars.clear();
            carsrvAdapter.notifyDataSetChanged();
            System.out.println(cartype);
            if (cartype!=null){
            db.collection("cars").
                    whereEqualTo("type", cartype).
                    get().
                    addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                        String id = document.getId();
                        String name = document.getString("name");
                        String price = document.getString("price");
                        String status = document.getString("availability");
                        String type = document.getString("type");
                        Cars car = new Cars(id, name, price, status, type);
                        cars.add(car);
                        carsrvAdapter.notifyDataSetChanged();

                    }
                } else {
                    System.out.println("Error getting documents: " + task.getException());
                }
            });}
            });

        yes.setOnClickListener(v -> {

            String id = idCar;
            if (id!=null){
            db.collection("cars").document(id).update("availability", "yes");
            cars.clear();
            carsrvAdapter.notifyDataSetChanged();

            }else {
                Toast.makeText(this, "Please select a car", Toast.LENGTH_SHORT).show();
            }
                }
        );

        no.setOnClickListener(v -> {
            String id = idCar;
            if (id!=null){
            db.collection("cars").document(id).update("availability", "no");
            cars.clear();
            carsrvAdapter.notifyDataSetChanged();
            }else {
                Toast.makeText(this, "Please select a car", Toast.LENGTH_SHORT).show();
            }
        });


        DeleteCar.setOnClickListener(v -> {
            String id = idCar;
            db.collection("cars").document(id).delete();
            cars.clear();

            carsrvAdapter.notifyDataSetChanged();
        });






        AddCar.setOnClickListener(v -> {
            Intent intent = new Intent(ManageCarsActivity.this, AddCarActivity.class);
            startActivity(intent);
        });
    }
}
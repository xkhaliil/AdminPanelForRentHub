package com.example.adminrenthub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ManageRentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_rents);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Rents> rents = new ArrayList<Rents>();
        PendingAdapter pendingRentsrvAdapter = new PendingAdapter(this, rents);
        recyclerView.setAdapter(pendingRentsrvAdapter);

        db.collection("rents").whereEqualTo("status", "pending")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                            String id = document.getId();
                            String carUID = document.getString("carUID");
                            String userUID = document.getString("userID");
                            String start = document.getString("startDate");
                            start = start.substring(0, 10);
                            String end = document.getString("endDate");
                            end = end.substring(0, 10);
                            String total = document.getString("total");
                            String location = document.getString("location");
                            String status = document.getString("status");
                            String carName = document.getString("carName");
                            Rents rent = new Rents(id, carUID, userUID, start, end, total, location, status, carName);
                            System.out.println(rent);
                            rents.add(rent);
                            pendingRentsrvAdapter.notifyDataSetChanged();
                        }
                    }
                });



        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Rents> rents2 = new ArrayList<Rents>();
        AcceptedAdapter acceptedRentsrvAdapter = new AcceptedAdapter(this, rents2);
        recyclerView.setAdapter(acceptedRentsrvAdapter);
        db.collection("rents").whereEqualTo("status", "approved")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                            String id = document.getId();
                            String carUID = document.getString("carUID");
                            String userUID = document.getString("userID");
                            String start = document.getString("startDate");
                            start = start.substring(0, 10);
                            String end = document.getString("endDate");
                            end = end.substring(0, 10);
                            String total = document.getString("total");
                            String location = document.getString("location");
                            String status = document.getString("status");
                            String carName = document.getString("carName");
                            Rents rent = new Rents(id, carUID, userUID, start, end, total, location, status, carName);
                            System.out.println(rent);
                            rents2.add(rent);
                            acceptedRentsrvAdapter.notifyDataSetChanged();
                        }
                    }
                });

        recyclerView = findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Rents> rents3 = new ArrayList<Rents>();
        RejectedAdapter rejectedRentsrvAdapter = new RejectedAdapter(this, rents3);
        recyclerView.setAdapter(rejectedRentsrvAdapter);
        db.collection("rents").whereEqualTo("status", "rejected")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                            String id = document.getId();
                            String carUID = document.getString("carUID");
                            String userUID = document.getString("userID");
                            String start = document.getString("startDate");
                            start = start.substring(0, 10);
                            String end = document.getString("endDate");
                            end = end.substring(0, 10);
                            String total = document.getString("total");
                            String location = document.getString("location");
                            String status = document.getString("status");
                            String carName = document.getString("carName");
                            Rents rent = new Rents(id, carUID, userUID, start, end, total, location, status, carName);
                            System.out.println(rent);
                            rents3.add(rent);
                            rejectedRentsrvAdapter.notifyDataSetChanged();
                        }
                    }
                });


        Button refresh = findViewById(R.id.button7);
        refresh.setOnClickListener(v -> {
            rents.clear();
            rents2.clear();
            rents3.clear();
            db.collection("rents").whereEqualTo("status", "pending")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                                String id = document.getId();
                                String carUID = document.getString("carUID");
                                String userUID = document.getString("userID");
                                String start = document.getString("startDate");
                                start = start.substring(0, 10);
                                String end = document.getString("endDate");
                                end = end.substring(0, 10);
                                String total = document.getString("total");
                                String location = document.getString("location");
                                String status = document.getString("status");
                                String carName = document.getString("carName");
                                Rents rent = new Rents(id, carUID, userUID, start, end, total, location, status, carName);
                                System.out.println(rent);
                                rents.add(rent);

                            }
                        }
                        pendingRentsrvAdapter.notifyDataSetChanged();
                    });

            db.collection("rents").whereEqualTo("status", "approved")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                                String id = document.getId();
                                String carUID = document.getString("carUID");
                                String userUID = document.getString("userID");
                                String start = document.getString("startDate");
                                start = start.substring(0, 10);
                                String end = document.getString("endDate");
                                end = end.substring(0, 10);
                                String total = document.getString("total");
                                String location = document.getString("location");
                                String status = document.getString("status");
                                String carName = document.getString("carName");
                                Rents rent = new Rents(id, carUID, userUID, start, end, total, location, status, carName);
                                System.out.println(rent);
                                rents2.add(rent);

                            }
                        }acceptedRentsrvAdapter.notifyDataSetChanged();
                    });

            db.collection("rents").whereEqualTo("status", "rejected")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                                String id = document.getId();
                                String carUID = document.getString("carUID");
                                String userUID = document.getString("userID");
                                String start = document.getString("startDate");
                                start = start.substring(0, 10);
                                String end = document.getString("endDate");
                                end = end.substring(0, 10);
                                String total = document.getString("total");
                                String location = document.getString("location");
                                String status = document.getString("status");
                                String carName = document.getString("carName");
                                Rents rent = new Rents(id, carUID, userUID, start, end, total, location, status, carName);
                                System.out.println(rent);
                                rents3.add(rent);

                            }
                        }rejectedRentsrvAdapter.notifyDataSetChanged();
                    });

        });
    }
}
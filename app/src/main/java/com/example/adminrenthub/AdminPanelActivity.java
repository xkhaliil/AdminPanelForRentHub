package com.example.adminrenthub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AdminPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel_main);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword("admin@gmail.com","azerty");
        Button cars = findViewById(R.id.button1);

        Button rents = findViewById(R.id.button3);
        cars.setOnClickListener(v -> {
            Intent intent = new Intent(AdminPanelActivity.this, ManageCarsActivity.class);
            startActivity(intent);
        });
        rents.setOnClickListener(v -> {
            Intent intent = new Intent(AdminPanelActivity.this, ManageRentsActivity.class);
            startActivity(intent);
        });
    }
}
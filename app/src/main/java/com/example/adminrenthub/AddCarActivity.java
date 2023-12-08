package com.example.adminrenthub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car_main);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Spinner spinner = findViewById(R.id.spinner);
        EditText CarName = findViewById(R.id.editTextText);
        EditText CarPrice = findViewById(R.id.editTextText2);
        CheckBox available = findViewById(R.id.checkBox2);
        Button AddCar = findViewById(R.id.button5);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CarTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AddCar.setOnClickListener(v -> {
            String cartype = spinner.getSelectedItem().toString();
            String carname = CarName.getText().toString();
            String carprice = CarPrice.getText().toString();
            String avaiable;
            boolean caravailable = available.isChecked();
            if(caravailable){
                 available.setText("yes");
            }
            else{
                available.setText("no");
            }
            if (carname.isEmpty()){
                CarName.setError("Car Name is required");
                CarName.requestFocus();
                return;
            }
            if (carprice.isEmpty()){
                CarPrice.setError("Car Price is required");
                CarPrice.requestFocus();
                return;
            }
            if (carname!=null && carprice!=null){
                Map<String, Object> car = new HashMap<>();
                car.put("type", cartype.toString());
                car.put("name", carname);
                car.put("price", carprice);
                car.put("availability", available.getText().toString());
                db.collection("cars").add(car);
                finish();
            }
        });
    }
}
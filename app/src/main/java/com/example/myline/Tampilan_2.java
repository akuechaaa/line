package com.example.myline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Tampilan_2 extends AppCompatActivity {

    private ImageButton backButton;
    private TextView text1, text2, text3;
    private Spinner spinnerCountries;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan2);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.btn1);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        spinnerCountries = findViewById(R.id.spinnerCountries);

        List<String> countries = new ArrayList<>();
        countries.add("Indonesia");
        countries.add("Turki");
        countries.add("Palestina");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountries.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Button okButton = findViewById(R.id.btnok2);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedCountry = (String) spinnerCountries.getSelectedItem();
                Intent intent = new Intent(Tampilan_2.this, Tampilan_3.class);
                intent.putExtra("selected_country", selectedCountry);
                startActivity(intent);
            }
        });
    }
}




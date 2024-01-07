package com.example.myline;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tampilan_9 extends AppCompatActivity {

    private ImageButton addVoomButton;
    private ImageButton addPersonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan9);
        getSupportActionBar().hide();

        addVoomButton = findViewById(R.id.addvoom);
        addPersonButton = findViewById(R.id.addperson);

        addVoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Add Voom Button Clicked");
                // Add your logic for the addVoomButton click event here
            }
        });

        addPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Add Person Button Clicked");
                // Add your logic for the addPersonButton click event here
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    navigateToBeranda();
                    return true;
                case R.id.navigation_obrolan:
                    navigateToObrolan();
                    return true;
                case R.id.navigation_voom:
                    navigateToVoom();
                    return true;
                case R.id.navigation_panggilan:
                    navigateToPanggilan();
                    return true;
            }
            return false;
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToBeranda() {
        showToast("Navigating to Beranda");
        Intent intent = new Intent(Tampilan_9.this, Tampilan_7.class);
        startActivity(intent);
    }

    private void navigateToObrolan() {
        showToast("Navigating to Obrolan");
        Intent intent = new Intent(Tampilan_9.this, Tampilan_8.class);
        startActivity(intent);

    }

    private void navigateToVoom() {
        showToast("Navigating to Voom");
        Intent intent = new Intent(Tampilan_9.this, Tampilan_9.class);
        startActivity(intent);
    }

    private void navigateToPanggilan() {
        showToast("Navigating to Panggilan");
        Intent intent = new Intent(Tampilan_9.this, Tampilan_10.class);
        startActivity(intent);
    }

}
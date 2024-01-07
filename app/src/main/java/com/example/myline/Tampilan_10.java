package com.example.myline;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tampilan_10 extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan10);
        getSupportActionBar().hide();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

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
        Intent intent = new Intent(Tampilan_10.this, Tampilan_7.class);
        startActivity(intent);
    }

    private void navigateToObrolan() {
        showToast("Navigating to Obrolan");
        Intent intent = new Intent(Tampilan_10.this, Tampilan_8.class);
        startActivity(intent);

    }

    private void navigateToVoom() {
        showToast("Navigating to Voom");
        Intent intent = new Intent(Tampilan_10.this, Tampilan_9.class);
        startActivity(intent);
    }

    private void navigateToPanggilan() {
        showToast("Navigating to Panggilan");
        Intent intent = new Intent(Tampilan_10.this, Tampilan_10.class);
        startActivity(intent);
    }
}

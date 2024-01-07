package com.example.myline;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity; // Hapus salah satu baris ini
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_beranda:
                        // Implement action for Beranda
                        return true;
                    case R.id.navigation_obrolan:
                        // Implement action for Obrolan
                        return true;
                    case R.id.navigation_voom:
                        // Implement action for Voom
                        return true;
                    case R.id.navigation_panggilan:
                        // Implement action for Panggilan
                        return true;
                }
                return false;
            }
        });
    }
}


package com.example.myline;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tampilan_8 extends AppCompatActivity {

    private TextView txtObrolan;
    private ImageButton moreVertButton, addChartButton;
    private EditText editTextCari;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan8);
        getSupportActionBar().hide();

        txtObrolan = findViewById(R.id.TxtObrolan);
        moreVertButton = findViewById(R.id.vert);
        addChartButton = findViewById(R.id.chart);
        editTextCari = findViewById(R.id.EditTextCari);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        moreVertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });

        addChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleAddChartButtonClick();
            }
        });

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

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.bottom_navigation_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_beranda:
                        showToast("Beranda");
                        navigateToBeranda();
                        return true;
                    case R.id.navigation_obrolan:
                        showToast("Obrolan");
                        navigateToObrolan();
                        return true;
                    case R.id.navigation_voom:
                        showToast("Voom");
                        navigateToVoom();
                        return true;
                    case R.id.navigation_panggilan:
                        showToast("Panggilan");
                        navigateToPanggilan();
                        return true;

                }
                return false;
            }
        });

        popupMenu.show();
    }

    private void handleAddChartButtonClick() {
        showToast("AddChartButton Clicked");
    }

    private void navigateToBeranda() {
        showToast("Navigating to Beranda");
        Intent intent = new Intent(Tampilan_8.this, Tampilan_7.class);
        startActivity(intent);
    }

    private void navigateToObrolan() {
        showToast("Navigating to Obrolan");
        Intent intent = new Intent(Tampilan_8.this, Tampilan_8.class);
        startActivity(intent);

    }

    private void navigateToVoom() {
        showToast("Navigating to Voom");
        Intent intent = new Intent(Tampilan_8.this, Tampilan_9.class);
        startActivity(intent);
    }

    private void navigateToPanggilan() {
        showToast("Navigating to Panggilan");
        Intent intent = new Intent(Tampilan_8.this, Tampilan_10.class);
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

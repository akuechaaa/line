package com.example.myline;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Tampilan_7 extends AppCompatActivity {

    private EditText editTextCari;
    private TextView text6;
    private ImageButton btn2, btnMark;
    private ImageButton btnAddFriend;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan7);
        getSupportActionBar().hide();

        editTextCari = findViewById(R.id.EditTextCari);
        text6 = findViewById(R.id.text6);
        btnMark = findViewById(R.id.BtnMark);
        btnAddFriend = findViewById(R.id.btnAddFriend);
        bottomNavigationView = findViewById(R.id.bottom_navigation);



        btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFriend();
            }
        });

        btnMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("BtnMark Clicked");
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    showToast("Beranda");
                    return true;
                case R.id.navigation_obrolan:
                    showToast("Obrolan");
                    Intent intent = new Intent(Tampilan_7.this, Tampilan_8.class);
                    startActivity(intent);
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

    private void addFriend() {
        String friendUsername = editTextCari.getText().toString();
        if (!friendUsername.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Send Friend Request")
                    .setMessage("Do you want to send a friend request to " + friendUsername + "?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            showToast("Friend request sent to: " + friendUsername);
                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            showToast("Enter a username to add a friend.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToBeranda() {
        showToast("Navigating to Beranda");
        Intent intent = new Intent(Tampilan_7.this, Tampilan_7.class);
        startActivity(intent);
    }

    private void navigateToObrolan() {
        showToast("Navigating to Obrolan");
        Intent intent = new Intent(Tampilan_7.this, Tampilan_8.class);
        startActivity(intent);
    }

    private void navigateToVoom() {
        showToast("Navigating to Voom");
        Intent intent = new Intent(Tampilan_7.this, Tampilan_9.class);
        startActivity(intent);
    }

    private void navigateToPanggilan() {
        showToast("Navigating to Panggilan");
        Intent intent = new Intent(Tampilan_7.this, Tampilan_10.class);
        startActivity(intent);
    }

}

package com.example.myline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        loginButton = findViewById(R.id.button);
        registerButton = findViewById(R.id.button2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Login button clicked");

                Intent intent = new Intent(MainActivity.this, Tampilan_2.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Daftar button clicked");

                Intent intent = new Intent(MainActivity.this, Tampilan_2.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showExitConfirmationDialog();
    }

    private boolean isConfirmationReceived = false;

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Confirmation");
        builder.setMessage("Apakah anda yakin ingin keluar dari Line KW?");

        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                isConfirmationReceived = true;
                finish();
            }
        });

        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (!isConfirmationReceived) {
                    Toast.makeText(MainActivity.this, "Exit canceled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.show();
    }

}

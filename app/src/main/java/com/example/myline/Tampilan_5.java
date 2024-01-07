package com.example.myline;

import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;




public class Tampilan_5 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan5);
        getSupportActionBar().hide();

        TextView textView = findViewById(R.id.textbaru);

        Button agreeButton = findViewById(R.id.setuju);
        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {goToTampilan6();
            }
        });

        Button disagreeButton = findViewById(R.id.tidaksetuju);
        disagreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDisagreeMessage();
            }
        });
    }

    private void goToTampilan6() {
        Intent intent = new Intent(Tampilan_5.this, Tampilan_6.class);
        startActivity(intent);
        finish();
    }

    private void showDisagreeMessage() {
        Toast.makeText(this, "Anda tidak setuju dengan ketentuan penggunaan.", Toast.LENGTH_SHORT).show();
        finishAffinity();
    }
}



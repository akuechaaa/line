package com.example.myline;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class Tampilan_6 extends AppCompatActivity {

    private CheckBox checkBoxLocation;
    private CheckBox checkBoxLineBeacon;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan6);
        getSupportActionBar().hide();

        checkBoxLocation = findViewById(R.id.checkBox1);
        checkBoxLineBeacon = findViewById(R.id.checkBox2);
        btnOK = findViewById(R.id.btnok6);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean agreeToShareLocation = checkBoxLocation.isChecked();
                boolean agreeToUseLineBeacon = checkBoxLineBeacon.isChecked();


                showToast("Setuju untuk berbagi Lokasi");
                showToast("Setuju untuk menggunakan Line Beacon");

                Intent intent = new Intent(Tampilan_6.this, Tampilan_7.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("shareLocation", agreeToShareLocation);
                intent.putExtra("useLineBeacon", agreeToUseLineBeacon);
                startActivity(intent);
            }
        });
    }




    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

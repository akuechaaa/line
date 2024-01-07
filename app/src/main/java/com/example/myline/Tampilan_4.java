package com.example.myline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Tampilan_4 extends AppCompatActivity {

    private TextView textView4, text5, kapital1, kapital2, kapital3, kapital4;
    private EditText edtTxt2, edtTxtRepeat;
    private ImageButton backButton, markButton, forwardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan4);
        getSupportActionBar().hide();

        textView4 = findViewById(R.id.textView4);
        text5 = findViewById(R.id.text5);
        kapital1 = findViewById(R.id.kapital1);
        kapital2 = findViewById(R.id.kapital2);
        kapital3 = findViewById(R.id.kapital3);
        kapital4 = findViewById(R.id.kapital4);
        edtTxt2 = findViewById(R.id.EdtTxt2);
        edtTxtRepeat = findViewById(R.id.edtTxtRepeat);
        backButton = findViewById(R.id.iconback4);
        markButton = findViewById(R.id.iconmark4);
        forwardButton = findViewById(R.id.next4);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        markButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = edtTxt2.getText().toString();
                String repeatPassword = edtTxtRepeat.getText().toString();

                if (isValidPassword(password, repeatPassword)) {
                    showToast("Password saved successfully");
                } else {
                    showInvalidPasswordDialog();
                }
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = edtTxt2.getText().toString();
                String repeatPassword = edtTxtRepeat.getText().toString();

                if (TextUtils.isEmpty(password) || TextUtils.isEmpty(repeatPassword)) {
                    showEmptyPasswordDialog();
                } else if (isValidPassword(password, repeatPassword)) {
                    showToast("Password saved successfully");
                    Intent intent = new Intent(Tampilan_4.this, Tampilan_5.class);
                    startActivity(intent);
                    finish();
                } else {
                    showInvalidPasswordDialog();
                }
            }
        });

        edtTxt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkPasswordStrength(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private boolean isValidPassword(String password, String repeatPassword) {
        return password.length() >= 8 &&
                password.equals(repeatPassword) &&
                containsUppercase(password) &&
                containsLowercase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password) &&
                !hasConsecutiveRepeatedCharacters(password, 3);
    }

    private boolean containsUppercase(String str) {
        return !str.equals(str.toLowerCase());
    }

    private boolean containsLowercase(String str) {
        return !str.equals(str.toUpperCase());
    }

    private boolean containsDigit(String str) {
        return str.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String str) {
        return !str.matches("[a-zA-Z0-9 ]*");
    }

    private boolean hasConsecutiveRepeatedCharacters(String str, int consecutiveCount) {
        for (int i = 0; i < str.length() - consecutiveCount + 1; i++) {
            boolean isRepeated = true;
            for (int j = 0; j < consecutiveCount - 1; j++) {
                if (str.charAt(i + j) != str.charAt(i + j + 1)) {
                    isRepeated = false;
                    break;
                }
            }
            if (isRepeated) {
                return true;
            }
        }
        return false;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showInvalidPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password salah");
        builder.setMessage("Pastikan password memenuhi kriteria dibawah ini:\n" +
                "- Minimum 8 karakter\n" +
                "- Besar dan kecilnya huruf\n" +
                "- Angka\n" +
                "- Gunakan simbol\n");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        builder.show();
    }

    private void showEmptyPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Empty Password");
        builder.setMessage("Password tidak boleh kosong. Silahkan masukkan password.\n"+
                "pastikan kata sandi terdiri dari 8-20 karakter\n"+
                "tanpa karakter yang diulang berurutan sebanyak 3 poin berikut:\n"+
                "- Huruf Kapital\n"+
                "- Huruf Kecil\n"+
                "- Angka\n"+
                "- Simbol");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        builder.show();
    }

    private void checkPasswordStrength(String password) {
        kapital1.setTextColor(containsUppercase(password) ? getResources().getColor(R.color.green) : getResources().getColor(R.color.red));
        kapital2.setTextColor(containsLowercase(password) ? getResources().getColor(R.color.green) : getResources().getColor(R.color.red));
        kapital3.setTextColor(containsDigit(password) ? getResources().getColor(R.color.green) : getResources().getColor(R.color.red));
        kapital4.setTextColor(containsSpecialCharacter(password) ? getResources().getColor(R.color.green) : getResources().getColor(R.color.red));
    }
}

package com.example.myline;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class Tampilan_3 extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int PERMISSION_REQUEST_CAMERA = 3;

    private TextView textView4, text5;
    private ImageButton backButton, markButton;
    private ImageView imageViewProfile;
    private EditText edtTxt1;
    private Button okButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan3);
        getSupportActionBar().hide();

        textView4 = findViewById(R.id.textView4);
        text5 = findViewById(R.id.text5);
        backButton = findViewById(R.id.iconbck);
        markButton = findViewById(R.id.iconmark);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        edtTxt1 = findViewById(R.id.EdtTxt1);
        okButton = findViewById(R.id.btnok3);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        markButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayName = edtTxt1.getText().toString();

                if (isNameValid(displayName)) {
                    showImageSourceDialog();
                } else {
                    showValidationDialog("Harap isi Nama Tampilan");
                }
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayName = edtTxt1.getText().toString();

                if (isNameValid(displayName) && isProfileImageSet()) {
                    Intent intent = new Intent(Tampilan_3.this, Tampilan_4.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                } else {
                    showValidationDialog("Nama Profil Wajib Di isi");
                }
            }
        });

        imageViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageSourceDialog();
            }
        });
    }

    private void showImageSourceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Sumber Gambar");
        builder.setItems(new CharSequence[]{"Galeri", "Kamera"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        openGallery();
                        break;
                    case 1:
                        checkCameraPermissionAndOpenCamera();
                        break;
                }
            }
        });
        builder.show();
    }

    private void checkCameraPermissionAndOpenCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        } else {
            requestCameraPermission();
        }
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
                Uri selectedImageUri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                    imageViewProfile.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    imageViewProfile.setImageBitmap(imageBitmap);
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                showValidationDialog("Izin kamera tidak diberikan");
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showValidationDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Peringatan!!!");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private boolean isNameValid(String name) {
        return !name.isEmpty();
    }

    private boolean isProfileImageSet() {
        return true;
    }
}

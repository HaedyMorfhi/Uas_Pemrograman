package com.example.katalogsmartphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.katalogsmartphone.model.HandPhone;
import com.google.android.material.textfield.TextInputLayout;

public class FormSmartphone extends AppCompatActivity {

    Button btnSimpan;
    TextInputLayout tilSpec, tilMerek;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_smartphone);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> simpanMerek());
        tilSpec = findViewById(R.id.til_speks);
    }

    private void simpanMerek() {
        if (isDataValid()) {
            HandPhone tr = new HandPhone();
            tr.setSpesifikasi(tilSpec.getEditText().getText().toString());
            tr.setSpesifikasi(tilMerek.getEditText().getText().toString());
            SharedPerefernceUtility.addSmartphone(this, tr);
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            // Kembali ke layar sebelumnya setelah 500 ms (0.5 detik)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);

        }
    }

    private boolean isDataValid() {
        if (tilSpec.getEditText().getText().toString().isEmpty()
        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
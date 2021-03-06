package com.example.katalogsmartphone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.katalogsmartphone.model.HandPhone;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnupdate;
    ImageButton btnedit;
    ListView lvdaftar;
    TextView txnodata, txusername;
    DaftarSmartPhoneAdapter adapter;
    List<HandPhone> daftarPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
        loadDataTransaksi();
        setupListview();
    }
    private void inisialisasiView() {
        btnupdate = findViewById(R.id.btntambah);
        btnupdate.setOnClickListener(view -> bukaFormTambahPhone());
        btnedit = findViewById(R.id.btn_change_username);
        btnedit.setOnClickListener(view -> changeUserName());
        lvdaftar = findViewById(R.id.lv_list);
        txnodata = findViewById(R.id.tx_nodata);
        txusername = findViewById(R.id.tx_user_name);
        txusername.setText(SharedPerefernceUtility.getUserName(this));
        txusername = findViewById(R.id.tx_user_name);
    }

    private void setupListview() {
        adapter = new DaftarSmartPhoneAdapter(this, daftarPhone);
        lvdaftar.setAdapter(adapter);

    }

    private void loadDataTransaksi() {
        daftarPhone = SharedPerefernceUtility.getAllSmartphone(this);
        if (daftarPhone.size() > 0) {
            txnodata.setVisibility(View.GONE);
        } else {
            txnodata.setVisibility(View.VISIBLE);
        }

    }

    private void refreshListView() {
        adapter.clear();
        loadDataTransaksi();
        adapter.addAll(daftarPhone);
    }

    private void bukaFormTambahPhone() {
        Intent intent = new Intent(this, FormSmartphone.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

    private void changeUserName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ganti nama");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPerefernceUtility.saveUserName(getApplicationContext(),input.getText().toString());
                Toast.makeText(getApplicationContext(),"Nama user berhasil disimpan",Toast.LENGTH_SHORT).show();
                txusername.setText(SharedPerefernceUtility.getUserName(getApplicationContext()));
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
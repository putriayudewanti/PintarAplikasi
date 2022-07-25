package com.example.pintaraplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainAwal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awal_main);
    }
    public void logo (View view) {
        Intent intent = new Intent(MainAwal.this, Jadwal.class);
        startActivity(intent);
    }
}
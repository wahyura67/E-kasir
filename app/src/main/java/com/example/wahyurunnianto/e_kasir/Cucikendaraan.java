package com.example.wahyurunnianto.e_kasir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Cucikendaraan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cucikendaraan);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Cucikendaraan.class);
        startActivity(intent);

    }
}


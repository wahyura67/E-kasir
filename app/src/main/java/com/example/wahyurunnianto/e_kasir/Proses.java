package com.example.wahyurunnianto.e_kasir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Proses extends AppCompatActivity {
    private EditText edtnamapel,
            edtnopol,
            edtjeniskendaraan,
            edtharga,
            edtuangbayar;
    private Button btnproses;
    private Button btnhasil;
    private Button btnhapus;
    private Button btnexit;
    private TextView txtnamapelanggan;
    private TextView txtnopol;
    private TextView txtjeniskendaraan;
    private TextView txthargs;
    private TextView txtuangbayar;
    private TextView txtTotal;
    private TextView txtBonus;
    private TextView txtuangkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses);

        getSupportActionBar().setTitle("CuciSteam");

        //edittext
        edtnamapel = findViewById(R.id.namapelanggan);
        edtnopol = findViewById(R.id.nopol);
        edtjeniskendaraan = findViewById(R.id.jeniskendaraan);
        edtharga = findViewById(R.id.harga);
        edtuangbayar = findViewById(R.id.uangbayar);
        //button
        btnproses = findViewById(R.id.btnproses);
        btnhasil = findViewById(R.id.tombol1);
        btnhapus = findViewById(R.id.tombol2);
        btnexit = findViewById(R.id.tombol3);
        //text
        txtnamapelanggan = findViewById(R.id.namapelanggan);
        txtnopol = findViewById(R.id.nopol);
        txtjeniskendaraan = findViewById(R.id.jeniskendaraan);
        txthargs = findViewById(R.id.harga);
        txtuangbayar = findViewById(R.id.uangbayar);
        txtTotal = findViewById(R.id.total);
        txtuangkembali = findViewById(R.id.uangkembali);
        txtketerangan = findViewById(R.id.keterangan);
        txtBonus = findViewById(R.id.bonus);

        //actiontombol
        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namapelanggan = edtnamapel.getText().toString().trim();
                String nopol = edtnopol.getText().toString().trim();
                String jeniskendaraan = edtjeniskendaraan.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbayar.getText().toString().trim();

                double np = Double.parseDouble(nopol);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (np * h);
                txtTotal.setText("Total steam : " + total);

                //bonus
                if (total >= 5) {
                    txtBonus.setText("Bonus : Nyuci 1z");
                } else if (total >= 10) {
                    txtBonus.setText("Bonus; Nyuci 2x");
                } else if (total >= 15) {
                    txtBonus.setText("Bonus; Nyuci 5x + Coffee");
                } else {
                    txtBonus.setText("Bonus : Tidak ada ");
                }
                double uangkembalian = (ub - total);

                if (ub < total) {
                    txtketerangan.setText("Keterangan : " +
                            "uang bayar kurang Rp" + (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali :RP 0");
                } else {
                    txtketerangan.setText("keterangan: Tunggu Kembalian");
                    txtuangkembali.setText("Uang kembali : " + uangkembalian);
                }

                //action reset

            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtnamapelanggan.setText(" ");
                txtjeniskendaraan.setText(" ");
                txtnopol.setText(" ");
                txtTotal.setText("Total : Rp 0");
                txthargs.setText(" ");
                txtuangbayar.setText(" ");
                txtuangkembali.setText(" ");
                txtBonus.setText(" ");
                txtketerangan.setText(" ");

                Toast.makeText(getApplicationContext(),
                        "Data sudah direset", Toast.LENGTH_LONG).show();

                //keluar
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                moveTaskToBack(true);
            }
        });
    }
}
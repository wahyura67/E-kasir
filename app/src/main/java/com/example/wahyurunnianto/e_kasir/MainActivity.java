package com.example.wahyurunnianto.e_kasir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private EditText user;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);

        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String namaNya = user.getText().toString();
                String passwordNya = pass.getText().toString();


                if (namaNya.equals("admin") && passwordNya.equals("123")) {
                    Intent next = new Intent(
                            MainActivity.this, Landingpage.
                            class);
                    startActivity(next);
                    finish();
                } else if (namaNya.matches(" ") ||
                        passwordNya.matches("")) {
                    Toast.makeText(getApplication(), "Username atau password " +
                            "tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getApplication(), "Gagal login,username atau password salah", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void Masuk(View view) {
        Intent intent = new Intent(MainActivity.this, Landingpage.class);
        startActivity(intent);

    }
}

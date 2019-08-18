package com.herdis.coursenet.coursenet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ProsessLogin(View view) {
        EditText LogEmail = (EditText) findViewById(R.id.LogEmail);
        EditText LogPassword = (EditText) findViewById(R.id.LogPass);

        /*Email*/
        String email = LogEmail.getText().toString();
        if (email.equals("") )
        {
            LogEmail.setError("Harap isi email anda");
            return;
        }

        /*mengatur format email pada edit text email*/
        if(Patterns.EMAIL_ADDRESS
                .matcher(email).matches() == false)
        {
            Toast.makeText(getApplicationContext(),
                    "Format email salah",
                    Toast.LENGTH_SHORT).show();
            return; //untuk menghentikan
        }


        /*Password*/
        String password = LogPassword.getText().toString();
        if (password.equals("") )
        {
            LogPassword.setError("Harap isi password anda");
            return;
        }

        /*menampilkan pesan : Login berhasil*/
        Toast.makeText(getApplicationContext(),
                "Login Berhasil",
                Toast.LENGTH_SHORT).show();

        /*Direct ke activity home*/
        Intent home = new Intent(getApplicationContext(),
                HomeActivity.class);
        startActivity(home);
        finish();

    }

    /*untuk register*/
    public void AkunBaru(View view) {

        /*Direct ke activity register*/
        Intent daftar = new Intent(getApplicationContext(),
                RegisterActivity.class);
        startActivity(daftar);
    }
}

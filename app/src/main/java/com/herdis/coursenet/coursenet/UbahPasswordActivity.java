package com.herdis.coursenet.coursenet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UbahPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubahpassword);
    }

    public void UbahPassword(View view) {
        EditText sandiNow = (EditText) findViewById(R.id.sandiNow);
        EditText sandiNew = (EditText) findViewById(R.id.sandiNew);
        EditText sandiNew2 = (EditText) findViewById(R.id.sandiNew2);

        /*input passsword sekarang*/
        String pnow = sandiNow.getText().toString();
        if (pnow.equals(""))
        {
            sandiNow.setError("Harap isi password anda");
            return;
        }


        /*input passsword baru*/
        String pnew = sandiNew.getText().toString();
        if (pnew.equals(""))
        {
            sandiNew.setError("Harap isi password baru anda");
            return;
        }
        if (pnew.length() < 3) //memasukan password minimal karakter
        {
            sandiNew.setError("Harap isi password minimal 3 karakter");
            return; //untuk menghentikan
        }


        /*input ulangi passsword baru*/
        String pnew2 = sandiNew2.getText().toString();
        if (pnew2.equals(""))
        {
            sandiNew2.setError("Harap ulangi password baru anda");
            return;
        }
        if (pnew2.length() < 3) //memasukan password minimal karakter
        {
            sandiNew2.setError("Harap isi password minimal 3 karakter");
            return; //untuk menghentikan
        }

        /*menampilkan pesan : Ubah password berhasil*/
        Toast.makeText(getApplicationContext(),
                "Password berhasil di ubah",
                Toast.LENGTH_SHORT).show();

        /*Direct ke activity home jika berhasil*/
        Intent home = new Intent(getApplicationContext(),
                HomeActivity.class);
        startActivity(home);
        finish();
    }
}

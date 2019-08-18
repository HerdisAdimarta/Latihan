package com.herdis.coursenet.coursenet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void showMessage(View view) {

        EditText inputEmail = (EditText) findViewById(R.id.inputEmail);
        EditText inputPassword = (EditText) findViewById(R.id.inputPass);
        EditText inputNama = (EditText) findViewById(R.id.inputNama);
        EditText inputTlp = (EditText) findViewById(R.id.inputTlp);

        Spinner Kota = (Spinner) findViewById(R.id.pilihKota);


        /*menampilkan pemberitahuan jika inputan kosong*/

        /*Email*/
        String email = inputEmail.getText().toString();
        if (email.length() == 0) //cara menggunakan toast, muncul notifikasi tulisan
        {
            Toast.makeText(getApplicationContext(),
                    "Harap isi email",
                    Toast.LENGTH_SHORT).show();
            return; //untuk menghentikan
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
        String password = inputPassword.getText().toString();
        if (password.equals("")) //cara menggunakan setError, muncul gambar notifikasi
        {
            inputPassword.setError("Harap isi password");
            return; //untuk menghentikan
        }
        if (password.length() < 3) //memasukan password minimal karakter
        {
            inputPassword.setError("Harap isi password minimal 3 karakter");
            return; //untuk menghentikan
        }

        /*Nama*/
        String nama = inputNama.getText().toString();
        if (nama.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Harap isi nama",
                    Toast.LENGTH_SHORT).show();
            return; //untuk menghentikan
        }

        /*Telepon*/
        String telepon = inputTlp.getText().toString();
        if (telepon.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Harap isi telepon",
                    Toast.LENGTH_SHORT).show();
            return; //untuk menghentikan
        }


        /*menampilkan pesan : Register berhasil*/
        Toast.makeText(getApplicationContext(),
                "Register Berhasil",
                Toast.LENGTH_SHORT).show();

        /*Direct ke activity lain*/
        Intent login = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(login);
    }

    /*untuk membuka kamera pada aplikasi*/
    public void openCamera(View view) {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(camera, 1234);
    }

    /*untuk membuka phone book pada aplikasi*/
    public void openphonebook(View view) {
        Intent phonebook = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(phonebook, 8888);
    }

    /*mengambil hasil perintah*/
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234)
        {
            if (resultCode == RESULT_OK)
            {
                ImageView img1 = (ImageView) findViewById(R.id.img1);

                Bitmap gambar = (Bitmap)data.getExtras().get("data");
                img1.setImageBitmap(gambar);

            }
        }
        else if(requestCode == 8888)
        {

        }
    }
}

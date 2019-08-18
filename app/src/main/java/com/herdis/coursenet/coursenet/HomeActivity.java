package com.herdis.coursenet.coursenet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /*membuat tampilan option menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*membuat memfungsikan option menu aagar bisa di klik */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /*menu home*/
        if (item.getItemId() == R.id.menuHome) {


        }


        /*menu about*/
        else if (item.getItemId() == R.id.menuAbout) {
            // toast : Program Created By Herdies Adimarta
            Toast.makeText(getApplicationContext(),
                    "Program Created By Herdies Adimarta",
                    Toast.LENGTH_SHORT).show();
        }


        /*menu logout*/
        else if (item.getItemId() == R.id.menuLogout) {
            // pindah ke halaman login
            Intent menuLogin = new Intent(getApplicationContext(),
                    MainActivity.class);
            startActivity(menuLogin);
            finish();
        }


        /*menu change password*/
        else if (item.getItemId() == R.id.menuPassword) {
            // pindah ke halaman change password
            Intent menuPassword = new Intent(getApplicationContext(),
                    UbahPasswordActivity.class);
            startActivity(menuPassword);
            finish();
        }


        /*menu exit*/
        else if (item.getItemId() == R.id.menuExit) {
            /*finishAffinity(); //langsung keluar*/

            /*menggunakan dialog iya atau tidak*/
            AlertDialog.Builder
                    ab =
                    new AlertDialog.Builder(
                            HomeActivity.this);
            ab.setMessage("Tutup aplikasi ?");
            ab.setTitle("Konfirmasi");
            ab.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });
            ab.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });
            ab.show();
        }
        return super.onOptionsItemSelected(item);
    }

    /*mengunci tombol back*/
    @Override
    public void onBackPressed() {

    }
}

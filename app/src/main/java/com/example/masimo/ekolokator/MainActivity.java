package com.example.masimo.ekolokator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button prijava = (Button) findViewById(R.id.prijava);
        prijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prijava();
            }
        });

    }

    public void prijava(){
        Intent intent = new Intent(this, PrijavaActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.oapp:
                Toast toast = Toast.makeText(this, "Aktivnost koja prikazuje tko je izašto napravio aplikaciju", Toast.LENGTH_SHORT);
                toast.show();
                return true;

            case R.id.upute:
                Toast tost = Toast.makeText(this, "Aktivnost koja prikazuje na upute o korištenju aplikacije", Toast.LENGTH_SHORT);
                tost.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

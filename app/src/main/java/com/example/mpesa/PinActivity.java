package com.example.mpesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PinActivity extends AppCompatActivity {
EditText pinno;
Button can4,ok4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        pinno = findViewById(R.id.pin);
        ok4 = findViewById(R.id.forward3);
        can4 = findViewById(R.id.back3);
        ok4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pinno.getText().toString().isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PinActivity.this);
                    builder.setMessage("Waiting for transaction...");
                    builder.setTitle("MPESA");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(PinActivity.this, MainActivity.class));
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please insert pin",Toast.LENGTH_SHORT).show();
                }
            }


        });
        can4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PinActivity.this,MainActivity.class));
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                startActivity(new Intent(PinActivity.this,MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
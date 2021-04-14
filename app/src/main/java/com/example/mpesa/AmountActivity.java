package com.example.mpesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AmountActivity extends AppCompatActivity {
EditText amount;
Button can3,ok3;
String b = "1000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        amount = findViewById(R.id.amo);
        can3 = findViewById(R.id.back2);
        ok3 = findViewById(R.id.forward2);
        ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amo = amount.getText().toString().trim();
                if (!amount.getText().toString().isEmpty()) {
                    if (b.equals(amo)) {
                        startActivity(new Intent(AmountActivity.this, PinActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Amount is less than 1,000", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter amount",Toast.LENGTH_SHORT).show();
                }
            }
        });
        can3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AmountActivity.this,MainActivity.class));
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                startActivity(new Intent(AmountActivity.this,MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
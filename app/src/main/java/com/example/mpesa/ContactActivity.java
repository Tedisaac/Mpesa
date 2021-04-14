package com.example.mpesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
EditText phonenum;
Button can2,ok2;
String n = "0797877878";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        phonenum = findViewById(R.id.num);
        ok2 = findViewById(R.id.forward);
        can2 = findViewById(R.id.back);
        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phonenum.getText().toString().trim();
                if (!phonenum.getText().toString().isEmpty()) {
                    if (n.equals(number)) {
                        startActivity(new Intent(ContactActivity.this, AmountActivity.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Numbers do not match", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please insert phone number",Toast.LENGTH_SHORT).show();
                }
            }
        });
        can2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactActivity.this, PhoneActivity.class));
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
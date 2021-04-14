package com.example.mpesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    String[] options = {"Send Money","Withdraw Cash","But Airtime","Loans and Savings","Lipa na M-PESA","My Account"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_listview,options);
        listView = findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(MainActivity.this,PhoneActivity.class));
                }
                if (position == 1){
                    Toast.makeText(getApplicationContext(),"You have clicked Withdraw cash option",Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(getApplicationContext(),"You have clicked Buy Airtime cash option",Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(getApplicationContext(),"You have clicked Loans and Savings cash option",Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(getApplicationContext(),"You have clicked Lipa na M-PESA cash option",Toast.LENGTH_SHORT).show();
                }
                if (position == 5){
                    Toast.makeText(getApplicationContext(),"You have clicked My Account cash option",Toast.LENGTH_SHORT).show();
                }
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
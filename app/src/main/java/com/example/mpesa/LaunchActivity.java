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

public class LaunchActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    String[] options = {"Safaricom+","M-PESA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,options);
        listView = findViewById(R.id.list2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(getApplicationContext(),"You have clicked Safaricom+ option",Toast.LENGTH_SHORT).show();

                }
                if (position == 1){
                    startActivity(new Intent(LaunchActivity.this,MainActivity.class));

                }
            }
        });
    }

}
package com.example.jaspreetsingh.selectlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list_view);

        ArrayList <String> names = new ArrayList<>();
        names.add("Mike");
        names.add("John");
        names.add("Christopher");
        names.add("Bradly");
        names.add("Chase");

        ListView namesListView = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        namesListView.setAdapter(adapter);

    }



}

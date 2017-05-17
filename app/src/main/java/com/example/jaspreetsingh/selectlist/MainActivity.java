package com.example.jaspreetsingh.selectlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.name;
import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Names> nameList ;
    NameAdapter nameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);
        displayViewList();
    }

    public void displayViewList() {

        nameList = new ArrayList<Names>();
        nameList.add(new Names("Mike","Warner",false));
        nameList.add(new Names("Chris","Evans",false));
        nameList.add(new Names("Robert","Dowery",false));
        nameList.add(new Names("Jon","Jones",false));
        nameList.add(new Names("Tom","Bradsy",false));

        nameAdapter = new NameAdapter(nameList, this);

        listView.setAdapter(nameAdapter);
    }

    public void onCheckChanged(CompoundButton buttonView, boolean isChecked){
        int pos = listView.getPositionForView(buttonView);
        if(pos != ListView.INVALID_POSITION)    {
            Names n = nameList.get(pos);
            n.setSelected(isChecked);

            Toast.makeText(this, "Name: "+n.getFirstName()+"State is; "
                            + isChecked, Toast.LENGTH_LONG).show();
        }
    }
}

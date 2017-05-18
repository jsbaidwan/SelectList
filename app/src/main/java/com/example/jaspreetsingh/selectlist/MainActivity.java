package com.example.jaspreetsingh.selectlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.name;
import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener {

    ListView listView;
    ArrayList<Names> nameList ;
    NameAdapter nameAdapter;
    String name = "";

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
        nameList.add(new Names("Tom","Brady",false));

        nameAdapter = new NameAdapter(nameList, this);

        listView.setAdapter(nameAdapter);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = listView.getPositionForView(buttonView);
        if(pos != ListView.INVALID_POSITION)    {
            Names n = nameList.get(pos);
            n.setSelected(isChecked);

            name = n.getFirstName();

           // displayText(name);
//            Toast.makeText(this, "Name: "+n.getFirstName()+"State is; "
//                            + isChecked, Toast.LENGTH_LONG).show();
        }
    }

public void button  (View view)   {

    displayText(name);
}

    public void displayText(String result) {
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText(result);
    }

}

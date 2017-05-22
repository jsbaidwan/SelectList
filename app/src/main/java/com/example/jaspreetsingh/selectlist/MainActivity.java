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
    ArrayList<Names> nameList;
    NameAdapter nameAdapter;
    String firstName;
    String lastName;
    boolean selection;
    ArrayList<String> summary = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);
        displayViewList();
    }

    public void displayViewList() {

        nameList = new ArrayList<Names>();
        nameList.add(new Names("Mike", "Warner", false));
        nameList.add(new Names("Chris", "Evans", false));
        nameList.add(new Names("Jon", "Jones", false));
        nameList.add(new Names("Tom", "Brady", false));

        nameAdapter = new NameAdapter(nameList, this);

        listView.setAdapter(nameAdapter);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = listView.getPositionForView(buttonView);
        if (pos != ListView.INVALID_POSITION) {
            Names n = nameList.get(pos);
            n.setSelected(isChecked);

            selection = isChecked;
            firstName = n.getFirstName();
            lastName = n.getLastName();
            String fullName = firstName + lastName;

            if (selection) {
                summary.add(fullName);
            }
            if (!selection) {
                summary.remove(fullName);
            }
        }
    }


    public void button(View view) {
        displayText(summary);
    }

    public void displayText(ArrayList<String> result) {
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText(result.toString());
    }
}

package com.example.jaspreetsingh.selectlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.name;
import static android.R.attr.resource;

/**
 * Created by jaspreet.singh on 17-05-2017.
 */

/**
 * {@link NameAdapter} is an {@link Names} that can provide the layout for each list
 * based on a data source, which is a list of {@linkNames} objects.
 */

public class NameAdapter extends ArrayAdapter<Names> {

    private List<Names> namesList;
    private Context context;


    /**
     * This is our own custom constructor
     * the context is used to inflate the layout file, and the list is the data we want to
     * popluate into the lists.
     *
     */
    public NameAdapter(List<Names> namesList, Context context) {
        super(context, R.layout.list_view, namesList);
        this.context = context;
        this.namesList = namesList;
    }

    private static class NameHolder {
        public TextView firstName;
        public TextView lastName;
        public CheckBox checkBox;
    }

    /**
     * Provides a view for an AdapterView
     */
    @Override
    public View getView (int position, View convertView, ViewGroup parent)   {

        View v = convertView;
        NameHolder holder = new NameHolder();
        if(convertView == null)   {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             v = inflater.inflate(R.layout.list_view, null);

            holder.firstName = (TextView) v.findViewById(R.id.first_name);
            holder.lastName = (TextView) v.findViewById(R.id.last_name);
            holder.checkBox = (CheckBox) v.findViewById(R.id.check_box);

           holder.checkBox.setOnCheckedChangeListener((MainActivity) context);
        }
        else    {
            holder = (NameHolder) v.getTag();
        }
        Names p = namesList.get(position);
        holder.firstName.setText(p.getFirstName());
        holder.lastName.setText( p.getLastName());
        holder.checkBox.setChecked(p.isSelected());
        holder.checkBox.setTag(p);

    return v ;
    }
}

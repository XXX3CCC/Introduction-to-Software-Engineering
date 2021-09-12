package com.example.gearapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddGear extends AppCompatActivity implements GearList {

    ListView gearList;
    ArrayAdapter<String> gearAdapter;
    ArrayList<String> dataList;
    TextView t_price;
    float total_price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gear);

        gearList = (ListView) findViewById(R.id.gear_list);
        t_price = (TextView) findViewById(R.id.t_price);

        dataList = new ArrayList<>();
        ArrayList<String> items = new ArrayList<>();

        //add data
        for(int j = 0; j < Gears.size(); j++) {
            String Info = Gears.get(j).getData(); //get information from gearlist
            items.add(Info);
            total_price += Gears.get(j).getPrice();
        }

        dataList.addAll(items);  //add all information of a gear
        gearAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);

        gearList.setAdapter(gearAdapter);
        gearList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                delete_gear(i);
                edit_gear(i);
            }
        });

        //show the total price
        t_price.setText("Total price: " + total_price + " Canadian dollars\n ---------------------------------------------------------");

    }

    //click delete button
    public void delete_gear(final int p){
        Button delButton = (Button) findViewById(R.id.delete);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gears.remove(p);
                Intent intent = new Intent(AddGear.this, AddGear.class);
                startActivity(intent); //restart activity
                finish();
            }
        });

    }

    //click edit button
    public void edit_gear(final int p){
        Button editButton = (Button) findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Position.add(p);
                Intent intent = new Intent(AddGear.this, EditGear.class);
                startActivity(intent); //restart activity
                finish();
            }
        });
    }


}
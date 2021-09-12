package com.example.gearapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements GearList{

    EditText gear_date, gear_maker, gear_descr, gear_price, gear_comment;
    Button add, list;
    TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.add_info);
        list = (Button) findViewById(R.id.show_gear);
        gear_date = (EditText) findViewById(R.id.new_date);
        gear_maker = (EditText) findViewById(R.id.new_maker);
        gear_descr = (EditText) findViewById(R.id.new_descr);
        gear_price = (EditText) findViewById(R.id.new_price);
        gear_comment = (EditText) findViewById(R.id.new_comment);
        input = (TextView) findViewById(R.id.input);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addList(view);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddGear.class);
                startActivity(i);
            }
        });
    }

    public void addList(View view) {

        //get data of EditText
        String i1 = gear_date.getText().toString().trim();
        String i2 = gear_maker.getText().toString().trim();
        String i3 = gear_descr.getText().toString().trim();
        String i4 = gear_price.getText().toString().trim();
        String i5 = gear_comment.getText().toString().trim();

        //Determine whether the format of input is correct
        if (i1.matches("") || !i1.matches("\\d{4}-\\d{2}-\\d{2}")){
            input.setText("wrong date format! ");
        }
        else if (i2.length() <= 0 || i2.length() > 20) {
            input.setText("wrong maker format! ");
        }
        else if (i3.length() <=0 || i3.length() > 40) {
            input.setText("wrong description format! ");
        }
        else if (i4.length() <=0 || isNum(i4) == false) {
            input.setText("wrong price format! ");
        }
        else if (i5.length() > 20) {
            input.setText("wrong comment format! ");
        }
        else{
            GearInfo i = new GearInfo(i1, i2, i3, i4, i5);
            Gears.add(i);
            input.setText("Success! ");
        }

    }

    //Determine whether the string is a floating point number
    public boolean isNum(String str){
        try {
            Double.parseDouble(str);
            if (str.contains("."))
                return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
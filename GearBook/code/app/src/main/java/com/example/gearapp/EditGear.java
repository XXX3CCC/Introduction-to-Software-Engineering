package com.example.gearapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EditGear extends AppCompatActivity implements GearList{

    EditText ed_date, ed_maker, ed_descr, ed_price, ed_comment;
    Button edit;
    TextView input;
    int p = Position.get(Position.size() - 1); //get the position of the gear

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gear);

        ed_date = (EditText) findViewById(R.id.new_date);
        ed_maker = (EditText) findViewById(R.id.new_maker);
        ed_descr = (EditText) findViewById(R.id.new_descr);
        ed_price = (EditText) findViewById(R.id.new_price);
        ed_comment = (EditText) findViewById(R.id.new_comment);
        edit = (Button) findViewById(R.id.confirm);
        input = (TextView) findViewById(R.id.input);

        //get the original gear
        ed_date.setText(Gears.get(p).date+"");
        ed_maker.setText(Gears.get(p).maker);
        ed_descr.setText(Gears.get(p).descr);
        ed_price.setText(Gears.get(p).price+"");
        ed_comment.setText(Gears.get(p).comment);

        //click confirm button
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (format() == true) {
                    edit_gear();
                    Intent intent = new Intent(EditGear.this, AddGear.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void edit_gear(){

        //get data of EditText
        String e1 = ed_date.getText().toString().trim();
        String e2 = ed_maker.getText().toString().trim();
        String e3 = ed_descr.getText().toString().trim();
        String e4 = ed_price.getText().toString().trim();
        String e5 = ed_comment.getText().toString().trim();

        //get the edited data
        Gears.get(p).setDate(e1);
        Gears.get(p).setMaker(e2);
        Gears.get(p).setDescr(e3);
        Gears.get(p).setPrice(Float.parseFloat(e4));
        Gears.get(p).setComment(e5);
    }

    //Determine whether the format of input is correct
    public boolean format(){
        String e1 = ed_date.getText().toString().trim();
        String e2 = ed_maker.getText().toString().trim();
        String e3 = ed_descr.getText().toString().trim();
        String e4 = ed_price.getText().toString().trim();
        String e5 = ed_comment.getText().toString().trim();

        if (e1.matches("") || !e1.matches("\\d{4}-\\d{2}-\\d{2}")){
            input.setText("wrong date format! ");
            return false;
        }
        else if (e2.length() <= 0 || e2.length() > 20) {
            input.setText("wrong maker format! ");
            return false;
        }
        else if (e3.length() <=0 || e3.length() > 40) {
            input.setText("wrong description format! ");
            return false;
        }
        else if (e4.length() <=0 || isNum(e4) == false) {
            input.setText("wrong price format! ");
            return false;
        }
        else if (e5.length() > 20) {
            input.setText("wrong comment format! ");
            return false;
        }
        else {
            return true;
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
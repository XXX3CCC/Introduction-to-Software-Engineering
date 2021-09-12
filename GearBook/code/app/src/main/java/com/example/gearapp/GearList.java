package com.example.gearapp;

import android.icu.text.Transliterator;

import java.util.ArrayList;

public interface GearList {
    ArrayList<GearInfo> Gears = new ArrayList<>(); //get an array to save every gear and its information
    ArrayList<Integer> Position = new ArrayList<>(); //get an array to save the position of the gear
}

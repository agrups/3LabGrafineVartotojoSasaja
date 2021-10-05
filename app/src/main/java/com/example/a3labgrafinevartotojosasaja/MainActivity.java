package com.example.a3labgrafinevartotojosasaja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView faculty;
    RatingBar rating;
    Spinner day;
    TimePicker time;
    Switch register;

    private static final String[] FACULTIES = new String[] {
            "Antano Gustaičio aviacijos institutas", "Aplinkos inžinerijos fakultetas", "Architektūros fakultetas", "Elektronikos fakultetas",
            "Fundamentinių mokslų fakultetas", "Kūrybinių industrijų fakultetas", "Mechanikos fakultetas", "Statybos fakultetas",
            "Transporto inžinerijos fakultetas", "Verslo vadybos fakultetas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faculty = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> facultyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, FACULTIES);
        faculty.setThreshold(1);
        faculty.setAdapter(facultyAdapter);

//        day = (Spinner)findViewById(R.id.spinner2);
//        day.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.days_of_week, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        day.setAdapter(adapter);
    }
}
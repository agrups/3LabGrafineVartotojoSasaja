 package com.example.a3labgrafinevartotojosasaja;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name;
    AutoCompleteTextView faculty;
    RatingBar rating;
    Spinner day;
    TimePicker time;
    Switch register;
    Button save;
    String text;
    String daySelected;

    private static final String[] FACULTIES = new String[] {
            "Antano Gustaičio aviacijos institutas", "Aplinkos inžinerijos fakultetas", "Architektūros fakultetas", "Elektronikos fakultetas",
            "Fundamentinių mokslų fakultetas", "Kūrybinių industrijų fakultetas", "Mechanikos fakultetas", "Statybos fakultetas",
            "Transporto inžinerijos fakultetas", "Verslo vadybos fakultetas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.pavadinimasText);

        faculty = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> facultyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, FACULTIES);
        faculty.setThreshold(1);
        faculty.setAdapter(facultyAdapter);

        rating = (RatingBar) findViewById(R.id.ratingBar);

        day = (Spinner)findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.days_of_week, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter);
        day.setOnItemSelectedListener(this);

        time = (TimePicker) findViewById(R.id.timePicker);

        register = (Switch) findViewById(R.id.switch1);

        save = (Button) findViewById(R.id.saugotiButton);

        save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String registered = "Ne";
                if(register.isChecked()){
                    registered = "Taip";
                }

                text = "Pavadinimas: " + name.getText().toString() + "\n" +
                        "Fakultetas: " + faculty.getText().toString() + "\n" +
                        "Sedėtingumas: " + rating.getRating() + "\n" +
                        "Diena: " + daySelected + "\n" +
                        "Laikas: " + time.getCurrentHour().toString() + "h " + time.getCurrentMinute().toString() + "min" + "\n" +
                        "Registruotis: " + registered ;
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }

     @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         daySelected = parent.getItemAtPosition(position).toString();
     }

     @Override
     public void onNothingSelected(AdapterView<?> parent) {

     }
 }
/**
 * @author Linda Nguyen
 */


package com.example.facemaker_lindanguyen;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    // array of strings in the spinner
    String[] hairStyles = {"Bowl", "Bald", "Mop"};
    private Spinner hairSpin;
    private Face facey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        // code to populate spinner taken from class lectures
        hairSpin = findViewById(R.id.hairSpinner);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, this.hairStyles);
        hairSpin.setAdapter(hairAdapter);

        //facey = findViewById(R.id.faceView);


    }
}
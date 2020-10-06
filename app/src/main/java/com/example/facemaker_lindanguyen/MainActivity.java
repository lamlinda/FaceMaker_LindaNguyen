/**
 * @author Linda Nguyen
 */


package com.example.facemaker_lindanguyen;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // array of strings in the spinner
    String[] hairStyles = {"Bowl", "Rectangle", "tassels"};
    private Spinner hairSpin;
    private SeekBar redValue;
    private SeekBar greenValue;
    private SeekBar blueValue;

    private RadioButton hairButton;
    private RadioButton skinButton;
    private RadioButton eyesButton;
    FaceView faceV = null;
    private ListenerClass listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //I don't understand why but, when i name the face class just "Face" it gives me an error
        this.faceV = findViewById(R.id.view);
        listener = new ListenerClass(this.faceV);

        // code to populate spinner taken from class lectures
        hairSpin = findViewById(R.id.hairSpinner);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, this.hairStyles);
        hairSpin.setAdapter(hairAdapter);
        hairSpin.setOnItemSelectedListener(this);




        redValue = findViewById(R.id.redSeekBar);
        redValue.setOnSeekBarChangeListener(listener);

        greenValue = findViewById(R.id.greenSeekBar);
       greenValue.setOnSeekBarChangeListener(listener);

        blueValue = findViewById(R.id.blueSeekBar);
        blueValue.setOnSeekBarChangeListener(listener);

        hairButton = findViewById(R.id.hairRadio);
        hairButton.setOnClickListener(listener);

        skinButton = findViewById(R.id.skinRadio);
        skinButton.setOnClickListener(listener);

        eyesButton = findViewById(R.id.eyesRadio);
        eyesButton.setOnClickListener(listener);

        listener = new ListenerClass(faceV);
        this.faceV = findViewById(R.id.view);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        faceV.setHairStyle(position);
        faceV.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
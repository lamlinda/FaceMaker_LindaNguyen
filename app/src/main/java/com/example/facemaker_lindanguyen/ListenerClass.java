package com.example.facemaker_lindanguyen;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class ListenerClass implements SeekBar.OnSeekBarChangeListener, RadioButton.OnClickListener {
    private SeekBar redValue = null;
    private SeekBar greenValue = null;
    private SeekBar blueValue = null;

    private RadioButton hairButton;
    private RadioButton skinButton;
    private RadioButton eyesButton;

    private int red = 0;
    private int green = 0;
    private int blue = 0;

    private FaceView fv;


    public ListenerClass(FaceView faceV){
        fv = faceV;
//        this.redValue = red;
//        this.greenValue = green;
//        this.blueValue = blue;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
        Log.d("Fs", "value was changed");

        if(seekBar.getId() == R.id.redSeekBar){
            red = progress;


        }
        else if(seekBar.getId() == R.id.greenSeekBar){
            green = progress;

        }
        else if(seekBar.getId() == R.id.blueSeekBar){
            blue = progress;

        }

        int rgb = Color.rgb(red, green, blue);

        if(this.skinButton.isChecked()){
            fv.skinC = rgb;
        }
        else if(this.hairButton.isChecked()){
            fv.hairC = rgb;
        }
        else if(this.eyesButton.isChecked()){
            fv.eyeC = rgb;
        }

//         fv.hairRed = redValue.getProgress();
//         Log.d("Changed", "progress changed");
//         fv.hairGreen = greenValue.getProgress();
//         fv.hairBlue = blueValue.getProgress();
         fv.invalidate();


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {

    }
}

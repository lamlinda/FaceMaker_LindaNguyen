/**
 * @author Linda Nguyen
 */


package com.example.facemaker_lindanguyen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.Random;

import static android.graphics.Color.red;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, RadioButton.OnClickListener{

    // array of strings in the spinner
    String[] hairStyles = {"Bowl", "Rectangle", "Tassel"};
    private Spinner hairSpin;
    private SeekBar redValue;
    private SeekBar greenValue;
    private SeekBar blueValue;

    private RadioButton hairButton;
    private RadioButton skinButton;
    private RadioButton eyesButton;

    private Button randomButton;

    FaceView faceV = null;

    private int red = 0;
    private int green = 0;
    private int blue = 0;

    private FaceView fv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //I don't understand why but, when i name the face class just "Face" it gives me an error that there are incompatible upper bounds View and Face
        //so I changed the class name to FaceView and it fixed it somehow
        this.faceV = findViewById(R.id.view);

        /**
         * External Citation
         * Date: October 3rd, 2020
         * Problem: need to populate spinner and have buttons, spinner, seekbars, and radio button respond to events
         *
         * Resource: class lecture and example code from lecture
         *
         * Solution: use .setOnSeekBarChangeListener or the activity's corresponding methods to the objects. Also used example code from class
         * as a reference to populate the spinner
         *
         */
        hairSpin = findViewById(R.id.hairSpinner);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, this.hairStyles);
        hairSpin.setAdapter(hairAdapter);
        hairSpin.setOnItemSelectedListener(this);

        redValue = findViewById(R.id.redSeekBar);
        redValue.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) this);

        greenValue = findViewById(R.id.greenSeekBar);
       greenValue.setOnSeekBarChangeListener(this);

        blueValue = findViewById(R.id.blueSeekBar);
        blueValue.setOnSeekBarChangeListener(this);

        hairButton = findViewById(R.id.hairRadio);
        hairButton.setOnClickListener(this);

        skinButton = findViewById(R.id.skinRadio);
        skinButton.setOnClickListener(this);

        eyesButton = findViewById(R.id.eyesRadio);
        eyesButton.setOnClickListener(this);

        randomButton = findViewById(R.id.randoButton);
        randomButton.setOnClickListener(this);



        this.faceV = findViewById(R.id.view);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /**External Citation
         * Date: October 3rd, 2020
         * Problem: didn't know how to get the value selected on a spinner
         *
         * Resource: https://stackoverflow.com/questions/1947933/how-to-get-spinner-value
         *
         * Solution: used the .getSelectedItem() and .toString() method to check which hairstyle is selected
         */
        String selected = hairSpin.getSelectedItem().toString();
        faceV.setHairStyle(selected);
        faceV.invalidate();
    }

    //this method needs to exist to use the spinner but currently does not do anything
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        /**
         * External Citation
         * Date: October 3rd, 2020
         * Problem: Don't know how to set each rgb seekbar to their appropriate values
         *
         * Resource: http://android-er.blogspot.com/2009/08/change-background-color-by-seekbar.html
         *
         * Solution: use seekBar.getProgress method and set the values to an int variable
         */
        red = redValue.getProgress();
        green = greenValue.getProgress();
        blue = blueValue.getProgress();

        /**
         * External Citation
         * Date: October 3rd, 2020
         * Problem: Didn't know how to check if a radio button in a radio group has been pressed
         *
         * Resource: https://stackoverflow.com/questions/24992936/how-to-check-if-a-radiobutton-is-checked-in-a-radiogroup-in-android
         *
         * Solution: used the .isChecked() method to see if a button is checked
         */
        if(this.skinButton.isChecked()){
            faceV.setSkinColor(red, green, blue);
        }
        else if(this.hairButton.isChecked()){
            faceV.setHairColor(red, green, blue);
        }
        else if(this.eyesButton.isChecked()){
            faceV.setEyeColor(red, green, blue);
        }
        faceV.invalidate();
    }

    //these methods need to exist in order to use seekBar but they don't do anything
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onClick(View v) {

        // get random ints to set each property of the face to a random value
        if(v.getId() == R.id.randoButton){
            Random rand = new Random();

            faceV.setEyeColor(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            faceV.setHairColor(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            faceV.setSkinColor(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));

            /**
             * External Citation
             * Date October 5, 2020
             * Problem: Need to get a random string from the array of hairstyles and also update the spinner so it
             * reflects that actual hairstyle that is drawn
             *
             * Resource: https://stackoverflow.com/questions/6726963/random-string-from-string-array-list for random string
             * https://www.thetopsites.net/article/52303054.shtml#:~:text=Show%20default%20value%20in%20Spinner,value%20from%20the%20dropdown%20menu.&text=spinner.,setAdapter(yourAdapter)%3B%20spinner. to find how
             * to set what is on the spinner
             *
             * Solution: set the hairstyle by passing a random number in for index in the array of hairstyles and using spinner.setSelection(position) to change the spinner
             * to properly reflect what is drawn
             */
            faceV.setHairStyle(hairStyles[rand.nextInt(3)]);
            if(faceV.getHairStyle() == "Bowl"){
                hairSpin.setSelection(0);
            }
            else if(faceV.getHairStyle() == "Rectangle"){
                hairSpin.setSelection(1);
            }
            else if(faceV.getHairStyle() == "Tassel"){
                hairSpin.setSelection(2);
            }
            faceV.invalidate();
        }


        // get the rgb color value of skin, hair, and eyes in order to set the seekbars to those corresponding values
        int tempHair = faceV.getHairColor();
        int tempSkin = faceV.getSkinColor();
        int tempEyes = faceV.getEyeColor();


        /**
         * External Citation:
         * Date: October 3rd, 2020
         * Problem: needed to find out how to extract individual red, green, and blue values from a color int
         *
         * Resources: https://developer.android.com/reference/android/graphics/Color.html
         *
         * Solution: referenced the android api and used the built in Color.red/green/blue() method to pull the color components from a color int
         *
         */
        if(this.skinButton.isChecked()){
            redValue.setProgress(Color.red(tempSkin));
            greenValue.setProgress(Color.green(tempSkin));
            blueValue.setProgress(Color.blue(tempSkin));
        }
        else if(hairButton.isChecked()){
            redValue.setProgress(Color.red(tempHair));
            greenValue.setProgress(Color.green(tempHair));
            blueValue.setProgress(Color.blue(tempHair));
        }
        else if(eyesButton.isChecked()){
            redValue.setProgress(Color.red(tempEyes));
            greenValue.setProgress(Color.green(tempEyes));
            blueValue.setProgress(Color.blue(tempEyes));
        }
        faceV.invalidate();
    }
}
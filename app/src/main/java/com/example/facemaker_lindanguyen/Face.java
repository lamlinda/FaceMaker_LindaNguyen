
/**
 * @author Linda Nguyen
 */

package com.example.facemaker_lindanguyen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView {
    // instance variables for color and style of face
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;


    Paint skin = new Paint();


    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        skin.setColor(0xFFC755B5);

    }

    public void randomize(){

        /**
         * Date: September 7, 2020
         * reference for choosing random ints found here: https://stackoverflow.com/questions/20560899/generate-a-random-color-java
         * */
        Random rand = new Random();

        skinColor = rand.nextInt(255);
        eyeColor = rand.nextInt(255);
        hairColor = rand.nextInt(255);
        hairStyle = rand.nextInt(255);
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawCircle(0, 0, 250, skin);
}
}

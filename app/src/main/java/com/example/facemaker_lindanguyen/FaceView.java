package com.example.facemaker_lindanguyen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class FaceView extends SurfaceView {
    private int skinColor;
    private int eyeColor;
    private int hairColor;

    private int hairRed;
    private int hairGreen;
    private int hairBlue;

    private int skinRed;
    private int skinGreen;
    private int skinBlue;

    public int eyeRed;
    public int eyeGreen;
    public int eyeBlue;

    private String hairStyle;

    //knowledge on paints taken from class lectures. Didn't know if I needed to cite that
    Paint skinC = new Paint();
    Paint eyeC = new Paint();
    Paint hairC = new Paint();
    Paint black = new Paint(Color.BLACK);


    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        randomize();


        hairC.setStrokeWidth(8.0f);
        setBackgroundColor(Color.WHITE);

        /**
         * External Citation
         * Date: October 3rd, 2020
         * Problem: Don't know how to turn three rgb ints into a single color int
         *
         * Resource: https://developer.android.com/reference/android/graphics/Color#rgb(int,%20int,%20int)
         *
         * Solution: Used the Color.rgb() method to pass in individual rgb values and make a single color int
         */
        skinColor = Color.rgb(skinRed, skinGreen, skinBlue);
        hairColor = Color.rgb(hairRed, hairGreen, hairBlue);
        eyeColor = Color.rgb(eyeRed, eyeGreen, eyeBlue);

    }

    public int getHairColor(){
        return hairColor;
    }

    public int getSkinColor(){
        return skinColor;
    }

    public int getEyeColor(){
        return eyeColor;
    }

    public void setHairColor(int red, int green, int blue){
        hairColor = Color.rgb(red, green, blue);
    }

    public void setSkinColor(int red, int green, int blue){
        skinColor = Color.rgb(red, green, blue);
    }

    public void setEyeColor(int red, int green, int blue){
        eyeColor = Color.rgb(red, green, blue);
    }

    public void randomize() {

        /**
         * External Citation
         * Date: September 7, 2020
         * Problem: Don't know how to create a random int
         *
         * Reference: https://stackoverflow.com/questions/20560899/generate-a-random-color-java
         *
         * Solution: make a Random object and use rand.nextInt to get a random number
         * */
        Random rand = new Random();
        //randomize hair color
        hairRed = rand.nextInt(255);
        hairGreen = rand.nextInt(255);
        hairBlue = rand.nextInt(255);

        //randomize skin color
        skinRed = rand.nextInt(255);
        skinGreen = rand.nextInt(255);
        skinBlue = rand.nextInt(255);

        //randomize eyecolor
        eyeRed = rand.nextInt(255);
        eyeGreen = rand.nextInt(255);
        eyeBlue = rand.nextInt(255);

        hairC.setColor(hairColor);
        skinC.setColor(skinColor);
        eyeC.setColor(eyeColor);
    }


    public void onDraw(Canvas canvas)
    {

        hairC.setColor(hairColor);
        skinC.setColor(skinColor);
        eyeC.setColor(eyeColor);

        canvas.drawCircle(500, 500, 250, skinC);
        drawEyes(canvas, eyeC);

        //this line draws the mouth
        canvas.drawOval(300, 0x258, 700, 550, black);

        if (hairStyle == "Bowl") {
            drawBowl(canvas);
        }
        else if(hairStyle == "Rectangle"){
            drawRectangle(canvas);
        }
        else if(hairStyle == "Tassels"){
            drawTassel(canvas);
        }

    }//onDraw

    /**
     * External Citation
     * Date: October 3rd, 2020
     * Problem: Didn't know how to draw things onto canvas
     *
     * Resources: Knowledge from in class lecture and example code to draw shapes to canvas and
     * https://thoughtbot.com/blog/android-canvas-drawarc-method-a-visual-guide to draw the half circle for bowl hair
     *
     *Solution: used different built in draw methods to create shapes
     *
     * @param canvas
     * @param paint
     */
    public void drawEyes(Canvas canvas, Paint paint) {
        canvas.drawCircle(400, 400, 50, paint);
        canvas.drawCircle(630, 400, 50, paint);

    }


    public void drawBowl(Canvas canvas){
        //bowl hair
        RectF rect = new RectF(300, 200, 700, 420);
        canvas.drawArc(rect, 0, -180, true, hairC);
    }

    public void drawRectangle(Canvas canvas){
        //rectangle hair
        canvas.drawRect(400, 230, 600, 330, hairC);
    }

    public void drawTassel(Canvas canvas){
        //tassel hair: an oval with strands of hair sticking down
        canvas.drawOval(300, 230, 700, 330, hairC);
        canvas.drawLine(350, 250, 350, 400, hairC);
        canvas.drawLine(400, 250, 400, 400, hairC);
        canvas.drawLine(450, 250, 450, 400, hairC);
        canvas.drawLine(500, 250, 500, 400, hairC);
        canvas.drawLine(550, 250, 550, 400, hairC);
        canvas.drawLine(600, 250, 600, 400, hairC);
    }

    public void setHairStyle(String hair){
        this.hairStyle = hair;
    }

}


//class CakeView


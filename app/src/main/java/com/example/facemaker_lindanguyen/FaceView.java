package com.example.facemaker_lindanguyen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.RadioButton;
import android.widget.SeekBar;

import java.util.Random;

public class FaceView extends SurfaceView {
    private int skinColor;
    private int eyeColor;

    public int hairRed;
    public int hairGreen;
    public int hairBlue;

    public int skinRed;
    public int skinGreen;
    public int skinBlue;

    private int hairStyle;

    public int eyeRed;
    public int eyeGreen;
    public int eyeBlue;



    public int hairC;
    public int eyeC;
    public int skinC;


    Paint skin = new Paint();
    Paint black = new Paint();
    Paint eye = new Paint();
    Paint hairColor = new Paint();


    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        randomize();


        black.setStrokeWidth(8.0f);
        setBackgroundColor(Color.WHITE);  //better than black default

        skinC = Color.rgb(skinRed, skinGreen, skinBlue);
        hairC = Color.rgb(hairRed, hairGreen, hairBlue);
        eyeC = Color.rgb(eyeRed, eyeGreen, eyeBlue);

    }


    public void randomize() {

        /**
         * Date: September 7, 2020
         * reference for choosing random ints found here: https://stackoverflow.com/questions/20560899/generate-a-random-color-java
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

        eyeColor = rand.nextInt(255);
        hairStyle = rand.nextInt(255);

        //this.hairC = Color.rgb(hairRed, hairGreen, hairBlue);
        //this.hairColor.setColor(hairC);
    }


    public void onDraw(Canvas canvas)
    {

        hairColor.setColor(hairC);
        skin.setColor(skinC);
        eye.setColor(eyeC);

        canvas.drawCircle(500, 500, 250, skin);
        //drawFace(canvas, black);
        drawHair(canvas, hairStyle);


    }//onDraw

    public void drawFace(Canvas canvas, Paint paint) {
        canvas.drawCircle(400, 400, 50, paint);
        canvas.drawCircle(630, 400, 50, paint);
        canvas.drawOval(300, 0x258, 700, 550, paint);
    }

    public void drawHair(Canvas canvas, int hair){
        if(hair == 0){
            //bowl hair
            RectF rect = new RectF(300, 200, 700, 420);
            canvas.drawArc(rect, 0, -180, true, hairColor);
        }
        else if(hair == 1){
            //rectangle hair
            canvas.drawRect(400, 230, 600, 330, hairColor);
        }
        else if(hair == 2){
            //tassel hair
            canvas.drawOval(300, 230, 700, 330, hairColor);
            canvas.drawLine(350, 250, 350, 400, hairColor);
            canvas.drawLine(400, 250, 400, 400, hairColor);
            canvas.drawLine(450, 250, 450, 400, hairColor);
            canvas.drawLine(500, 250, 500, 400, hairColor);
            canvas.drawLine(550, 250, 550, 400, hairColor);
            canvas.drawLine(600, 250, 600, 400, hairColor);
        }
    }

    public int getHairStyle(){
        return this.hairStyle;
    }

    public void setHairStyle(int hair){
        this.hairStyle = hair;
    }

}


//class CakeView


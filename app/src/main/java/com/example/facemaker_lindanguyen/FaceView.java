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
    private int hairStyle;


    Paint skin = new Paint();
    Paint black = new Paint();


    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        skin.setColor(0xFFC755B5);
        black.setColor(Color.BLACK);

        black.setStrokeWidth(8.0f);
        setBackgroundColor(Color.WHITE);  //better than black default

    }

    public void randomize() {

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


    public void onDraw(Canvas canvas)
    {



        canvas.drawCircle(500, 500, 250, skin);
        drawFace(canvas);



    }//onDraw

    public void drawFace(Canvas canvas) {
        canvas.drawCircle(400, 400, 50, black);
        canvas.drawCircle(630, 400, 50, black);
        canvas.drawOval(300, 0x258, 700, 550, black);
    }

    public void drawHairRectangleHair(Canvas canvas) {
        //rectangle hair
        canvas.drawRect(400, 230, 600, 330, black);
    }

    public void DrawTassleHair(Canvas canvas){
        //tassel hair
        canvas.drawOval(300, 230, 700, 330, black);
        canvas.drawLine(350, 250, 350, 400, black);
        canvas.drawLine(400, 250, 400, 400, black);
        canvas.drawLine(450, 250, 450, 400, black);
        canvas.drawLine(500, 250, 500, 400, black);
        canvas.drawLine(550, 250, 550, 400, black);
        canvas.drawLine(600, 250, 600, 400, black);
    }

    public void drawbowlhair(Canvas canvas){
        //bowl hair
        RectF rect = new RectF(300, 200, 700, 420);
        canvas.drawArc(rect, 0, -180, true, black);
    }
}


//class CakeView


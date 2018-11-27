package com.example.karan.airlines;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;

import android.os.Handler;

import java.util.Random;


public class GameView extends View {

    Handler handler;
    Runnable runnable;
    final int UPDATE_MILLIS=30;
    Bitmap background;
    Bitmap topTube, bottomTube;
    Display display;
    Point point;
    int mWidth, mHeight;
    Rect rect;
    Bitmap [] birds;
    int birdFrame=-0;
    int velocity=0,gravity=3;
    int birdX, birdY;
    boolean gameState = false;
    int gap = 400;
    int minTubeOffset, maxTubeOffset;
    int numberOfTubes = 4;
    int distanceBetweenTubes;
    int tubeX;
    int topTubeY;
    Random random;

    public GameView(Context context){
        super(context);
        handler = new Handler();
        runnable = new Runnable(){

            @Override
            public void run(){
                invalidate();
            }
        };

        background = BitmapFactory.decodeResource(getResources(),R.drawable.bg);
        topTube = BitmapFactory.decodeResource(getResources(), R.drawable.toptube);
        bottomTube = BitmapFactory.decodeResource(getResources(), R.drawable.bottomtube);
        display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        mWidth = point.x;
        mHeight = point.y;
        rect = new Rect(0,0,mWidth,mHeight);
        birds = new Bitmap[2];
        birds[0] = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
        birds[1] = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
        birdX = mWidth/2 - birds[0].getWidth()/2;
        birdY = mHeight/2 - birds[0].getHeight()/2;
        distanceBetweenTubes = mWidth*3/4;
        minTubeOffset = gap/2;
        maxTubeOffset = mHeight - minTubeOffset - gap;
        random = new Random();
        tubeX = mWidth/2 - topTube.getWidth()/2;
        topTubeY = minTubeOffset + random.nextInt(maxTubeOffset - minTubeOffset + 1);
    }




    protected void onDraw(Canvas canvas){

        super.onDraw(canvas);
        canvas.drawBitmap(background,null, rect,null);
       if(birdFrame==0){
           birdFrame=1;
       }else{
           birdFrame = 0;
       }
       if(gameState) {
           if (birdY < mHeight - birds[0].getHeight() || velocity < 0) {
               velocity += gravity;
               birdY += velocity;
           }
       }

        canvas.drawBitmap(birds[birdFrame],birdX,birdY,null);
        handler.postDelayed(runnable,UPDATE_MILLIS);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       int action  = event.getAction();
       if(action == MotionEvent.ACTION_DOWN){
           velocity = -30;
           gameState = true;
           topTubeY = minTubeOffset + random.nextInt(maxTubeOffset - minTubeOffset + 1);
       }

        return true;

    }
}

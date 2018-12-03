package com.example.karan.airlines;

<<<<<<< HEAD
import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

GameThread gameThread;
    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        if(!gameThread.isRunning()){
            gameThread = new GameThread(holder);
            gameThread.start();

        }else{
            gameThread.start();

        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retry = true;
            while(retry){
                try{
                    gameThread.join();
                    retry = false;
                }catch (InterruptedException e){

                }
            }
        }
    }

    void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            if(AppConstants.getGameEngine().gameState ==0){
                AppConstants.getGameEngine().gameState =1;
                AppConstants.getSoundBank().playSwoosh();
            }else{
                AppConstants.getSoundBank().playWing();
            }
//            AppConstants.getGameEngine().gameState = 1;
            AppConstants.getGameEngine().bird.setVelocity(AppConstants.VELOCITY_WHEN_JUMPED);
        }
        return true;
    }
=======
import android.view.SurfaceView;

public class GameView extends SurfaceView {
>>>>>>> e4e3a84982d854c28440346c9104c29fd78dd171
}


package com.example.karan.airlines;

import android.app.Activity;
<<<<<<< HEAD
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {

GameView gameView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        AppConstants.gameActivityContext = this;
        gameView = new GameView(this);
        setContentView(gameView);


    }
=======

public class GameActivity extends Activity {
>>>>>>> e4e3a84982d854c28440346c9104c29fd78dd171
}

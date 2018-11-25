package com.example.karan.airlines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Account_Activity extends AppCompatActivity {


    private Button  mLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_);
        mLogout = findViewById(R.id.logout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogout();
            }
        });

    }




    private void onLogout(){

    startActivity(new Intent(Account_Activity.this,MainActivity.class));
    }

    public void startGame(View view){

        startActivity(new Intent(Account_Activity.this,StartGame.class));

    }

}

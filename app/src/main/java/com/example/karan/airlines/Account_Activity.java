package com.example.karan.airlines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Account_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_);
        AppConstants.initialize(this.getApplicationContext());

    }

    private void onLogout(){

    startActivity(new Intent(Account_Activity.this,MainActivity.class));
    }

    public void startGame(View view){

        startActivity(new Intent(Account_Activity.this,GameActivity.class));

    }

}

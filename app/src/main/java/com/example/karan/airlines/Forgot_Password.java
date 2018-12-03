package com.example.karan.airlines;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password extends AppCompatActivity {

    private Button  mReset,mBack;
    private EditText editTextEmail;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        mReset = findViewById(R.id.reset);
        mBack = findViewById(R.id.btn_back);
        editTextEmail = (EditText) findViewById(R.id.sendEmail);


        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickReset();
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBack();
            }
        });


    }

    public void onClickBack(){
        Intent back = new Intent(Forgot_Password.this,MainActivity.class);
        startActivity(back);
        finish();
    }
    private void onClickReset(){
        String email = editTextEmail.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //if email is empty
            Toast.makeText(this,"Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email address");
            editTextEmail.requestFocus();
        }


        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    progressDialog.setMessage("Sending password link...");
                    progressDialog.show();

                    Toast.makeText(Forgot_Password.this, "Password link has been sent", Toast.LENGTH_SHORT).show();
                    finish();

                }else{
                    Toast.makeText(Forgot_Password.this, "Password cannot be sent", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}

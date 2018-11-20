package com.example.karan.airlines;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register extends AppCompatActivity implements View.OnClickListener{
    private Button register;
    private EditText mEmail;
    private EditText  mPassword;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        register = findViewById(R.id.register);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = findViewById(R.id.password);

        register.setOnClickListener(this);

    }


    private void registerUser(){
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //if email is empty
            Toast.makeText(this,"Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("Please enter a valid email address");
            mEmail.requestFocus();
        }
        if(TextUtils.isEmpty(password)){
            //if password is empty
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show();
            return;

        }
        if (mPassword.getText().toString().length() < 6) {
            mPassword.setError("Password must contain at least 6 character");
            mPassword.requestFocus();
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        progressDialog.setMessage("Registering user...");
                        progressDialog.show();
                        Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Register.this, "Could not register. Please try again...", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }

    public void onClick(View view){
        if(view == register){
            registerUser();
        }
    }
}

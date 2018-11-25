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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button mLogin, mReset;
    private EditText mEmail;
    private EditText mPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        progressDialog = new ProgressDialog(this);
//        mLogin = (Button)findViewById(R.id.mlogin);
//        mReset = findViewById(R.id.btn_reset_password);
//
//
//        mEmail = (EditText) findViewById(R.id.editTextEmail);
//        mPassword = findViewById(R.id.editTextPassword);
//
//
//        mLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginUser();
//            }
//        });
//
//        mReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Login.this, Forgot_Password.class));
//            }
//        });


    }



//    private void loginUser() {
//        String email = mEmail.getText().toString().trim();
//        String password = mPassword.getText().toString().trim();
//
//        if(TextUtils.isEmpty(email)){
//            //if email is empty
//            Toast.makeText(this,"Please enter your email", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            mEmail.setError("Please enter a valid email address");
//            mEmail.requestFocus();
//        }
//        if(TextUtils.isEmpty(password)){
//            //if password is empty
//            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show();
//            return;
//
//        }
//        if (mPassword.getText().toString().length() < 6) {
//            mPassword.setError("Password must contain at least 6 character");
//            mPassword.requestFocus();
//        }
//
//        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//
//
//                if(task.isSuccessful()){
//                    progressDialog.setMessage("Signing in...");
//                    progressDialog.show();
//                    startActivity(new Intent(Login.this,Account_Activity.class));
//                     finish();
//                    Toast.makeText(Login.this, "Signed in", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(Login.this, "Wrong username/password. Please try again...", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//    }
}

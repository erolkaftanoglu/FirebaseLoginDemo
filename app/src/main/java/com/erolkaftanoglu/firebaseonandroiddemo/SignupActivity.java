package com.erolkaftanoglu.firebaseonandroiddemo;

import android.content.Intent;
import android.support.annotation.MainThread;
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

public class SignupActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button signin,signup;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth = FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailstring = email.getText().toString();
                String passString = password.getText().toString();
                if (TextUtils.isEmpty(emailstring)){
                    Toast.makeText(getApplicationContext(),"Lütfen email adresi giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passString)){
                    Toast.makeText(getApplicationContext(),"Lütfen şifre giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passString.length() < 5 ){
                    Toast.makeText(getApplicationContext(),"şifre 5 karakten az olamaz", Toast.LENGTH_SHORT).show();
                    return;
                }

                //create user
                auth.createUserWithEmailAndPassword(emailstring,passString).
                        addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(getApplicationContext(),"Kullanıcı kayıt oldu.", Toast.LENGTH_SHORT).show();
                                if (task.isSuccessful()){
                                    startActivity(new Intent(SignupActivity.this,HomeActivity.class));
                                }
                            }
                        });


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailstring = email.getText().toString();
                final String passString = password.getText().toString();
                if (TextUtils.isEmpty(emailstring)){
                    Toast.makeText(getApplicationContext(),"Lütfen email adresi giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passString)){
                    Toast.makeText(getApplicationContext(),"Lütfen şifre giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passString.length() < 5 ){
                    Toast.makeText(getApplicationContext(),"şifre 5 karakten az olamaz", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(emailstring,passString).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(SignupActivity.this,HomeActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(),"abi senin şifren yanlış", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }
        });

    }
}

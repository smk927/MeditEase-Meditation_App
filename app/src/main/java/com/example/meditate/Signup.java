package com.example.meditate;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

   import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;

public class Signup extends AppCompatActivity {

        private EditText usernameEditText, passwordEditText;
        private Button signupButton;
        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            usernameEditText = findViewById(R.id.username);
            passwordEditText = findViewById(R.id.password);
            signupButton = findViewById(R.id.signup);

            mAuth = FirebaseAuth.getInstance();

            signupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String username = usernameEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    // Sign up with email and password
                    mAuth.createUserWithEmailAndPassword(username, password)
                            .addOnCompleteListener(Signup.this, task -> {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    // Registration success
                                    Intent intent = new Intent(Signup.this, Signin.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    FirebaseAuthException e = (FirebaseAuthException) task.getException();
                                    // Registration failed, handle the error
                                }
                            });
                }
            });
        }
    }
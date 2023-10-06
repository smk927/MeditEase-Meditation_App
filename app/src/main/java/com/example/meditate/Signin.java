package com.example.meditate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;

public class Signin extends AppCompatActivity {


        private EditText loginUsernameEditText, loginPasswordEditText;
        private Button loginButton;
        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signin);

            loginUsernameEditText = findViewById(R.id.username);
            loginPasswordEditText = findViewById(R.id.password);
            loginButton = findViewById(R.id.login);

            mAuth = FirebaseAuth.getInstance();

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String username = loginUsernameEditText.getText().toString();
                    String password = loginPasswordEditText.getText().toString();

                    // Sign in with email and password
                    mAuth.signInWithEmailAndPassword(username, password)
                            .addOnCompleteListener(Signin.this, task -> {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    // Login success
                                    Intent intent = new Intent(Signin.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    FirebaseAuthException e = (FirebaseAuthException) task.getException();
                                    // Login failed, handle the error

                                }
                            });
                }
            });
        }
    }
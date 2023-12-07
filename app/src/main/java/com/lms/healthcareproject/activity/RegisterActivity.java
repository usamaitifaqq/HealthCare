package com.lms.healthcareproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lms.healthcareproject.R;
import com.lms.healthcareproject.database.Database;
import com.lms.healthcareproject.databinding.ActivityLoginBinding;
import com.lms.healthcareproject.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=binding.editTextName.getText().toString();
                String email=binding.tvEmail.getText().toString();
                String password=binding.editTextPassword.getText().toString();
                String confirmation=binding.etConfirmPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if (username.length()==0 || password.length()==0 || email.length()==0 || confirmation.length()==0){
                    Toast.makeText(RegisterActivity.this, "Please fill all detail", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirmation)==0){
                        if (isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(RegisterActivity.this, "Record inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Passowrd must contain atleast 8 characters, having leter digit and speciual character", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }

            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }

            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }

            // Move the return statement outside the loop
            return f1 == 1 && f2 == 1 && f3 == 1;
        }
    }


}
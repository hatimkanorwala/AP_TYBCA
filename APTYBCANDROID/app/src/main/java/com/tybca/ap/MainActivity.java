package com.tybca.ap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Creating object of the widgets
    EditText _userName,_password;
    Button _login,_redirectRegister;
    TextView _loginMessage;

    String uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Linking my Backend Variables with the frontEnd(XML) ID
        _userName = findViewById(R.id.et_userName);
        _password = findViewById(R.id.et_password);
        _login = findViewById(R.id.loginButton);
        _redirectRegister = findViewById(R.id.redirectRegister);
        _loginMessage = findViewById(R.id.loginMessage);

        _loginMessage.setVisibility(View.GONE);
        _loginMessage.setText("");

        _login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _loginMessage.setVisibility(View.GONE);
                _loginMessage.setText("");

                //Extracting values from the object
                uname = _userName.getText().toString().trim();
                pass = _password.getText().toString().trim();

                //If username is blank of length is 0
                if(uname.length() < 0 && uname == "")
                {
                    _userName.setError("Username cannot be blank");
                }
                //If password is blank of length is 0
                else if(pass.length() < 0 && uname == "")
                {
                    _password.setError("Password cannot be blank");
                }
                else
                {
                    //if password is greater than 0 but less then 8
                    if(pass.length() > 0 && pass.length() < 8)
                    {
                        _password.setError("Password length should be more than 8");
                    }
                    //All the validations are successfully completed
                    else
                    {

                        _loginMessage.setVisibility(View.VISIBLE);
                        if(uname == "hatimkanowala" && pass == "password")
                        {
                            _loginMessage.setText("Login successful");
                            _loginMessage.setTextColor(getResources().getColor(R.color.success));
                        }
                        else
                        {
                            _loginMessage.setText("Failed to login, Please enter correct username or password");
                            _loginMessage.setTextColor(getResources().getColor(R.color.failure));
                        }
                    }
                }

            }
        });

        _redirectRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent -> myCurrentPage, NavigateToPage
                //CurrentPage -> pageName.this, getApplicationContext() -> Tells android to lookup the current page itself

                Intent i = new Intent(getApplicationContext(),registerActivity.class);
                startActivity(i);
                finish(); //Remove the current page process from the background/foreground
            }
        });




    }
}
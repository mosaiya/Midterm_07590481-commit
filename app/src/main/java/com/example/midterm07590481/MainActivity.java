package com.example.midterm07590481;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            Button loginnButton = findViewById(R.id.LoginButtun);
            loginnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText emailEditText = findViewById(R.id.username);
                    EditText passwordEditText = findViewById(R.id.Password);




                    String inputemail = emailEditText.getText().toString();
                    int value ;
                    try {
                        value= Integer.parseInt(inputemail);
                    }catch (Exception e){
                        value=-1;
                    }
                    String inputpassword = passwordEditText.getText().toString();

                    Auth auth = new Auth(inputemail, inputpassword);
                    int result = auth.check();
                    if (result == 1) {
                        Toast.makeText(MainActivity.this, "Welcome Chayanin Suk-in", Toast.LENGTH_SHORT).show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent intent = new Intent(MainActivity.this,com.example.midterm07590481.profilee.class);
                                startActivity(intent);
                                finish();
                            }
                        }, 3000);
                    }
                    else if (result==2) {
                        Toast.makeText(MainActivity.this, "Welcome Promlert Lovichit", Toast.LENGTH_SHORT).show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent intent = new Intent(MainActivity.this,com.example.midterm07590481.profile2.class);
                                startActivity(intent);
                                finish();
                            }
                        }, 3000);
                    }
                        else
                     {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Error")
                                .setMessage("Invalid email or password")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .show();
                    }

                }
            });
    }
}

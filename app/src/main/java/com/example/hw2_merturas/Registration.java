package com.example.hw2_merturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText username,password,repassword;
    Button signup,signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
        signin=findViewById(R.id.buttonsignin);
        signup=findViewById(R.id.buttonsignup);
        DB=new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Registration.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(Registration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else
                {
                    if (pass.equals(repass)){
                        Boolean checkuser=DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert=DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(Registration.this, "Registrated Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else
                            {
                                Toast.makeText(Registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Registration.this, "User already exists! Please try Again", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Registration.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
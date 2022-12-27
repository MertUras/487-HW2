package com.example.hw2_merturas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] teamNames = {"Bilkent Judges","Gorillas","Hacettepe Reddeers","METU Falcons","Mersin Mustangs"};
    int[] teamIcons={R.drawable.judges,R.drawable.gorillas,R.drawable.hacet,R.drawable.metu,R.drawable.mustangs};
    Spinner spinnerTeams;
    int currentItem=0;
    private Dialog dialog;
    private Button  ShowDialog;
    Button regBtn,gestureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerTeams=findViewById(R.id.spinner_teams);
        regBtn=findViewById(R.id.regBtn);
        gestureBtn=findViewById(R.id.gestureBtn);
        ShowDialog = findViewById(R.id.dialog_btn);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.backgroundsuccess));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button Okay = dialog.findViewById(R.id.btn_okay);
        Button Cancel = dialog.findViewById(R.id.btn_cancel);

        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        ShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show(); // Showing the dialog here
            }
        });


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });
        spinnerTeams.setOnItemSelectedListener(this);
        ItemAdapter adapter=new ItemAdapter(this,teamNames,teamIcons);
        spinnerTeams.setAdapter(adapter);


        gestureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Gesture.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this, teamNames[i], Toast.LENGTH_SHORT).show();

        if (currentItem==i){
            return;

        }else{
            Intent intent=new Intent(MainActivity.this, item_select.class);
            startActivity(intent);
        }


    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
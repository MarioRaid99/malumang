package com.example.opilane.malumang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class StartActivity extends AppCompatActivity { Button alusta;
    EditText Nimi, Nimi2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    ImageView uno, dos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        uno.startAnimation(animation1);
        dos.startAnimation(animation1);

        Nimi = findViewById(R.id.mängija1);
        Nimi2 = findViewById(R.id.mängija2);
        alusta = findViewById(R.id.mängi);
        sharedPreferences = getSharedPreferences("nimed", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        alusta.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View V){
                alusta();
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void alusta(){
        String m1 = Nimi.getText().toString();
        String m2 = Nimi2.getText().toString();
        editor.putString("Nimi1",m1);
        editor.putString("Nimi2",m1);
    }
}

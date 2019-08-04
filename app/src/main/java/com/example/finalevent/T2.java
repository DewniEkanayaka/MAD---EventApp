package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class T2 extends AppCompatActivity {
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                OpenActivity2();
            }
        });
    }

    public void OpenActivity2(){
        Intent intent = new Intent(this, T3.class);
        startActivity(intent);
    }
}

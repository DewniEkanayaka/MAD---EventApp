package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main4ActivityS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_s);
    }
    public void onaddClick(View view ){
        Intent intent = new Intent(Main4ActivityS.this, MainActivityS.class);
        startActivity(intent);
    }

    public void onallClick(View view ){
        Intent intent = new Intent(Main4ActivityS.this, Main3ActivityS.class);
        startActivity(intent);
    }

    public void onlogClick(View view ){
        Intent intent = new Intent(this , LoginTR.class);
        startActivity(intent);
    }

//    public void onFeedback(View view){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
}

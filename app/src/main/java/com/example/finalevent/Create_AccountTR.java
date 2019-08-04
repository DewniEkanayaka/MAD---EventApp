package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Create_AccountTR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createa_account_tr);
    }

    public void createuser(View view){
        Intent intent = new Intent(this, User_TR.class);
        startActivity(intent);


    }

    public void createprovider(View view){
        Intent intent = new Intent(this, AddAccount.class);
        startActivity(intent);


    }
}

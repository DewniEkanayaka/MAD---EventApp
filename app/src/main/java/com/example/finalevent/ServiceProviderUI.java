package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceProviderUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_ui);
    }

    public void ViewProfile(View view){
        Intent intent = new Intent(this, UpdateProfile.class);

        ServiceProv sp = (ServiceProv)getIntent().getSerializableExtra("spData");
        String spID = getIntent().getStringExtra("spID");

        intent.putExtra("spData",sp);
        intent.putExtra("spID",spID);

        startActivity(intent);


    }



    public void Services(View view){
        Intent intent = new Intent(this, T2.class);
        startActivity(intent);
    }

    public void LogOut(View view){
        Intent intent = new Intent(this, LoginTR.class);
        startActivity(intent);
    }

    public void Events(View view){
        Intent intent = new Intent(this, Events.class);
        startActivity(intent);
    }

    public void Feedback(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileUserTR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user_tr);




        }

         public void home(View view){
             Intent intent = new Intent(this, Main4ActivityS.class);
             startActivity(intent);
        }
        public void editUser(View view)
        {
            Intent intent = new Intent(this, EditProfileTR.class);
            startActivity(intent);
        }

        public void deleteUser(View view){
            Intent intent = new Intent(this , DeleteUserTR.class);
            startActivity(intent);
        }

    }


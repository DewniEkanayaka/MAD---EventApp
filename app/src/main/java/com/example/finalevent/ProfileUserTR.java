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

            Intent intent = getIntent();
            TextView textView1 = findViewById(R.id.pname);
            TextView textView2 = findViewById(R.id.pemail);
            TextView textView3 = findViewById(R.id.pphone);
            TextView textView4 = findViewById(R.id.pcity);
            TextView textView5 = findViewById(R.id.pusername);

            String action = getIntent().getStringExtra("user");
            if(action.equals("U"))
            {
                String name = intent.getStringExtra(EditProfileTR.NAME);
                textView1.setText(name);

                //for email
                String email = intent.getStringExtra(EditProfileTR.EMAIL);
                textView2.setText(email);

                //for phone
                String phone = intent.getStringExtra(EditProfileTR.PHONE);
                textView3.setText(phone);

                //for location
                String city = intent.getStringExtra(EditProfileTR.CITY);
                textView4.setText(city);
            }


            String uname = intent.getStringExtra(User_TR.UNAME);
            textView1.setText(uname);

            String username = intent.getStringExtra(User_TR.USERNAME);
            textView2.setText(username);

            String uemail = intent.getStringExtra(User_TR.UEMAIL);
            textView3.setText(uemail);

            String uphone = intent.getStringExtra(User_TR.UPHONE);
            textView4.setText(uphone);

            String ucity = intent.getStringExtra(User_TR.UCITY);
            textView5.setText(ucity);



        }

         public void create(View view){
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


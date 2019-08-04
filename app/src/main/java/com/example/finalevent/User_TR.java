package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class User_TR extends AppCompatActivity {
    public static final String UNAME = "com.example.userapp.Uname";
    public static final String USERNAME = "com.example.userapp.Username";
    public static final String UEMAIL = "com.example.userapp.Uemail";
    public static final String UCITY = "com.example.userapp.Ucity";
    public static final String UPHONE = "com.example.userapp.Uphone";
    public static final String UPASSWORD = "com.example.userapp.Upassword";
    public static final String UCONPASSWORD = "com.example.userapp.Uconpassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tr);

    }



    public void onCreation(View view){
        Intent intent = new Intent (this, ProfileUserTR.class);

        EditText editText1 = (EditText) findViewById(R.id.name);
        EditText editText2 = (EditText) findViewById(R.id.username);
        EditText editText3 = (EditText) findViewById(R.id.email);
        EditText editText4 = (EditText) findViewById(R.id.city);
        EditText editText5 = (EditText) findViewById(R.id.phone);
        EditText editText6 = (EditText) findViewById(R.id.password);
        EditText editText7 = (EditText) findViewById(R.id.conpassword);

        String uname = editText1.getText().toString();
        String uusername = editText2.getText().toString();
        String uemail = editText3.getText().toString();
        String ucity = editText4.getText().toString();
        String uphone = editText5.getText().toString();
        String upassword = editText6.getText().toString();
        String uconpassword = editText7.getText().toString();

        intent.putExtra("user","U");
        intent.putExtra(UNAME,uname);
        intent.putExtra(USERNAME,uusername);
        intent.putExtra(UEMAIL, uemail);
        intent.putExtra(UCITY, ucity);
        intent.putExtra(UPHONE, uphone);
        intent.putExtra(UPASSWORD, upassword);
        intent.putExtra(UCONPASSWORD, uconpassword);

        startActivity(intent);


    }
}

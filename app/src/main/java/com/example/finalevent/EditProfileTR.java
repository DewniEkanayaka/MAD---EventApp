package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditProfileTR extends AppCompatActivity {
    public static final String NAME = "com.example.userapp.Name";
    public static final String EMAIL = "com.example.userapp.Email";
    public static final String PHONE = "com.example.userapp.Phone";
    public static final String CITY = "com.example.userapp.City";
    public static final String PASSWORD = "com.example.userapp.password";
    public static final String CONPASSWORD = "com.example.userapp.conpassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_tr);
    }

    public void onUpdate(View view){
        Intent intent = new Intent(this, ProfileUserTR.class);

        EditText editText1 = (EditText) findViewById(R.id.uname);
        EditText editText2 = (EditText) findViewById(R.id.uemail);
        EditText editText3 = (EditText) findViewById(R.id.ucity);
        EditText editText4 = (EditText) findViewById(R.id.uphone);
        EditText editText5 = (EditText) findViewById(R.id.upassword);
        EditText editText6 = (EditText) findViewById(R.id.uconpassword);

        String name = editText1.getText().toString();
        String email = editText2.getText().toString();
        String city = editText3.getText().toString();
        String phone = editText4.getText().toString();
        String password = editText5.getText().toString();
        String conpassword = editText6.getText().toString();

        intent.putExtra("user","E");
        intent.putExtra(NAME, name);
        intent.putExtra(EMAIL, email);
        intent.putExtra(CITY, city);
        intent.putExtra(PHONE, phone);
        intent.putExtra(PASSWORD, password);
        intent.putExtra(CONPASSWORD, conpassword);

        startActivity(intent);

    }
}

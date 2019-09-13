package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddAccount extends AppCompatActivity {

    EditText companySP, emailSP, unameSP, pwdSP, confirmPwdSP;
    Button btnAdd;
    DatabaseReference dbRef;
    ServiceProv sp;

    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";


    private void clearControls(){
        companySP.setText("");
        emailSP.setText("");
        unameSP.setText("");
        pwdSP.setText("");
        confirmPwdSP.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_add);

        companySP = findViewById(R.id.companyS);
        emailSP = findViewById(R.id.emailS);
        unameSP = findViewById(R.id.contactS);
        pwdSP = findViewById(R.id.confPwd);
        confirmPwdSP = findViewById(R.id.confirmPwdSP);

        btnAdd = findViewById(R.id.btnSave);

        sp = new ServiceProv();

        addAccount();

    }

    public void addAccount(){

        dbRef = FirebaseDatabase.getInstance().getReference().child("ServiceProv");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(TextUtils.isEmpty(companySP.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter the Company Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(emailSP.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Email Address", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(unameSP.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Username",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(pwdSP.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Password", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(confirmPwdSP.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please confirm the Password",Toast.LENGTH_SHORT).show();
                    //else if(!emailSP.matches(regex))

                    else {
                        String spID = dbRef.push().getKey();

                        sp.setCompany(companySP.getText().toString().trim());
                        sp.setEmail(emailSP.getText().toString().trim());
                        sp.setUsername(unameSP.getText().toString().trim());
                        sp.setPassword(pwdSP.getText().toString().trim());

                        String password = pwdSP.getText().toString();
                        String confirmpassword = confirmPwdSP.getText().toString();

                        if (confirmpassword.equals(password)) {
                            dbRef.child(spID).setValue(sp);
                            Toast.makeText(getApplicationContext(), "New Account Created!", Toast.LENGTH_SHORT).show();
                            clearControls();

                            Intent intent = new Intent(AddAccount.this, ServiceProviderUI.class);

                            intent.putExtra("spData",sp);
                            intent.putExtra("spID", spID);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }






//    public void onClick(View view){
//        Intent intent = new Intent(this, ServiceProviderUI.class);
//        startActivity(intent);
//    }
}

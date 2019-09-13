package com.example.finalevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SaveChanges extends AppCompatActivity {

    EditText editCompanyS, editEmailS, editUnameS, editPasswordS, editConfPwdS;
    Button btnSaveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_changes);

        ServiceProv users = (ServiceProv)getIntent().getSerializableExtra("spData");
        String spID = getIntent().getStringExtra("spID");


        editCompanyS = findViewById(R.id.companyS);
        editEmailS = findViewById(R.id.emailS);
        editUnameS = findViewById(R.id.contactS);
        editPasswordS = findViewById(R.id.pwdS);
        editConfPwdS = findViewById(R.id.confPwd);
        btnSaveChanges = findViewById(R.id.btnSave);

        DatabaseReference showRef = FirebaseDatabase.getInstance().getReference().child("ServiceProv").child(spID);
        showRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    editCompanyS.setText(dataSnapshot.child("company").getValue().toString());
                    editEmailS.setText(dataSnapshot.child("email").getValue().toString());
                    editUnameS.setText(dataSnapshot.child("username").getValue().toString());
                    editPasswordS.setText(dataSnapshot.child("password").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No source to Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        SaveChangesMade();
    }
    public void SaveChangesMade(){
            btnSaveChanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    DatabaseReference updateRef = FirebaseDatabase.getInstance().getReference().child("ServiceProv");

                    updateRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            ServiceProv sp = (ServiceProv) getIntent().getSerializableExtra("spData");
                            String spID = getIntent().getStringExtra("spID");

                            if(dataSnapshot.hasChild(spID)){
                                try{
                                    if(TextUtils.isEmpty(editCompanyS.getText().toString()))
                                        Toast.makeText(getApplicationContext(),"Please enter the Company Name",Toast.LENGTH_SHORT).show();
                                    else if(TextUtils.isEmpty(editEmailS.getText().toString()))
                                        Toast.makeText(getApplicationContext(),"Please enter Email Address", Toast.LENGTH_SHORT).show();
                                    else if(TextUtils.isEmpty(editUnameS.getText().toString()))
                                        Toast.makeText(getApplicationContext(),"Please enter a Username",Toast.LENGTH_SHORT).show();
                                    else if(TextUtils.isEmpty(editPasswordS.getText().toString()))
                                        Toast.makeText(getApplicationContext(),"Please enter a Password", Toast.LENGTH_SHORT).show();
                                    else if(TextUtils.isEmpty(editConfPwdS.getText().toString()))
                                        Toast.makeText(getApplicationContext(),"Please confirm the Password",Toast.LENGTH_SHORT).show();
                                        //else if(!emailSP.matches(regex))

                                    else {

                                        sp.setCompany(editCompanyS.getText().toString().trim());
                                        sp.setEmail(editEmailS.getText().toString().trim());
                                        sp.setUsername(editUnameS.getText().toString().trim());
                                        sp.setPassword(editPasswordS.getText().toString().trim());

                                        String password = editPasswordS.getText().toString();
                                        String confirmpassword = editConfPwdS.getText().toString();

                                        if (confirmpassword.equals(password)) {
                                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("ServiceProv").child(spID);
                                            dbRef.setValue(sp);
                                            Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();


                                            Intent intent = new Intent(SaveChanges.this, UpdateProfile.class);

                                            intent.putExtra("spData",sp);
                                            intent.putExtra("spID", spID);
                                            startActivity(intent);

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                catch(NumberFormatException e){
                                    Toast.makeText(getApplicationContext(),"Please enter a valid Contact Number",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            });
        }

}

//    public void onClick(View view){
//        Toast.makeText(SaveChanges.this,"Update Successful",Toast.LENGTH_LONG).show();
//    }


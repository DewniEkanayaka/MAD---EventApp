package com.example.finalevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfile extends AppCompatActivity {

    EditText companySP, emailSP, unameSP, contactSP;
    Button btnUpdate;
    Button btnDelete;
    DatabaseReference dbRef;
    ServiceProv sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        ServiceProv users = (ServiceProv)getIntent().getSerializableExtra("spData");
        String spID = getIntent().getStringExtra("spID");

        companySP = findViewById(R.id.companyS);
        companySP.setEnabled(false);
        emailSP = findViewById(R.id.emailS);
        emailSP.setEnabled(false);
        unameSP = findViewById(R.id.unameSh);
        unameSP.setEnabled(false);
        contactSP = findViewById(R.id.contactSh);
        contactSP.setEnabled(false);

        btnUpdate = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);

        DatabaseReference showRef = FirebaseDatabase.getInstance().getReference().child("ServiceProv").child(spID);
        showRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    companySP.setText(dataSnapshot.child("company").getValue().toString());
                    emailSP.setText(dataSnapshot.child("email").getValue().toString());
                    unameSP.setText(dataSnapshot.child("username").getValue().toString());
                    contactSP.setText(dataSnapshot.child("contactNo").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No source to Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateInfo(View view)
    {
        ServiceProv sp = (ServiceProv) getIntent().getSerializableExtra("spData");
        String spID = getIntent().getStringExtra("spID");
        Intent intent = new Intent(this, SaveChanges.class);
        intent.putExtra("spData",sp);
        intent.putExtra("spID",spID);
        startActivity(intent);
    }


    public void DeleteAcc(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to delete your Account?");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                //ServiceProv sp = (ServiceProv) getIntent().getSerializableExtra("spData");
                                String spID2 = getIntent().getStringExtra("spID");
                                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("ServiceProv").child(spID2);
                                dbRef.removeValue();
                                Toast.makeText(getApplicationContext(),"Your Account has been deleted Successfully",Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(UpdateProfile.this, MainActivityTR.class);
                                startActivity(intent);
                            }
                        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}



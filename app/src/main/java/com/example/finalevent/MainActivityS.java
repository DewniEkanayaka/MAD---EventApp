package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Boolean.FALSE;

public class MainActivityS extends AppCompatActivity {

    EditText txtName, txtDate, txtTime, txtPlace, txtnumOfGuests, txtBudget, txtTheme ;
    CheckBox chkPhoto, chkEnter, chkFood;
    Button addBtn;
    String UserID;
    Integer count;

    DatabaseReference dbRef;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_s);

        //Intent intent = getIntent();
        //count = intent.getIntExtra(Main3ActivityS.COUNT,0);

        txtName = findViewById(R.id.nameAdd);
        txtDate = findViewById(R.id.dateAdd);
        txtTime = findViewById(R.id.timeAdd);
        txtPlace = findViewById(R.id.placeAdd);
        txtnumOfGuests = findViewById(R.id.numOfGusetsAdd);
        txtBudget = findViewById(R.id.budgetAdd);
        txtTheme = findViewById(R.id.themeAdd);


        chkPhoto = findViewById(R.id.photoAdd);
        chkEnter = findViewById(R.id.enterAdd);
        chkFood = findViewById(R.id.foodAdd);

        addBtn = findViewById(R.id.eventBtnAdd);

        UserID = "User1";

        event = new Event();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Event").child(UserID);

                try{
////                    if(count>=6){
////                        Toast.makeText(getApplicationContext(),"Cannot add more events, Delete a past event and add! ",Toast.LENGTH_LONG).show();
////                    }
//                    else
                        if(TextUtils.isEmpty(txtName.getText().toString())|| TextUtils.isEmpty(txtDate.getText().toString())||
                            TextUtils.isEmpty(txtTime.getText().toString()) || TextUtils.isEmpty(txtPlace.getText().toString())||
                            TextUtils.isEmpty(txtnumOfGuests.getText().toString()) || TextUtils.isEmpty(txtBudget.getText().toString()) ||
                            TextUtils.isEmpty(txtTheme.getText().toString()) ){
                        Toast.makeText(getApplicationContext(),"One or more empty fields",Toast.LENGTH_LONG).show();
                    }

                    else if(!((txtDate.getText().toString()).matches("\\d{2}-\\d{2}-\\d{4}") &&
                            (txtTime.getText().toString()).matches("\\d{2}:\\d{2}"))){
                        Toast.makeText(getApplicationContext(),"Please enter valid date and time according to pattern",Toast.LENGTH_LONG).show();
                    }

                    else{
                        event.setName(txtName.getText().toString().trim());
                        event.setDate(txtDate.getText().toString().trim());
                        event.setTime(txtTime.getText().toString().trim());
                        event.setPlace(txtPlace.getText().toString().trim());
                        event.setNumOfGuests(Integer.parseInt(txtnumOfGuests.getText().toString()));
                        event.setBudget(txtBudget.getText().toString().trim());
                        event.setTheme(txtTheme.getText().toString().trim());

                        event.setPhoto(chkPhoto.isChecked());
                        event.setFood(chkFood.isChecked());
                        event.setEnter(chkEnter.isChecked());

                        dbRef.child(txtName.getText().toString()).setValue(event);

                        Toast.makeText(getApplicationContext(),"Insertion Successful!!!", Toast.LENGTH_LONG).show();
                        clearControls();
                    }
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void clearControls(){
        txtDate.setText("");
        txtTime.setText("");
        txtPlace.setText("");
        txtnumOfGuests.setText("");
        txtBudget.setText("");
        txtTheme.setText("");
        txtName.setText("");
        chkPhoto.setChecked(FALSE);
        chkEnter.setChecked(FALSE);
        chkFood.setChecked(FALSE);
    }
}

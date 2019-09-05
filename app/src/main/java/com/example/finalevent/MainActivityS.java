package com.example.finalevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityS extends AppCompatActivity {
    DBHelperS SanBD;
    EditText editDate, editTime, editPlace, editBudget, editTheme, editGuests;
    String tchkp = " ";
    String tchkf = " ";
    String tchken = " ";
    CheckBox checkPhoto, checkFood, checkEnte;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_s);
        SanBD = new DBHelperS(this);

        editDate = (EditText)findViewById(R.id.editSdate);
        editTime = (EditText)findViewById(R.id.editStime);
        editPlace = (EditText)findViewById(R.id.editSplace);
        editGuests = (EditText)findViewById(R.id.editSguests);
        editBudget = (EditText)findViewById(R.id.editSbudget);
        editTheme = (EditText)findViewById(R.id.editStheme);

        btnadd = (Button)findViewById(R.id.butnaddevent) ;

        checkPhoto = (CheckBox)findViewById(R.id.chk1);
        checkFood  = (CheckBox)findViewById(R.id.chk2);
        checkEnte = (CheckBox)findViewById(R.id.chk3);

        addData();
    }

    public void addData(){
        btnadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(checkPhoto.isChecked())
                            tchkp = checkPhoto.getText().toString();

                        if(checkFood.isChecked())
                            tchkf = checkFood.getText().toString();

                        if(checkEnte.isChecked())
                            tchken = checkEnte.getText().toString();

                        boolean inserted = SanBD.addInfo(editDate.getText().toString(),
                                editTime.getText().toString(),
                                editPlace.getText().toString(),
                                editGuests.getText().toString(),
                                editBudget.getText().toString(),
                                editTheme.getText().toString(),
                                tchkp,
                                tchkf,
                                tchken);

                        if(inserted = true)
                            Toast.makeText(MainActivityS.this,"Data inserted successfully",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivityS.this,"Data not inserted",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}

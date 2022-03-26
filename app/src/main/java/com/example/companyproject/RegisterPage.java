package com.example.companyproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegisterPage extends AppCompatActivity {
EditText regname,regDOB,regesteremail,regesterpassword,
        regphonenumber,regpflatstreet,regarea, regcity,regstate,regcontry,regpincode,regprofession,
    regnameofpet,regbreed;
TextView personaldetails,addressdetails,Petdetails;
Switch switchbutton;
 Spinner spinner;
Button register;
Calendar myCalender=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
 spinner=(Spinner) findViewById(R.id.Spinner);
ArrayAdapter adapter= ArrayAdapter.createFromResource(this,R.array.Type, android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapter);


spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});


        register=findViewById(R.id.Registration);

//Personal details
        personaldetails=findViewById(R.id.personaldetails);
        regname=findViewById(R.id.name);
        regDOB=findViewById(R.id.BirtDate);
        regphonenumber=findViewById(R.id.PhoneNumber);
        regesteremail=findViewById(R.id.Registeremail);
        regprofession=findViewById(R.id.Profession);
        regesterpassword=findViewById(R.id.Registerpassword);

        regname.setVisibility(View.GONE);
        regDOB.setVisibility(View.GONE);
        regphonenumber.setVisibility(View.GONE);
        regesteremail.setVisibility(View.GONE);
        regprofession.setVisibility(View.GONE);
        regesterpassword.setVisibility(View.GONE);

        regnameofpet=findViewById(R.id.PetName);
        regbreed=findViewById(R.id.Breed);
        switchbutton=findViewById(R.id.radiobutton);

        //Address Details
        addressdetails=findViewById(R.id.addressdetails);
        regpflatstreet=findViewById(R.id.FlatStreet);
        regarea=findViewById(R.id.Area);
        regcity=findViewById(R.id.City);
        regstate=findViewById(R.id.State);
        regcontry=findViewById(R.id.Country);
        regpincode=findViewById(R.id.Pin_Code);

        regpflatstreet.setVisibility(View.GONE);
        regarea.setVisibility(View.GONE);
        regcity.setVisibility(View.GONE);
        regstate.setVisibility(View.GONE);
        regcontry.setVisibility(View.GONE);
        regpincode.setVisibility(View.GONE);

        //Pet Details
        Petdetails=findViewById(R.id.petdetails);
        regnameofpet=findViewById(R.id.PetName);
        regbreed=findViewById(R.id.Breed);

        Petdetails.setVisibility(View.GONE);
        regnameofpet.setVisibility(View.GONE);
        regbreed.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);



        //Date Of Birth page


        final DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalender.set(Calendar.YEAR,year);
                myCalender.set(Calendar.MONTH,month);
                myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                upDateDate();


            }
        };
        regDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterPage.this,date,
                        myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        





    }

    private void upDateDate() {
        String myFormat="dd/MM/yy";
        SimpleDateFormat sdf=new SimpleDateFormat(myFormat, Locale.ENGLISH);
        regDOB.setText(sdf.format(myCalender.getTime()));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public  void Registration(View v)
    {
        String pet_Type=spinner.getSelectedItem().toString();
        new Dbmanager(this);
        Dbmanager dbmanager=new Dbmanager(this);
        String res=dbmanager.RegisterRecord(regname.getText().toString(),regDOB.getText().toString(),regphonenumber.getText().toString(),regesteremail.getText().toString(),
                regprofession.getText().toString(),regesterpassword.getText().toString(),
                regpflatstreet.getText().toString(),regarea.getText().toString(),regcity.getText().toString(),
                regstate.getText().toString(),regcontry.getText().toString(),regpincode.getText().toString(),
                pet_Type,regnameofpet.getText().toString(),regbreed.getText().toString() );
        Toast.makeText(getApplicationContext(),"Registration Successfully",Toast.LENGTH_LONG).show();
    }

//Switch Button Method
public void checkPet(View v)
{
if (switchbutton.isChecked()==true)
{

    Petdetails.setVisibility(View.VISIBLE);

}
else {
    regnameofpet.setVisibility(View.GONE);
    spinner.setVisibility(View.GONE);
    regbreed.setVisibility(View.GONE);
    Petdetails.setVisibility(View.GONE);
}
}

//Personal Details Method
    public void Personaldetail(View v)
    {
        if (personaldetails.isClickable()==true)
        {
            regname.setVisibility(View.VISIBLE);
            regDOB.setVisibility(View.VISIBLE);
            regphonenumber.setVisibility(View.VISIBLE);
            regesteremail.setVisibility(View.VISIBLE);
            regprofession.setVisibility(View.VISIBLE);
            regesterpassword.setVisibility(View.VISIBLE);
        }
    }

    //Address Details Method

    public void AddressDetails(View v)
    {
        if (addressdetails.isClickable()==true)
        {
            regpflatstreet.setVisibility(View.VISIBLE);
            regarea.setVisibility(View.VISIBLE);
            regcity.setVisibility(View.VISIBLE);
            regstate.setVisibility(View.VISIBLE);
            regcontry.setVisibility(View.VISIBLE);
            regpincode.setVisibility(View.VISIBLE);
        }
    }
    
    // Pet Details
    public void PetDetails(View v)
    {
        if (Petdetails.isClickable()==true)
        {
            spinner.setVisibility(View.VISIBLE);
            regnameofpet.setVisibility(View.VISIBLE);
            regbreed.setVisibility(View.VISIBLE);
        }
    }
}
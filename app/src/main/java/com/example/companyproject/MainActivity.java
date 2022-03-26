package com.example.companyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView createaccount;
EditText email,MobileNumber,OTP;
EditText password;
RadioButton Member,Guest;
Button LoginButton,GetOTP,membarLoginButton;
RegisterPage registerPage=new RegisterPage();
HomeActivity homeActivity=new HomeActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.UserName);
        password=findViewById(R.id.Password);

        membarLoginButton=findViewById(R.id.memberLogin);
       // LoginButton=findViewById(R.id.Click);

        //Guest Button Work
        MobileNumber=findViewById(R.id.MobileNumber);
        OTP=findViewById(R.id.OTP);
        GetOTP=findViewById(R.id.getotp);
        Member=findViewById(R.id.Member);
        Guest=findViewById(R.id.Guest);

        // GuestMembarButton

        MobileNumber.setVisibility(View.GONE);
        OTP.setVisibility(View.GONE);
        GetOTP.setVisibility(View.GONE);


    }
    // Open Register Page Method
    public  void createAccountPage(View v)
    {
        Intent intent=new Intent(getApplicationContext(),RegisterPage.class);
startActivity(intent);
    }

    public void HomePage(View v)
    {
        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }

    // Login Page Method
    public void LoginPage(View v) {
        String user = email.getText().toString();
        String mobile = email.getText().toString();
        String pass = password.getText().toString();


        if (user.isEmpty() == true && pass.isEmpty() == true) {
            Toast.makeText(getApplicationContext(), "Enter Username and Password", Toast.LENGTH_LONG).show();

        } else {

            //Database Call
            new Dbmanager(this);
            Dbmanager dbmanager = new Dbmanager(this);


            boolean chekregister = dbmanager.checkRegister(user, mobile, pass);
            if (chekregister == true) {



                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);


            } else {
                Toast.makeText(getApplicationContext(), "Login Not Done", Toast.LENGTH_LONG).show();

            }

        }
    }

    //Membar Button Funcation
    public  void MemberButton(View v)
    {
        if (Member.isClickable()==true)
        {
            MobileNumber.setVisibility(View.GONE);
            OTP.setVisibility(View.GONE);
            GetOTP.setVisibility(View.GONE);
            email.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);

        }
    }
    // Guest Button Method
    public  void GuestButton(View v)
    {
        if (Guest.isClickable()==true)
        {
            email.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            MobileNumber.setVisibility(View.VISIBLE);
            OTP.setVisibility(View.VISIBLE);
            GetOTP.setVisibility(View.VISIBLE);

        }
    }
}
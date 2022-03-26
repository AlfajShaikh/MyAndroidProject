package com.example.companyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        location = findViewById(R.id.Location);



    }

    public void Visiable(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.items);
        popup.show();
    }

    public void CityList(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.cityitems);
        popup.show();
    }

    public void petShop(View v)
    {

        String CityLocation=location.getText().toString();
        Intent intent=new Intent(getApplicationContext(),fetchdata.class);
       startActivity(intent);

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.cityMumbai:
                location.setText("Mumbai");
                return true;
            case R.id.cityThane:
                location.setText("Thane");
                return true;
            case R.id.cityiPune:
                location.setText("Pune");
                return true;
            default:return false;

        }
    }



}

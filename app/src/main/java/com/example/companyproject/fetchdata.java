package com.example.companyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class fetchdata extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    ArrayList<model> dataholder=new ArrayList<>();
    RecyclerView recyclerView;
    TextView location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fetchdata);
        location = findViewById(R.id.Location);
        recyclerView=findViewById(R.id.reciview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new dbmanagersecond(this).readalldata();
        while (cursor.moveToNext())
        {
            model obj=new model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(obj);
        }
        myadapter adapter=new myadapter(dataholder,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
    public void CityList(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.cityitems);
        popup.show();
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
    public void Visiable(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.items);
        popup.show();
    }
    public  void  backHomepage(View v)
    {
        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }
}

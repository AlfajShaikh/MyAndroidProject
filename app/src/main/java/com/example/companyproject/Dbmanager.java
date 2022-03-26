package com.example.companyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

class Dbmanager extends SQLiteOpenHelper {

    public static final String dbname="InternProject.db";

public Dbmanager(Context context)
{
super(context,dbname,null,1);
}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String Query="create table RegisterDetails(Username,DOB,Mobile_number,Email_ID,Profession,Userpassword,Street,Area,City,State,Country,PinCode,Pet_type,Pet_Name,Breed)";

        sqLiteDatabase.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists RegisterDetails");

        onCreate(sqLiteDatabase);

    }

public String RegisterRecord(String s1, String s2, String s3,String s4,String s5,String s6,String s7,
                             String s8,String s9,String s10,String s11,String s12,
                             String s13,String s14,String s15){
SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    ContentValues cv=new ContentValues();
cv.put("Username",s1);
cv.put("DOB",s2);
cv.put("Mobile_number",s3);
cv.put("Email_ID",s4);
cv.put("Profession",s5);
cv.put("Userpassword",s6);
cv.put("Street",s7);
cv.put("Area",s8);
cv.put("City",s9);

cv.put("State",s10);
cv.put("Country",s11);
cv.put("PinCode",s12);
cv.put("Pet_type",s13);

cv.put("Breed",s14);
cv.put("Pet_name",s15);


long res=sqLiteDatabase.insert("RegisterDetails",null,cv);
if (res==-1)
{
return "faild";
}
else {
    return "Registration done";
}
}
public boolean checkRegister( String Email_ID,String Mobile_number,String Userpassword)
{
SQLiteDatabase sqLiteDatabase=getWritableDatabase();
    Cursor cursor=sqLiteDatabase.rawQuery("select * from RegisterDetails where Email_ID=? and Userpassword=? or Mobile_number=? and Userpassword=? ",new String[]{Email_ID,Userpassword,Mobile_number,Userpassword});
    if (cursor.getCount()>0)
    {
        return true;
    }
    else {
        return false;
    }
}
    public String addrecord(String name,String contact,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("email",email);
        float res=db.insert("tbl_contact",null,cv);
        if (res==-1)

            return "failed";
        else
            return "successfully inserted";

    }



}

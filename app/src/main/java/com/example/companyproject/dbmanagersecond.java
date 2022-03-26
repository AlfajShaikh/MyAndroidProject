package com.example.companyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class dbmanagersecond extends SQLiteOpenHelper {
    private static final  String dbname="dbcontact.db";

    public dbmanagersecond (@Nullable Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry="create table tbl_contact(id integer primary key autoincrement,name text,contact text,email text)";
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry="DROP TABLE IF EXISTS tbl_contact";


        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    // Using Fetching Data
    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tbl_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;

    }
}

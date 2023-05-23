package com.tybca.ap.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "college.db";
    public static final String TABLE_NAME = "students";
    public static final String col1 = "id";
    public static final String col2 = "firstName";
    public static final String col3 = "lastName";
    public static final String col4 = "email";
    public static final String col5 = "contact";
    //Context -> The page from where it is referring
    public DBHelper(Context context)
    {
        super(context,DB_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table tableName(col1 datatype1,col2 datatype2)
        sqLiteDatabase.execSQL("create table "+ TABLE_NAME + "("+col1+" int PRIMARY KEY AUTOINCREMENT,"+col2+" TEXT,"+col3+" TEXT,"+col4+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table IF EXISTS " + TABLE_NAME);
    }

    //Insert into Table
    public Boolean insertedData(String name,String lName,String email,String contact)
    {
        //ContentValues -> Maps the data with its key to insert into DB
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,lName);
        contentValues.put(col4,email);
        contentValues.put(col5,contact);

        double result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        // -1 -> False, +1/1 -> True
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    //Cursor -> is used to loop through the data in array format
    public Cursor getData()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from "+ TABLE_NAME,null);
        return cursor;
    }

}

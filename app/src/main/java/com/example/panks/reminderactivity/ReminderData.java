package com.example.panks.reminderactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReminderData extends SQLiteOpenHelper {
    public static final String DATABAS_NAME = "reminder.db";
    public static final String TABLE_NAME = "REMINDER_RECORD";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "REMINDER_TEXT";

    public ReminderData(Context context) {
        super(context,DATABAS_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table REMINDER_RECORD (ID INTEGER PRIMARY KEY,REMINDER_TEXT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists REMINDER_RECORD");
        onCreate(db);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from REMINDER_RECORD",null);
        return res;
    }

    public boolean insertData(String path){
        boolean state=false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("REMINDER_TEXT",path);
        long t = db.insert("REMINDER_RECORD",null,contentValues);
        if(t==-1) state = false;
        else state = true;
        return state;
    }
}
/**

 package com.example.panks.addrepo;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Hashtable;
 import android.content.ContentValues;
 import android.content.Context;
 import android.database.Cursor;
 import android.database.DatabaseUtils;
 import android.database.sqlite.SQLiteOpenHelper;
 import android.database.sqlite.SQLiteDatabase;

 public class DBHelper extends SQLiteOpenHelper {

 public static final String DATABAS_NAME = "path.db";
 public static final String TABLE_NAME = "FILE_RECORD";
 public static final String COL_1 = "ID";
 public static final String COL_2 = "PATH";
 public static final String COL_3 = "displayname";



 public DBHelper(Context context) {
 super(context, DATABAS_NAME, null, 1);
 SQLiteDatabase db = this.getWritableDatabase();
 }

 @Override
 public void onCreate(SQLiteDatabase db) {
 db.execSQL("create table FILE_RECORD (ID INTEGER PRIMARY KEY,path TEXT,displayname TEXT)");
 }

 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 db.execSQL("drop table if exists FILE_RECORD");
 onCreate(db);
 }

 public boolean insertPath(String path,String displayname){
 boolean state;
 SQLiteDatabase db = this.getWritableDatabase();
 ContentValues contentValues = new ContentValues();
 contentValues.put(COL_2,path);
 contentValues.put(COL_3,displayname);
 long t = db.insert("FILE_RECORD",null,contentValues);
 if(t==-1) state = false;
 else state = true;
 return state;
 }

 public Cursor getData(String id){
 SQLiteDatabase db = this.getWritableDatabase();
 Cursor res = db.rawQuery("select * from FILE_RECORD where ID=="+id,null);
 return res;
 }
 public Cursor getAllData(){
 SQLiteDatabase db = this.getWritableDatabase();
 Cursor res = db.rawQuery("select * from FILE_RECORD",null);
 return res;
 }

 }
 */

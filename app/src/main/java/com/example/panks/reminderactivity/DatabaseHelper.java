package com.example.panks.reminderactivity;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "reminder.db";
    public static final String TABLE_NAME = "REMINDER_RECORD";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "LOCATION";
    public static final String COL_4 = "DETAILS";
    public static final String COL_5 = "COMMENT";
    Context c;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Toast.makeText(context,"databases created",Toast.LENGTH_LONG);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table " + TABLE_NAME +" ("+COL_1+"INTEGER PRIMARY KEY AUTOINCREMENT"+","+COL_2+" TEXT"+","+COL_3+" TEXT"+",DETAILS TEXT,COMMENT TEXT)");
        db.execSQL("create table reminder_record (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,LOCATION TEXT,DETAILS TEXT,COMMENT TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY," +
                COL_2 + " TEXT," +
                COL_3 + " TEXT" +
                COL_4 + "TEXT"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String title,String location,String details,String comment) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,location);
        contentValues.put(COL_4,details);
        contentValues.put(COL_5,comment);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String title,String location,String details,String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,location);
        contentValues.put(COL_4,details);
        contentValues.put(COL_4,comment);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}

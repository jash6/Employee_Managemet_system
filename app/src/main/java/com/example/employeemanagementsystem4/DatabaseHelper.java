package com.example.employeemanagementsystem4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Employee.db";
    public static final String TABLE_NAME="employee_table";
    public static final String EMPLOYEE_ID="EMPLOYEE_ID";
    public static final String NAME="NAME";
    public static final String DEPARTMENT="DEPARTMENT";
    public static final String EMAIL="EMAIL";
    public static final String SALARY="SALARY";
    public static final String GENDER="GENDER";
    public static final String AGE="AGE";
    public static final String DATE_OF_JOINING="DATE_OF_JOINING";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry="CREATE TABLE "+ TABLE_NAME +"("+ EMPLOYEE_ID +" TEXT PRIMARY KEY,"+ NAME +" TEXT,"+ DEPARTMENT +" TEXT,"+ EMAIL +" TEXT,"+ SALARY +" REAL,"+ GENDER +" TEXT,"+ AGE +"INTEGER,"+ DATE_OF_JOINING +" TEXT)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String id, String name, String department, String email, float salary, String gender, int age, String date){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(EMPLOYEE_ID,id);
        contentValues.put(NAME,name);
        contentValues.put(DEPARTMENT,department);
        contentValues.put(EMAIL,email);
        contentValues.put(SALARY,salary);
        contentValues.put(GENDER,gender);
        contentValues.put(AGE,age);
        contentValues.put(DATE_OF_JOINING,date);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("Select EMPLOYEE_ID ,NAME ,DEPARTMENT ,EMAIL ,SALARY ,GENDER ,AGE ,DATE_OF_JOINING  from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id, String name, String department, String email, float salary, String gender, int age, String date){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(EMPLOYEE_ID,id);
        contentValues.put(NAME,name);
        contentValues.put(DEPARTMENT,department);
        contentValues.put(EMAIL,email);
        contentValues.put(SALARY,salary);
        contentValues.put(GENDER,gender);
        contentValues.put(AGE,age);
        contentValues.put(DATE_OF_JOINING,date);
        sqLiteDatabase.update(TABLE_NAME,contentValues,EMPLOYEE_ID+" = ?",new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,EMPLOYEE_ID+"= ?",new String[]{id});
    }
}

package com.example.employeemanagementsystem4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeInfoActivity extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_info);
        final LinearLayout lm=(LinearLayout)findViewById(R.id.viewemployeeactivity);
        myDB=new DatabaseHelper(this);

        //create layout parameter
     LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
             LinearLayout.LayoutParams.WRAP_CONTENT,
             LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor cursor=myDB.getAllData();
        cursor.moveToFirst();

        if(cursor ==null){
            Toast.makeText(getApplicationContext(),"NO Data",Toast.LENGTH_LONG).show();
        }else {

            //create for four students
           while(cursor.moveToNext()) {

               String employee_id4=cursor.getString(0);
               String name4=cursor.getString(1);
               String department4=cursor.getString(2);
               String email4=cursor.getString(3);
               float salary4=cursor.getFloat(4);
               String gender4=cursor.getString(5);
               Integer age4=cursor.getInt(6);
               String date_of_joining=cursor.getString(7);
                //create linear layout
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);


                //create Text View
                TextView employee_id5 = new TextView(this);
                employee_id5.setText("" + employee_id4);
                employee_id5.setWidth(150);
                ll.addView(employee_id5);

                TextView name5 = new TextView(this);
                name5.setText("" + name4);
                name5.setWidth(190);
                ll.addView(name5);

                TextView department5 = new TextView(this);
                department5.setText("" + department4);
                department5.setWidth(200);
                ll.addView(department5);

                TextView email5 = new TextView(this);
                email5.setText("" + email4);
                email5.setWidth(200);
                ll.addView(email5);

                TextView salary5 = new TextView(this);
                salary5.setText("" + salary4);
                salary5.setWidth(130);
                ll.addView(salary5);

                TextView gender5 = new TextView(this);
                gender5.setText("" + gender4);
                gender5.setWidth(130);
                ll.addView(gender5);

                TextView age5 = new TextView(this);
                age5.setText("" + age4);
                age5.setWidth(130);
                ll.addView(age5);

                TextView date5 = new TextView(this);
                date5.setText("" + date_of_joining);
                date5.setWidth(130);
                ll.addView(date5);

                lm.addView(ll);
            }
        }
    }

}
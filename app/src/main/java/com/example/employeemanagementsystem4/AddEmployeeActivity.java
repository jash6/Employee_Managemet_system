package com.example.employeemanagementsystem4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployeeActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button add,clear;
    EditText id,name,department,mail,salary,gender,age,date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        myDB=new DatabaseHelper(this);

        id=(EditText)findViewById(R.id.employeeid);
        name=(EditText)findViewById(R.id.name);
        department=(EditText)findViewById(R.id.department);
        mail=(EditText)findViewById(R.id.email);
        salary=(EditText)findViewById(R.id.salary);
        gender=(EditText)findViewById(R.id.gender);
        age=(EditText)findViewById(R.id.age);
        date=(EditText)findViewById(R.id.date);
        add=(Button) findViewById(R.id.add);
        clear=(Button) findViewById(R.id.clear);

        AddData();
        ClearData();
    }

    public void AddData(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isinserted =myDB.insertData(id.getText().toString(),name.getText().toString(),department.getText().toString(),mail.getText().toString(),Float.parseFloat(salary.getText().toString()),gender.getText().toString(),Integer.parseInt(age.getText().toString()),date.getText().toString());
                if(isinserted==true){
                    Toast.makeText(AddEmployeeActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    id.setText("");
                    name.setText("");
                    department.setText("");
                    mail.setText("");
                    salary.setText("");
                    gender.setText("");
                    age.setText("");
                    date.setText("");
                }else {
                    Toast.makeText(AddEmployeeActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void ClearData(){
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id.setText("");
                name.setText("");
                department.setText("");
                mail.setText("");
                salary.setText("");
                gender.setText("");
                age.setText("");
                date.setText("");
            }
        });
    }
}
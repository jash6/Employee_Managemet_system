package com.example.employeemanagementsystem4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.addemployee);
        btn2=(Button)findViewById(R.id.info);
        btn3=(Button)findViewById(R.id.update);
        btn4=(Button)findViewById(R.id.delete);
        AddEmployee();
        EmployeeInfo();
        UpdateInfo();
        DeleteInfo();
    }
    public void AddEmployee(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddEmployeeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void EmployeeInfo(){
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,EmployeeInfoActivity.class);
                startActivity(i);
            }
        });
    }

    public void UpdateInfo(){
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,UpdateEmployeeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void DeleteInfo(){
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DeleteEmployeeActivity.class);
                startActivity(intent);
            }
        });
    }
}
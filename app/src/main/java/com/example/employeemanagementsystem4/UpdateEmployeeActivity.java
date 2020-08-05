package com.example.employeemanagementsystem4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEmployeeActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button update,clear2;
    EditText id2,name2,department2,mail2,salary2,gender2,age2,date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);

        myDB=new DatabaseHelper(this);

        id2=(EditText)findViewById(R.id.employeeid2);
        name2=(EditText)findViewById(R.id.name2);
        department2=(EditText)findViewById(R.id.department2);
        mail2=(EditText)findViewById(R.id.email2);
        salary2=(EditText)findViewById(R.id.salary2);
        gender2=(EditText)findViewById(R.id.gender2);
        age2=(EditText)findViewById(R.id.age2);
        date2=(EditText)findViewById(R.id.date2);
        update=(Button) findViewById(R.id.update);
        clear2=(Button) findViewById(R.id.clear2);

        ClearData2();
        Ud();
    }

    public void Ud(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData();
            }
        });
    }

    public void UpdateData(){
        boolean isupdated=myDB.updateData(id2.getText().toString(),name2.getText().toString(),department2.getText().toString(),mail2.getText().toString(),Float.parseFloat(salary2.getText().toString()),gender2.getText().toString(),Integer.parseInt(age2.getText().toString()),date2.getText().toString());

        if(isupdated==true){
            Toast.makeText(UpdateEmployeeActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
            id2.setText("");
            name2.setText("");
            department2.setText("");
            mail2.setText("");
            salary2.setText("");
            gender2.setText("");
            age2.setText("");
            date2.setText("");
        }else {
            Toast.makeText(UpdateEmployeeActivity.this,"Data Not Updated",Toast.LENGTH_LONG).show();
        }
    }


    public void ClearData2(){
        clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id2.setText("");
                name2.setText("");
                department2.setText("");
                mail2.setText("");
                salary2.setText("");
                gender2.setText("");
                age2.setText("");
                date2.setText("");
            }
        });
    }
}
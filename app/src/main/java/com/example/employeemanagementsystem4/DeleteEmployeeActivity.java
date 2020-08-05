package com.example.employeemanagementsystem4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteEmployeeActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button delete;
    EditText id3,name3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee);
        myDB=new DatabaseHelper(this);

        id3=(EditText)findViewById(R.id.employeeid3);
        name3=(EditText)findViewById(R.id.name3);
        delete=(Button)findViewById(R.id.delete);

        DeleteData();
    }

    public void DeleteData(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRows=myDB.deleteData(id3.getText().toString());
                if(deleteRows!=0){
                    Toast.makeText(DeleteEmployeeActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                    id3.setText("");
                    name3.setText("");
                }else{
                    Toast.makeText(DeleteEmployeeActivity.this,"Data Not Deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;

public class StudentAddActivity extends AppCompatActivity {

    Button cancel_Btn , save_Btn;
    EditText nameEt, idEt, phoneEt, addressEt;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);

        //Get the reference of the buttons
        cancel_Btn = findViewById(R.id.std_add_cancel_btn);
        save_Btn = findViewById(R.id.std_add_save_btn);

        //Get the reference of the EditTexts.
        nameEt = findViewById(R.id.std_add_name_inp);
        idEt = findViewById(R.id.std_add_id_inp);
        phoneEt = findViewById(R.id.std_add_phone_inp);
        addressEt = findViewById(R.id.std_add_address_inp);
        cb = findViewById(R.id.std_add_check_input);

        cancel_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel_click();
            }
        });

        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_click();
            }
        });
    }

    private void cancel_click(){
        finish();
    }

    private void save_click(){
        String id = idEt.getText().toString();

        if(Model.instance.existStudent(id) == false && !id.isEmpty())
        {
            Student student = new Student(nameEt.getText().toString(), id, phoneEt.getText().toString(),
                                          addressEt.getText().toString() , cb.isChecked());
            Model.instance.addStudent(student);
            finish();

            Toast.makeText(getApplicationContext(),"The student successfully added",Toast.LENGTH_LONG).show();

        } else{
            if (Model.instance.existStudent(id) == true){
                Toast.makeText(getApplicationContext(),"The student already exist",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),"Invalid input",Toast.LENGTH_LONG).show();
            }


        }
    }
}
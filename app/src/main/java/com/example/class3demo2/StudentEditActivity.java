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

public class StudentEditActivity extends AppCompatActivity {

    List<Student> data;
    Button save_Btn , cancel_Btn , delete_Btn;
    EditText nameEt, idEt, phoneEt, addressEt;
    CheckBox cb;
    int position;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);

        //Get the reference of the buttons.
        save_Btn = findViewById(R.id.std_edit_save_btn);
        cancel_Btn = findViewById(R.id.std_edit_cancel_btn);
        delete_Btn = findViewById(R.id.std_edit_delete_btn);

        //Get the reference of the EditTexts.
        nameEt = findViewById(R.id.std_edit_name_inp);
        idEt = findViewById(R.id.std_edit_id_inp);
        phoneEt = findViewById(R.id.std_edit_phone_inp);
        addressEt = findViewById(R.id.std_edit_address_inp);
        cb = findViewById(R.id.std_edit_check_input);

        //Get Model.
        data = Model.instance.getAllStudents();

        //Get data from first activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = Integer.parseInt(extras.getString("student_id"));
        }

        student = Model.instance.getStudentById(""+position);
        nameEt.setText(student.getName());
        idEt.setText(student.getId());
        phoneEt.setText(student.getPhone());
        addressEt.setText(student.getAddress());
        cb.setChecked(student.isFlag());


        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveBtn();
            }
        });

        cancel_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CancelBtn();
            }
        });

        delete_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Delete_Btn();
            }
        });
    }

    private void SaveBtn(){
        student.setName(nameEt.getText().toString());
        student.setId(idEt.getText().toString());
        student.setPhone(phoneEt.getText().toString());
        student.setAddress(addressEt.getText().toString());
        student.setFlag(cb.isChecked());
//            Student new_student = new Student(nameEt.getText().toString(), idEt.getText().toString(),
//                    phoneEt.getText().toString(), addressEt.getText().toString() , cb.isChecked());
//            Model.instance.deleteStudent(student);
//            Model.instance.addStudent(new_student);
            finish();

            Toast.makeText(getApplicationContext(),"The student successfully edited",Toast.LENGTH_LONG).show();

    }
    private void CancelBtn(){
        finish();
    }
    private void Delete_Btn(){

            Model.instance.deleteStudent(student);
            finish();

            Toast.makeText(getApplicationContext(),"The student successfully removed",Toast.LENGTH_LONG).show();

    }
}
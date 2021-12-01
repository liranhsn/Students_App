package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {

    List<Student> data;
    EditText nameEt, idEt, phoneEt, addressEt;
    CheckBox cb;
    Button edit_Btn;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        //Get data from first activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = Integer.parseInt(extras.getString("student_id"));
        }


        //Get the reference of the EditTexts.
        nameEt = findViewById(R.id.std_det_name_inp);
        idEt = findViewById(R.id.std_det_id_inp);
        phoneEt = findViewById(R.id.std_det_phone_inp);
        addressEt = findViewById(R.id.std_det_address_inp);
        cb = findViewById(R.id.std_det_check_input);
        edit_Btn = findViewById(R.id.std_det_edit_btn);

//        Student student = data.get(position);
//        nameEt.setText(student.getName());
//        idEt.setText(student.getId());
//        phoneEt.setText(student.getPhone());
//        addressEt.setText(student.getAddress());
//        cb.setChecked(student.isFlag());


        //Edit button Clicked.
        edit_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditMode();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Student student = Model.instance.getStudentById(""+position);
        if (student == null) {
            finish();
        } else {
            nameEt.setText(student.getName());
            idEt.setText(student.getId());
            phoneEt.setText(student.getPhone());
            addressEt.setText(student.getAddress());
            cb.setChecked(student.isFlag());
        }
    }

    private void EditMode() {
        Intent intent = new Intent(this, StudentEditActivity.class);
        intent.putExtra("student_id",""+position);
        startActivity(intent);
    }
}
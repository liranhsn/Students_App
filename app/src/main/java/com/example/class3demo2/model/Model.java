package com.example.class3demo2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        for(int i=0;i<10;i++){
            Student s = new Student("name",""+i,"0524258836", "Julis" , false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student){
        data.add(student);
    }

    public void deleteStudent(Student student){
        data.remove(student);
    }

    public boolean existStudent(String id){
        boolean contains = false;
        for (Student elem : data) {
            if (elem.getId().equals(id)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public Student getStudentById(String id){
        for (Student elem : data) {
            if (elem.getId().equals(id)) {
                return elem;
            }
        }
        return null;
    }
    public void removeStudentById(String id){
        for (Student elem : data) {
            if (elem.getId().equals(id)) {
                data.remove(elem);
            }
        }
    }
}

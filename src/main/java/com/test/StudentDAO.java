package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAO {
    private static StudentDAO instance;
    private final List<Student> studentList = new ArrayList<>();

    private StudentDAO() {}

    public Student add(String name) {
        int id = studentList.isEmpty() ? 1 : studentList.get(studentList.size() - 1).getId() + 1;
        Student student = new Student(id, name);
        studentList.add(student);

        return student;
    }

    public Student get(final int id) {
        return studentList.stream().filter(student -> id == student.getId()).findFirst().orElse(null);
    }

    public void remove(int id) {
    }

    public List<Student> getAll() {
        return studentList;
    }

    public static StudentDAO getInstance() {
        if (instance == null)
            instance = new StudentDAO();

        return instance;
    }
}

package main.student;

import java.util.ArrayList;
import java.util.List;

public class StudentFilter {
    public List<Student> filter() {

        StudentRepository studentRepository = new StudentRepository();
        List<Student> allStudents = studentRepository.listAll();

        List<Student> filtered = new ArrayList<>();

        for(Student student : allStudents) {
            if(student.getCgpa() >= 3.5f)
                filtered.add(student);
        }
        return filtered;

    }
}

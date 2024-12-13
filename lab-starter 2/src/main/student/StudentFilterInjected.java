package main.student;

import java.util.ArrayList;
import java.util.List;

public class StudentFilterInjected {
    private final StudentRepository studentRepository;
    public StudentFilterInjected(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> filter() {
        List<Student> allStudents = studentRepository.listAll();

        List<Student> filtered = new ArrayList<>();

        for(Student student : allStudents) {
            if(student.getCgpa() >= 3.5f)
                filtered.add(student);
        }
        return filtered;

    }
}

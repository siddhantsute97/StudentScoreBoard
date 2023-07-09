package com.deepwork.ScoreBoard.service;

import com.deepwork.ScoreBoard.model.Student;
import com.deepwork.ScoreBoard.model.Subject;
import com.deepwork.ScoreBoard.repository.ScoreRepository;
import com.deepwork.ScoreBoard.repository.StudentSubjectRepository;
import com.deepwork.ScoreBoard.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public Student addStudent(Student s) {
        return repository.save(s);
    }

    public List<Object[]> getSubjectMarksForStudent(int studentId) {
        return studentSubjectRepository.getSubjectMarksForStudent(studentId);
    }

    public Subject addSubjectMarksForStudent(int studentId, String subjectName, int marks) {
        // Find the student by studentId
        Student student = repository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid studentId"));

        // Create a new Subject object
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subject.setMarks(marks);

        // Add the subject to the student's subjectList
        student.addSubject(subject);

        // Save the student to update the association between student and subject
        repository.save(student);

        // Return the subject object
        return subject;
    }

    public List<Object[]> getStudentsWithAverageMarksGreaterThan60() {
        return repository.findStudentsWithAverageMarksGreaterThan60();
    }

}

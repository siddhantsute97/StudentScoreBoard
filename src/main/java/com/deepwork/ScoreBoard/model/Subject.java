package com.deepwork.ScoreBoard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subjectId;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "marks")
    private int marks;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "subject_ref"),
            inverseJoinColumns = @JoinColumn(name = "student_ref")
    )
    private List<Student> studentList;

    public void addStudent(Student studentRef) {
        if (studentList == null) {
            studentList = new LinkedList<>();
        }
        studentList.add(studentRef);
    }

}
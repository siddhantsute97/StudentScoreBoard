package com.deepwork.ScoreBoard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "parent_name")
    private String parentName;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "phone")
    private long phone;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_ref"),
            inverseJoinColumns = @JoinColumn(name = "subject_ref")
    )
    private List<Subject> subjectList;

    public void addSubject(Subject subjectRef) {
        if (subjectList == null) {
            subjectList = new LinkedList<>();
        }
        subjectList.add(subjectRef);
    }

    public void setDob(String dobString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dob = LocalDate.parse(dobString, formatter);
    }

    public String getDobString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.dob.format(formatter);
    }

    public void setAverageScore(int averageScore) {
    }
}
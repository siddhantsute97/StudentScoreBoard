package com.deepwork.ScoreBoard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "student_subject")
@IdClass(Relationship.class)
public class StudentSubject implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_ref")
    private Student studentRef;

    @Id
    @ManyToOne
    @JoinColumn(name = "subject_ref")
    private Subject subjectRef;
}


package com.deepwork.ScoreBoard.repository;

import com.deepwork.ScoreBoard.model.Student;
import com.deepwork.ScoreBoard.model.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {

    @Query("SELECT ss.subjectRef.subjectName, ss.subjectRef.marks FROM StudentSubject ss WHERE ss.studentRef.studentId = :studentId")
    List<Object[]> getSubjectMarksForStudent(@Param("studentId") int studentId);

   // @Query("SELECT s FROM Student s JOIN s.subjects ss JOIN ss.subject subj GROUP BY s.id, s.firstName, s.lastName HAVING AVG(subj.marks) > 60")
   // List<Student> findStudentsWithAverageMarksGreaterThan60();

}

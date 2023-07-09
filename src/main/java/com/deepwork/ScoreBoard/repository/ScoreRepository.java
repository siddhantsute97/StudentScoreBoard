package com.deepwork.ScoreBoard.repository;

import com.deepwork.ScoreBoard.model.Student;
import com.deepwork.ScoreBoard.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Student,Integer> {

  //  @Query("SELECT s FROM Student s JOIN s.subjects ss JOIN ss.subject subj GROUP BY s.studentId, s.firstName, s.lastName HAVING AVG(subj.marks) > 60")
  //  List<Student> findStudentsWithAverageMarksGreaterThan60();
 // @Query("SELECT s.studentId, s.firstName, s.lastName, AVG(subj.marks) AS averageMarks FROM Student s JOIN s.subjects ss JOIN ss.subject subj GROUP BY s.studentId, s.firstName, s.lastName HAVING AVG(subj.marks) > 60")
 // List<Object[]> findStudentsWithAverageMarksGreaterThan60();

  @Query("SELECT s.studentId, s.fName, s.lName, AVG(subj.marks) AS averageMarks FROM Student s JOIN s.subjectList subj GROUP BY s.studentId, s.fName, s.lName HAVING AVG(subj.marks) > 60")
  List<Object[]> findStudentsWithAverageMarksGreaterThan60();




}

package com.example.testsPostgres.model;

import jakarta.persistence.*;

@Entity(name="student_answer")
public class StudentAnswer {
    @Id
    @Column(name="row_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowID;
    @Column(name="test_id")
    private Long testID;
    @Column(name="user_id")
    private Long userID;
    @Column(name="answer_id")
    private Long answerID;

    public StudentAnswer() {
    }

    public StudentAnswer(Long rowID, Long testID, Long userID, Long answerID) {
        this.rowID = rowID;
        this.testID = testID;
        this.userID = userID;
        this.answerID = answerID;
    }

    public Long getRowID() {
        return rowID;
    }

    public void setRowID(Long rowID) {
        this.rowID = rowID;
    }

    public Long getTestID() {
        return testID;
    }

    public void setTestID(Long testID) {
        this.testID = testID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }
}

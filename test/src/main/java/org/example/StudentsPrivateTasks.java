package org.example;

import java.util.List;

public class StudentsPrivateTasks extends Student{
    private String nameTasks;
    private List<Integer> ballStudent;

    public StudentsPrivateTasks() {
    }

    public StudentsPrivateTasks(List<Integer> ballStudent) {
        this.ballStudent = ballStudent;
    }

    public void setNameTasks(String newNameTasks) {
        this.nameTasks = newNameTasks;
    }

    public void setBallStudent(List<Integer> newBallStudent) {
        this.ballStudent = newBallStudent;
    }

    public String getNameTasks() {
        return nameTasks;
    }

    public List<Integer> getBallStudent() {
        return ballStudent;
    }
}

package org.example;

public class Student extends Human{
    private String trainingCourse;
    private String team;
    private String solvedTasks;
    private StudentsPrivateTasks tasks;
    private Human human;

    public Student() {
    }

    public Student(Human human, StudentsPrivateTasks tasks) {
        this.human = human;
        this.tasks = tasks;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public void setTasks(StudentsPrivateTasks tasks) {
        this.tasks = tasks;
    }

    public void setTrainingCourse(String newTrainingCourse) {
        this.trainingCourse = newTrainingCourse;
    }

    public void setTeam(String newTeam) {
        this.team = newTeam;
    }

    public void replaceTeam(String newTeam) {
        this.team = newTeam;
    }

    public void setSolvedTasks(String newSolvedTasks) {
        this.solvedTasks = newSolvedTasks;
    }

    public String getTrainingCourse() {
        return trainingCourse;
    }

    public String getTeam() {
        return team;
    }

    public String getSolvedTasks() {
        return solvedTasks;
    }

    public Human human() {
        return human;
    }

    public StudentsPrivateTasks tasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return human + " Ball:" + tasks.getBallStudent();
    }
}

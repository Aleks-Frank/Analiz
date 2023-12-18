package org.example;

public class Tasks {
    private String TaskName;
    private int maxBall;

    public Tasks() {
    }

    public Tasks(String TaskName, int maxBall) {
        this.TaskName = TaskName;
        this.maxBall = maxBall;
    }

    public int getMaxBall() {
        return maxBall;
    }

    public String getTasksName() {
        return TaskName;
    }
}
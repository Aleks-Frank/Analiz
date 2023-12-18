package org.example;

import org.example.DB.DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SCVReader {

    private void csvReaderMethod(String filePath) {

        List<Human> humans = new ArrayList<>();
        List<Tasks> tasks = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));

            scanner.nextLine();

            String tasksLine = scanner.nextLine();
            String[] taskNames = tasksLine.split(";");


            String scoresLine = scanner.nextLine();
            String[] scores = scoresLine.split(";");

            for (int i = 2; i < taskNames.length; i++) {
                String taskName = taskNames[i];
                int maxBall = Integer.parseInt(scores[i]);

                Tasks task = new Tasks(taskName, maxBall);
                tasks.add(task);
            }

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");

                String name = values[0];

                Human human = new Human(name);
                List<Integer> scoresTasks = new ArrayList<>();
                for (int i = 2; i < values.length; i++) {
                    scoresTasks.add(Integer.parseInt(values[i]));
                }
                StudentsPrivateTasks studentTasks = new StudentsPrivateTasks(scoresTasks);

                Student student = new Student(human, studentTasks);

                humans.add(human);

                students.add(student);

            }


            for (Human human : humans) {
                System.out.println(human.getName());
            }

            for (Tasks task : tasks) {
                System.out.println("Task: " + task.getTasksName() + ", Max Score: " + task.getMaxBall());
            }

            for (Student student : students){
                System.out.println(student);
            }

            scanner.close();

        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

        DataBase.connect();
        DataBase.CreateTableStudent();
        DataBase.saveStudent(humans);
    }


    public static void main(String[] arg){
        String filePath = new File("").getAbsolutePath() + File.separator + "/src/file/file.csv";

        SCVReader csvObj = new SCVReader();
        csvObj.csvReaderMethod(filePath);
    }
}
package org.example.DB;

import org.example.Human;

import java.sql.*;
import java.util.List;

public class DataBase {
    private static Connection conn = null;
    private static final String Url = "jdbc:sqlite:D:/db/Analiz.db";

    public static void connect(){
        try{
            conn = DriverManager.getConnection(Url);
            System.out.println("+");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void CreateTableStudent(){
        String sql = "CREATE TABLE IF NOT EXISTS student (\n"
                + "id_stud integer PRIMARY KEY, \n"
                + "name text NOT NULL \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(Url);  Statement stat = conn.createStatement()){
            stat.execute(sql);
            System.out.println("+");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveStudent(List<Human> humans){
        String sql = "INSERT INTO student(name) VALUES(?)";

        for (var human : humans){
            try(Connection conn = DriverManager.getConnection(Url);
                PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, human.getName());
                ps.executeUpdate();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

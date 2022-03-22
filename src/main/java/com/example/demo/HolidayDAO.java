package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HolidayDAO {
    public List getAll(){
        List<Holiday>holidays=new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection
                    ("jdbc:sqlite:C:\\Users\\naama\\Calender.db");//db db3 sql sql3
            System.out.println("Done!!");
            Statement stm = connection.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM Holidays");
            while (result.next()) {
               holidays.add(new Holiday(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("day"),
                        result.getInt("month"),
                        result.getInt("length")));
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return holidays;
    }

    public Holiday get(int id){
        Holiday holidays=null;
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection
                    ("jdbc:sqlite:C:\\Users\\naama\\Calender.db");//db db3 sql sql3
            System.out.println("Done!!");
            Statement stm = connection.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM Holidays where id="+id);
            while (result.next()) {
                holidays= new Holiday(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("day"),
                        result.getInt("month"),
                        result.getInt("length"));
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return holidays;
    }

    public boolean remove(Holiday holiday){
        Holiday holidays=null;
        var flag=0;
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection
                    ("jdbc:sqlite:C:\\Users\\naama\\Calender.db");//db db3 sql sql3
            System.out.println("Done!!");
            Statement stm = connection.createStatement();

            flag = stm.executeUpdate("delete FROM Holidays where id="+holiday.id);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (flag==1)?true:false;
    }

    public boolean update(Holiday holiday){
        Holiday holidays=null;
        var flag=0;
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection
                    ("jdbc:sqlite:C:\\Users\\naama\\Calender.db");//db db3 sql sql3
            System.out.println("Done!!");
            Statement stm = connection.createStatement();

            flag = stm.executeUpdate("UPDATE Holidays SET id= "+holiday.id+",name=\'"+ holiday.name+"\',day=" +holiday.day
                    +",month="+holiday.month+",length="+holiday.length+
                    " where id="+holiday.id);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (flag==1)?true:false;
    }

    public boolean add(Holiday holiday){
        Holiday holidays=null;
        var flag=0;
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection
                    ("jdbc:sqlite:C:\\Users\\naama\\Calender.db");//db db3 sql sql3
            System.out.println("Done!!");
            Statement stm = connection.createStatement();

            flag = stm.executeUpdate("insert into Holidays (name,day,month,length) " +
                    "values (\'"+holiday.name+"\',"+holiday.day+","+holiday.month+","+holiday.length+")");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (flag==1)?true:false;
    }
}

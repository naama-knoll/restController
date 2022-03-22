package com.example.demo;

public class Holiday {
    public int id;
    public String name;
    public int day;
    public int month;
    public int length;

    public Holiday(int id, String name, int day, int month, int length) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", length=" + length +
                '}';
    }
}

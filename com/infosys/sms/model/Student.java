package com.infosys.sms.model;

public class Student {
    private int id;
    private String name;
    private int score;
    private String department;

    public Student(int id, String name, int score, String department) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getDepartment() { return department; }

    
    public void setId(int id) { this.id=id;}
    public void setName(String name) { this.name = name; }
    public void setScore(int score) { this.score = score; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Score: %d | Dept: %s", id, name, score, department);
    }
}


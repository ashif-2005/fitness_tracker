package com.example.fit;

public class student {
    private String name;
    private String dept;
    private String year;

    public student(String name, String dept, String year) {
        this.name = name;
        this.dept = dept;
        this.year = year;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

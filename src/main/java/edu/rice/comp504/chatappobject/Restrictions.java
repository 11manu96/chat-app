package edu.rice.comp504.chatappobject;

public class Restrictions {
    private String location;
    private String school;
    private int age;
    public Restrictions(String location, String school, int age) {
        this.location = location;
        this.school = school;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}

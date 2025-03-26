package models;

public abstract class Patient {
    protected String name;
    protected int age;
    protected String gender;
    protected String condition;
    protected HospitalBlock location;

    public Patient(String name, int age, String gender, String condition, HospitalBlock location) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.condition = condition;
        this.location = location;
    }

    public abstract void displayInfo();
    public abstract double calculateBill();

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getCondition() { return condition; }
    public HospitalBlock getLocation() { return location; }
}
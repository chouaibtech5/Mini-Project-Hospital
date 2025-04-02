package models;

public abstract class Patient {
    protected String name;
    protected int age;
    protected String gender;
 
    protected HospitalBlock location;

    public Patient(String name, int age, String gender, HospitalBlock location ) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
       
    }

    public abstract void displayInfo();
    public abstract double calculateBill();

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }   
    public HospitalBlock getLocation() { return location; }
    public double getbill(){ return calculateBill() ; }
}
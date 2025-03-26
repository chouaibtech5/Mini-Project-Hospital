package models;

public class Inpatient extends Patient {
    private String roomNumber;
    private String admissionDate;
    private double dailyCharge;
    private int numberOfDaysAdmitted;

    public Inpatient(String name, int age, String gender, String condition, 
                   HospitalBlock location, String roomNumber, 
                   String admissionDate, double dailyCharge, int numberOfDaysAdmitted) {
        super(name, age, gender, condition, location);
        this.roomNumber = roomNumber;
        this.admissionDate = admissionDate;
        this.dailyCharge = dailyCharge;
        this.numberOfDaysAdmitted = numberOfDaysAdmitted;
    }

    @Override
    public void displayInfo() {
        System.out.println("Inpatient: " + getName() + 
                         ", Room: " + roomNumber + 
                         ", Admitted: " + admissionDate);
    }

    @Override
    public double calculateBill() {
        return dailyCharge * numberOfDaysAdmitted;
    }
}
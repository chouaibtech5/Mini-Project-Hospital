package models;

public class Outpatient extends Patient {
    private String appointmentDate;
    private double consultationFee;

    public Outpatient(String name, int age, String gender,
                     HospitalBlock location, String appointmentDate, double consultationFee) {
        super(name, age, gender, location  );
        this.appointmentDate = appointmentDate;
        this.consultationFee = consultationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("Outpatient: " + getName() + 
                         ", Appointment: " + appointmentDate);
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}
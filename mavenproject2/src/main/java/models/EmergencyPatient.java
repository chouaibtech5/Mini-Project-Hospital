package models;

public class EmergencyPatient extends Patient {
    private String severityLevel;
    private double emergencyTreatmentCost;

    public EmergencyPatient(String name, int age, String gender, String condition,
                          HospitalBlock location, String severityLevel, double emergencyTreatmentCost) {
        super(name, age, gender, condition, location);
        this.severityLevel = severityLevel;
        this.emergencyTreatmentCost = emergencyTreatmentCost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Emergency Patient: " + getName() + 
                         ", Severity: " + severityLevel);
    }

    @Override
    public double calculateBill() {
        return emergencyTreatmentCost;
    }
}
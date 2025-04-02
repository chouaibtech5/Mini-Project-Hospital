package models;

public class EmergencyPatient extends Patient {
    private String severityLevel;
    private double emergencyTreatmentCost;
    private double AdditionalCharges ; 

    public EmergencyPatient(String name, int age, String gender, 
                          HospitalBlock location, String severityLevel, double emergencyTreatmentCost , double AdditionalCharges ) {
        super(name, age, gender, location);
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
        return emergencyTreatmentCost + AdditionalCharges ;  
    }
}
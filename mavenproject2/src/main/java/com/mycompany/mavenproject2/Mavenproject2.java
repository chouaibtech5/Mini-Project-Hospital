package com.mycompany.mavenproject2;

import models.*;

public class Mavenproject2 {
    public static void main(String[] args) {
        // Initialize hospital with correct parameters
        Hospital hospital = new Hospital("General Hospital", 500, "New York");
        
        // Create blocks with correct parameters
        HospitalBlock cardioBlock = new HospitalBlock("A", 1, "Cardiology");
        HospitalBlock pediatricBlock = new HospitalBlock("B", 2, "Pediatrics");
        
        hospital.addBlock(cardioBlock);
        hospital.addBlock(pediatricBlock);
        
        // Create patients with correct parameters
        Inpatient inpatient = new Inpatient(
            "Alice Smith", 50, "Female", "Fever", cardioBlock, 
            "A101", "2025-05-01", 300.0, 3
        );
        
        Outpatient outpatient = new Outpatient(
            "Bob Johnson", 35, "Male", "Checkup", pediatricBlock,
            "2025-05-02", 120.0
        );
        
        EmergencyPatient emergencyPatient = new EmergencyPatient(
            "Chris Lee", 27, "Male", "Accident", pediatricBlock,
            "High", 700.0
        );
    }
}
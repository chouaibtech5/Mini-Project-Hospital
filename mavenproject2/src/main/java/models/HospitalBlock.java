package models;

public class HospitalBlock {
    private String blockName;
    private int floorNumber;
    private String specialty;

    public HospitalBlock(String blockName, int floorNumber, String specialty) {
        this.blockName = blockName;
        this.floorNumber = floorNumber;
        this.specialty = specialty;
    }

    public String getBlockName() {
        return blockName;
    }
}
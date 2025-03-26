package models;

import java.util.ArrayList;

public class Hospital {
    private String name;
    private int maxPatients;
    private String state;
    private ArrayList<HospitalBlock> blocks;

    public Hospital(String name, int maxPatients, String state) {
        this.name = name;
        this.maxPatients = maxPatients;
        this.state = state;
        this.blocks = new ArrayList<>(); // Initialize blocks list
    }

    // Add these methods if they don't exist
    public void addBlock(HospitalBlock block) {
        blocks.add(block);
    }

    public ArrayList<HospitalBlock> getBlocks() {
        return blocks;
    }

    // Other getters
    public String getName() {
        return name;
    }

    public int getMaxPatients() {
        return maxPatients;
    }

    public String getState() {
        return state;
    }
}
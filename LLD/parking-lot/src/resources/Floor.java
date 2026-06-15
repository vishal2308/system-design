package resources;

import strategy.allocation.SpotAllocation;


public class Floor {
    private final int id;
    private SpotAllocation spotAllocation;

    public Floor(int id, SpotAllocation spotAllocation) {
        this.id = id;
        this.spotAllocation = spotAllocation;
    }
    public int getId() {
        return id;
    }
    public SpotAllocation getSpotAllocation() {
        return spotAllocation;
    }
}
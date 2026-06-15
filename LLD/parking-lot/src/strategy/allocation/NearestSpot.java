package strategy.allocation;


import exceptions.IllegalSpotState;
import exceptions.OutOfCapacity;
import resources.*;

import java.util.*;

public class NearestSpot implements SpotAllocation {
    private final Map<SpotType, PriorityQueue<Spot>> spotMap = new HashMap<>();

    public NearestSpot() {
        for (SpotType spotType : SpotType.values()) {
            spotMap.put(spotType,
                    new PriorityQueue<>(Comparator.comparingInt(Spot::getDistance)));
        }
    }

    @Override
    public Spot allotSpot (SpotType spotType) {
        PriorityQueue<Spot> pq = spotMap.get(spotType);
        if (pq == null || pq.isEmpty()) {
            throw new OutOfCapacity("No vacant spots for : " + spotType.toString());
        }
        Spot spot = pq.poll();
        if (spot.isOccupied()) {
            throw new IllegalSpotState("Spot already allotted");
        }
        return spot.occupy(spot);
    }

    @Override
    public void releaseOrAddSpot (Spot spot) {
        if (spot == null) {
            throw new IllegalSpotState("Spot is null");
        }
        PriorityQueue<Spot> pq = spotMap.get(spot.getType());
        if (pq == null) {
            throw  new IllegalSpotState("Illegal spot : " + spot.getType().toString());
        }
        spot.release(spot);
        pq.add(spot);
    }
}
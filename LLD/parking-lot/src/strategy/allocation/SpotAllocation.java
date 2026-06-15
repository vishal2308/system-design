package strategy.allocation;

import resources.Spot;
import resources.SpotType;

public interface SpotAllocation {
    Spot allotSpot (SpotType spotType);
    void releaseOrAddSpot (Spot spot);
}
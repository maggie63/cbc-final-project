package main.java.Simulation;
import java.util.ArrayList;
import main.java.Util.Pair;

/**
 * A tissue cell. It wants to grow, but not as much as cancer. Has a chance to turn a dead
 * cell into a live one every time step
 */

public class TissueCell extends Cell{

    /**
     * The logic object expects a constructor that takes a coordinate stored as a pair
     * See the Util folder and Pair.java to learn about the implementation of this
     * @param coords
     */
    public TissueCell(Pair coords){
        super(0, 1, coords);
    }
    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
    }

}

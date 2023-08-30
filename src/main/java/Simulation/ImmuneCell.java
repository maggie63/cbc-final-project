package main.java.Simulation;
import java.util.ArrayList;
import main.java.Util.Pair;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 */

public class ImmuneCell extends Cell{

    /**
     * The logic object expects a constructor that takes a coordinate stored as a pair
     * See the Util folder and Pair.java to learn about the implementation of this
     * @param coords
     */
    public ImmuneCell(Pair coords){
        super(3, 4, coords);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
    }

}
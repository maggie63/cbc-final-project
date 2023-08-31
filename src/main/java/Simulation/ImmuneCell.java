package main.java.Simulation;
import java.util.ArrayList;
import main.java.Util.Pair;

import static main.java.Util.Calculator.coordFromIndex;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 */

public class ImmuneCell extends Cell {

    /**
     * The logic object expects a constructor that takes a coordinate stored as a pair
     * See the Util folder and Pair.java to learn about the implementation of this
     *
     * @param coords
     */
    public ImmuneCell(Pair coords) {
        super(3, 4, coords);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
        super.interactNeighbors(neighbors);

        if (cancerCells != null && !cancerCells.isEmpty()) {
            int index = (int) (Math.random() * cancerCells.size());
            int i = cancerCells.get(index);
            neighbors.set(i, new DeadCell(coordFromIndex(i)));
            cancerCells.remove(index);

            double chance;
            for (int count = 0; count < cancerCells.size(); count++) {
                index = (int) (Math.random() * cancerCells.size());
                i = cancerCells.get(index);
                chance = Math.random() * 100;
                if (chance < 50) {
                    neighbors.set(i, new DeadCell(coordFromIndex(i)));
                    cancerCells.remove(index);
                }
            }
        }
    }
}
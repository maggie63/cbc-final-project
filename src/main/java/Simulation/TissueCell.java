package main.java.Simulation;
import java.util.ArrayList;
import main.java.Util.Pair;
import static main.java.Util.Calculator.indexFromCoord;
import static main.java.Util.Calculator.coordFromIndex;
import java.util.Random;


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
        int index, ID, chance;
        Pair Coords;
        Random random = new Random();

        for (int x = -1; x < 2; x++) {
            for(int y = -1; y <2; y++){
                Coords = new Pair(x, y);
                index = indexFromCoord(Coords);
                ID = neighbors.get(index).getID();

                if(ID == 0){
                    chance = random.nextInt(11);
                    if(chance <= 7) {neighbors.add(new TissueCell(coordFromIndex(index)));}
                }
            }
        }
    }

}

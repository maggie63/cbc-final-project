package main.java.Simulation;
import java.util.ArrayList;
import main.java.Util.Pair;

import static main.java.Util.Calculator.coordFromIndex;

/**
 *This is a cancer cell. It is the most complex cell as it can attack tissue or immune cells, or grow into a dead cell.
 * For attacking tissue, it is a 1 hit replace it with a dead cell.
 * Immune cells are cooler. Each hit from a cancer cell lowers its strength by 1. When an immune cell reaches 0 strength
 * it dies!
 *
 * It has a priority of action. If it can grow, it will grow. If it can kill a tissue cell, it will do that. Why?
 * Easiest way to grow is to kill a week tissue cell. If no other option, will attack immune cells. Path of
 * least resistance to growing basically.
 *
 * Growing means turning a dead cell into a CancerCell.
 */

public class CancerCell extends Cell{

    public CancerCell(Pair coords) {
        super(1, 3, coords);
    }
    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
        super.interactNeighbors(neighbors);
        int tissueCount = 0;
        int immuneCount = 0;
        int deadCount = 0;

        if(tissueCells != null){tissueCount = tissueCells.size();}
        if(immuneCells != null){immuneCount = immuneCells.size();}
        if(deadCells != null){deadCount = deadCells.size();}

        if (deadCount > 0) {
            for (int i : deadCells) {
                neighbors.set(i, new CancerCell(coordFromIndex(i)));
            }
        }
        else if(tissueCount > immuneCount && tissueCount >= 1) {
            int i = tissueCells.get((int) (Math.random() * tissueCells.size()));
            neighbors.set(i, new DeadCell(coordFromIndex(i)));
        }
        else {
            int strength;
            for (int i : immuneCells) {
                strength = neighbors.get(i).getStrength();
                while(strength != 0) {
                    strength = strength - 1;
                    neighbors.get(i).setStrength(strength);
                }
                neighbors.set(i, new DeadCell(coordFromIndex(i)));
            }
        }
    }
}

package main.java.Simulation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import main.java.Util.Pair;

import static main.java.Util.Calculator.indexFromCoord;

/**
 * The default, boring cell.
 */

public class Cell {
    /**
     * the simulation expects a getter that return the ID that is specifically called getID()
     * any other method call will break it. So if you name this "getCellID()" or "getId()" it won't work
     * This is why interfaces are useful
     * @return
     */

    private int strength;
    private int id;
    public Pair coords;
    private HashMap<String, Double> chemicalConcentrations;
    private HashSet<String> signalMolecules;
    private ArrayList<Cell> neighbours;
    protected ArrayList<Integer> deadCells, immuneCells, tissueCells, cancerCells;

    public Cell() {
        this(0, 0, new Pair(), new HashMap<>(), new HashSet<>(), new ArrayList<>());
    }

    public Cell(int strength, int id, Pair coords, HashMap<String, Double> chemicalConcentrations, HashSet<String> signalMolecules, ArrayList<Cell> neighbours) {
        setStrength(strength);
        setID(id);
        this.coords = coords;
        this.chemicalConcentrations = chemicalConcentrations;
        this.signalMolecules = signalMolecules;
        this.neighbours = neighbours;
    }

    public Cell(int strength, int id, Pair coords) {
        setStrength(strength);
        setID(id);
        this.coords = coords;
    }

    public void setStrength(int strength) {
        if (strength > 0) {
            this.strength = strength;
        } else {
            this.strength = 0;
        }
    }

    public int getStrength() {
        return this.strength;
    }

    public void setID(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            this.id = 0;
        }
    }

    public int getID() {
        return this.id;
    }

    public void interactNeighbors(ArrayList<Cell> neighbors) {
        int index, ID;
        Pair neighborCoords;
        deadCells = new ArrayList<>();
        immuneCells = new ArrayList<>();
        tissueCells = new ArrayList<>();
        cancerCells = new ArrayList<>();


        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {

                if(x == 0 && y == 0) {continue;}

                neighborCoords = new Pair(x + coords.getX(), y + coords.getY());
                index = indexFromCoord(neighborCoords);
                ID = neighbors.get(index).getID();

                if(ID == 0) {
                    deadCells.add(index);}
                else if(ID == 1) {
                    tissueCells.add(index);}
                else if(ID == 3) {
                    cancerCells.add(index);}
                else if(ID == 4) {
                    immuneCells.add(index);}
            }
        }
    }

}

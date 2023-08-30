package main.java.Simulation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import main.java.Util.Pair;

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
    private Pair coords;
    private HashMap<String, Double> chemicalConcentrations;
    private HashSet<String> signalMolecules;
    private ArrayList<Cell> neighbours;

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

    }

}

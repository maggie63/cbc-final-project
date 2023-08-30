package Simulation;


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
    private int x;
    private int y;
    private int id;

    private HashMap<String, Double> chemicalConcentrations;
    private HashSet<String> signalMolecules;
    private ArrayList<Cell> neighbours;

    public Cell() {
        this(0, 0, 0, 0, new HashMap<>(), new HashSet<>(), new ArrayList<>());
    }

    public Cell(int strength, int x, int y, int id, HashMap<String, Double> chemicalConcentrations, HashSet<String> signalMolecules, ArrayList<Cell> neighbours) {
        setStrength(strength);
        setX(x);
        setY(y);
        setID(id);
        this.chemicalConcentrations = chemicalConcentrations;
        this.signalMolecules = signalMolecules;
        this.neighbours = neighbours;
    }

    public Cell(int strength, int x, int y, int id) {
        setStrength(strength);
        setX(x);
        setY(y);
        setID(id);
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

    public void setX(int x) {
        if (x > 0) {
            this.x = x;
        } else {
            this.x = 0;
        }
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        if (y > 0) {
            this.y = y;
        } else {
            this.y = 0;
        }
    }

    public int getY() {
        return this.y;
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

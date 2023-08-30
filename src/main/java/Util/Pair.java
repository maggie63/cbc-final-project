/**
 *
 *
 * DONT TOUCH THIS PLEASE
 *
 *
 */

package main.java.Util;

/**
 * Another utility. It stores two ints. Useful for 2D coordinates! I left stuff public here cause it is
 * a bit silly to have getters and setters.
 */
public class Pair {
    private int x; // x pos
    private int y; //y pos

    /**
     * Constructors
     * @param x x pos
     * @param y y pos
     */
    public Pair(int x, int y){
        setX(x);
        setY(y);
    }

    /**
     * Default constructor that sets (x,y) = (0,0);
     */
    public Pair(){
        this(0,0);
    }

    /**
     * Gives x coord
     * @return x
     */
    public void setX(int x) {
        if (x > 0) {
            this.x = x;
        } else {
            this.x = 0;
        }
    }

    public int getX() {return x;}

    /**
     * give y coord
     * @return y
     */
    public void setY(int y) {
        if (y > 0) {
            this.y = y;
        } else {
            this.y = 0;
        }
    }

    public int getY() {
        return y;
    }

}

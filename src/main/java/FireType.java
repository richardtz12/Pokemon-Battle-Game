/**
 * A fire type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class FireType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of this Fire type
     * @param y The Y position of this Fire type
     * @param bounds The bounding Rectangle
     */
    public FireType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);

    }


    private int finspeed = getSpeed() * 2;
    @Override
    public void move() {
        super.move();
        if (getXPos() > getBounds().getWidth() / 2
            && getYPos() < getBounds().getHeight() / 2) {
            setSpeed(finspeed);
        } else {
            setSpeed(finspeed / 2);
        }
    }


    @Override
    public boolean canHarmPokemon(Pokemon other) {
        int chance = getRand().nextInt(8);
        if (other instanceof WaterType) {
            if (chance > 5) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (chance > 1) {
                return true;
            }
        } else {
            if (chance > 3) {
                return true;
            }
        }
        return false;
    }
}

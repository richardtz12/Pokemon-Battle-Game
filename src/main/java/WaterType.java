/**
 * A water type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class WaterType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of this Water Type Pokemon
     * @param y The Y position of this Water Type Pokemon
     * @param bounds The bounding Rectangle
     */
    public WaterType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public void move() {
        super.move();
        if (getXPos() < getBounds().getWidth() / 2
            && getYPos() > getBounds().getHeight() / 2) {
            setLevel(getLevel() + 6);
        }

    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        int chance = getRand().nextInt(8);
        if (other instanceof FireType) {
            if (chance > 1) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (chance > 5) {
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

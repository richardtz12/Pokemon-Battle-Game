/**
 * A grass type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class DragonType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public DragonType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }
    @Override
    public void move() {
        super.move();
        if (getXPos() > getBounds().getWidth() / 2
            && getYPos() > getBounds().getHeight() / 2) {
            setHealth(getHealth() + 2);
            setLevel(getLevel() + 2);
        }
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        int chance = getRand().nextInt(8);
        if (other instanceof WaterType) {
            if (chance > 3) {
                return true;
            }
        } else if (other instanceof FireType) {
            if (chance > 3) {
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

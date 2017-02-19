import java.awt.Rectangle;

public class Torterra extends GrassType {

    /**
     * Constructor
     * @param x The X position of Torterra
     * @param y The Y position of Torterra
     * @param bounds The bounding Rectangle
     */
    public Torterra(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/torterra.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof GrassType) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (canReproduceWithPokemon(other) && getChildren() < 2
            && other.getChildren() < 2 && getRand().nextInt(10) > 7) {
            setChildren(getChildren() + 1);
            other.setChildren(getChildren() + 1);
            return new Torterra(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 160) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        int chance = getRand().nextInt(8);
        if (other instanceof FireType && getRand().nextInt(100) > 64) {
            return true;
        }
        if (other instanceof Poliwhirl && getRand().nextInt(100) > 29) {
            return true;
        } else if (other instanceof WaterType
            && !(other instanceof Poliwhirl)) {
            if (chance > 1) {
                return true;
            }
        } else if (other instanceof FireType || other instanceof Poliwhirl) {
            return false;
        } else {
            if (chance > 3) {
                return true;
            }
        }
        return false;
    }
}

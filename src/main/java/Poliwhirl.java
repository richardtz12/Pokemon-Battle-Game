import java.awt.Rectangle;

public class Poliwhirl extends WaterType {

    /**
     * Constructor
     * @param x The X position of Poliwhirl
     * @param y The Y position of Poliwhirl
     * @param bounds The bounding Rectangle
     */
    public Poliwhirl(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/poliwhirl.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof Poliwhirl) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (canReproduceWithPokemon(other) && getChildren() < 2
            && other.getChildren() < 2 && getRand().nextInt(8) >= 5) {
            setChildren(getChildren() + 1);
            other.setChildren(getChildren() + 1);
            return new Poliwhirl(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 200) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof Poliwhirl && getRand().nextInt(100) > 61) {
            return true;
        } else if (other instanceof Poliwhirl) {
            return false;
        } else {
            super.canHarmPokemon(other);
            return false;
        }
    }
}

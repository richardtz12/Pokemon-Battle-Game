import java.awt.Rectangle;

public class Blaziken extends FireType {

    /**
     * Constructor
     * @param x The X position of Blaziken
     * @param y The Y position of Blaziken
     * @param bounds The bounding Rectangle
     */
    public Blaziken(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/blaziken.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof Blaziken) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (canReproduceWithPokemon(other) && getChildren() < 2
            && other.getChildren() < 2 && getRand().nextInt(8) >= 4) {
            setChildren(getChildren() + 1);
            other.setChildren(getChildren() + 1);
            return new Blaziken(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 180) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof FireType && getLevel() > other.getLevel()
            && getRand().nextInt(10) > 0) {
            return true;
        } else if (other instanceof FireType && getLevel() <= other.getLevel()
            && getRand().nextInt(100) > 87) {
            return true;
        } else if (other instanceof FireType) {
            return false;
        } else {
            super.canHarmPokemon(other);
            return false;
        }
    }
}

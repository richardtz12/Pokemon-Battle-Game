import java.awt.Rectangle;

public class Zekrom extends DragonType {

    /**
     * Constructor
     * @param x The X position of Zekrom
     * @param y The Y position of Zekrom
     * @param bounds The bounding Rectangle
     */
    public Zekrom(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/Zekrom.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {
        if (other instanceof Zekrom) {
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
            return new Zekrom(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 170) {
            return true;
        }
        return false;
    }

}

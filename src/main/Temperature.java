import be.kuleuven.cs.som.annotate.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class for temperature.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class Temperature {

    /** The hotness between 0 and MAX_HOTNESS. */
    private int hotness;

    /** The coldness between 0 and MAX_COLDNESS. */
    private int coldness;

    /** The maximum hotness allowed. */
    private final int MAX_HOTNESS=1000;

    /** The maximum coldness allowed. */
    private final int MAX_COLDNESS=1000;

    /** The minimum hotness allowed. */
    private final int MIN_HOTNESS=0;

    /** The minimum coldness allowed. */
    private final int MIN_COLDNESS=0;

    /** The default hotness. */
    private final int DEFAULT_HOTNESS=0;

    /** The default coldness. */
    private final int DEFAULT_COLDNESS=0;

    /**
     Initialize a new temperature with coldness zero and hotness zero.
     * @post  The temperature is initialized with a hotness and coldness of 0.
     *          | this(0, 0)
     */
    public Temperature() {
        this(0, 0);
    }

    /**
     * Initialize a new temperature with given coldness and hotness.
     * @param   coldness
     *          The coldness of the temperature.
     * @param   hotness
     *          The hotness of the temperature.
     * @post    If the given hotness and coldness are both not zero, then we set the biggest to zero.
     *          |   if (getColdness() != 0 && getHotness() != 0)
     *          |       if (getColdness() >= getHotness())
     *          |           getColdness() = 0
     *          |           getHotness() = hotness
     *          |       else
     *          |           getHotness() = 0
     *          |           getColdness() = coldness
     *          |   else
     *          |       getColdness() = coldness
     *          |       getHotness() = hotness
     * @effect  The coldness is set to the given coldness.
     * 			If the given coldness is not valid, the coldness is set to the default coldness.
     *          | setColdness(coldness)
     * @effect  The hotness is set to the given hotness.
     * 			If the given hotness is not valid, the hotness is set to the default hotness.
     *          | setHotness(hotness)
     */
    public Temperature(int coldness, int hotness) {
        if (coldness != 0 && hotness != 0) {
            if (coldness >= hotness) {
                coldness = 0;
            } else {
                hotness = 0;
            }
        }
        this.setColdness(coldness);
        this.setHotness(hotness);
    }

    /**
     * Inspector for the hotness.
     * @return  hotness:
     *          The hotness of the temperature.
     */
    @Basic
    protected int getHotness() {return this.hotness;}

    /**
     * Inspector for the coldness.
     * @return  coldness:
     *          The coldness of the temperature.
     */
    @Basic
    protected int getColdness() {return this.coldness;}

    /**
     * Setter for the hotness
     * @param hotness
     *        The hotness that you want to set.
     */
    private void setHotness(int hotness) {
        if ( this.MIN_HOTNESS <= hotness && hotness <= this.MAX_HOTNESS)
            this.hotness = hotness;
        else
            this.hotness = this.DEFAULT_HOTNESS;
    }

    /**
     * Setter for the coldness
     * @param coldness
     *        The coldness that you want to set.
     */
    private void setColdness(int coldness) {
        if ( this.MIN_COLDNESS <= coldness && coldness <= this.MAX_COLDNESS)
            this.coldness = coldness;
        else
            this.coldness = this.DEFAULT_COLDNESS;
    }

    /**
     * Getter for the temperature.
     * @return  An array of coldness and hotness.
     */
    public List<?> getTemperature() {
        return new ArrayList<>(Arrays.asList(this.coldness, this.hotness));
    }


    private void heat(int amount) {
        //TODO
    }

    private void cool(int amount) {
        //TODO
    }

}

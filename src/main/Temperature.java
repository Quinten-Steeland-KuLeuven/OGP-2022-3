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

    /** The hotness between 0 and MAX_TEMPERATURE. */
    private int hotness;

    /** The coldness between 0 and MAX_TEMPERATURE. */
    private int coldness;

    /** The maximum temperature allowed. */
    private static int maxTemperature =10000;

    /** The minimum temperature allowed. */
    private static final int MIN_TEMPERATURE=0;

    /** The default hotness. */
    private static final int DEFAULT_HOTNESS=0;

    /** The default coldness. */
    private static final int DEFAULT_COLDNESS=0;

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
        if ( MIN_TEMPERATURE <= hotness && hotness <= maxTemperature)
            this.hotness = hotness;
        else
            this.hotness = DEFAULT_HOTNESS;
    }

    /**
     * Setter for the coldness
     * @param coldness
     *        The coldness that you want to set.
     */
    private void setColdness(int coldness) {
        if ( MIN_TEMPERATURE <= coldness && coldness <= maxTemperature)
            this.coldness = coldness;
        else
            this.coldness = DEFAULT_COLDNESS;
    }

    /**
     * Getter for the temperature.
     * @return  An array of coldness and hotness.
     */
    public List<?> getTemperature() {
        return new ArrayList<>(Arrays.asList(this.coldness, this.hotness));
    }

    /**
     * Set the max value that is allowed for temperature.
     * @param   newMaxTemperature
     *          The maximum value that temperature can have.
     */
    public void setMaxTemperature(int newMaxTemperature) {
        if (newMaxTemperature > MIN_TEMPERATURE && newMaxTemperature >= maxTemperature)
        Temperature.maxTemperature = newMaxTemperature;
    }

    /**
     * Heat the temperature by a certain amount.
     * @param   amount
     *          The amount to increase the temperature by.
     */ // 1] protected so only oven and coolingbox use this.
        //    (I don't know if this is necessary or needed to be done this way.)
    protected void heat(int amount) {
        if (getHotness()+amount <= maxTemperature) {
            if (this.coldness != MIN_TEMPERATURE) this.coldness = MIN_TEMPERATURE;
            this.setHotness(getHotness()+amount);
        }
    }

    /**
     * Cool the temperature by a certain amount.
     * @param   amount
     *          The amount to decrease the temperature by.
     */ // idem 1] see above
    protected void cool(int amount) {
        if (getColdness()+amount <= maxTemperature) {
            if (this.hotness != MIN_TEMPERATURE) this.hotness = MIN_TEMPERATURE;
            this.setColdness(getColdness()+amount);
        }
    }

}

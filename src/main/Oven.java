import java.util.Random;

/**
 * A class for an oven.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class Oven extends Device{

    /** The temperature of the oven. */
    Temperature temperature;

    /**
     * Function that sets the temperature of the oven.
     * @param   temperature
     *          The temperature that the oven should be set to.
     */
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    /**
     * getter for temperature.
     * @return The temperature.
     */
    public Temperature getTemperature() {
        return temperature;
    }

    public void execute() {
        if (isInALaboratory()) {
            int currentHotness = this.contents.get(0).temperature.getHotness();
            int setHotness = this.getTemperature().getHotness();
            if (setHotness > currentHotness) {
                //5% afwijking op ingestelde waarde
                Random random = new Random(System.currentTimeMillis());
                int newHotness = (int) Math.round((((2 * random.nextFloat()) - 1) * 0.05) * setHotness) + setHotness;

                if (newHotness > currentHotness) {
                    this.contents.get(0).temperature.heat(newHotness - currentHotness);
                }

            }
        }
    }

}

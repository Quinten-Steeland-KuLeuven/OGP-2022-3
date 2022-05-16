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



    public void execute() {
        //TODO
    }

}

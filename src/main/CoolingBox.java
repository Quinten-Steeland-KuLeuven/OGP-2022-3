/**
 * A class for a cooling box.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class CoolingBox extends Device{

    /** The temperature of the coolingBox. */
    Temperature temperature;

    /**
     * Function that sets the temperature of the coolingBox.
     * @param   temperature
     *          The temperature that the cooling box should be set to.
     */
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }



    public void execute() {
        //TODO
    }

}

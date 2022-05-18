/**
 * A class for devices.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public abstract class Device {

    //contents

    /** The laboratory this device is in. */
    Laboratory laboratory;

    /**
     * Function that adds this device to a laboratory.
     * @param   laboratory
     *          The laboratory to add the device to.
     */
    public void addToLaboratory(Laboratory laboratory) {
        //TODO deftig
        this.laboratory = laboratory;
    }

    /**
     * Function that removes this device from its laboratory.
     */
    public void removeFromLaboratory() {
        //TODO deftig
        this.laboratory = null;
    }


    /**
     * Function that adds ingredients to the device.
     * @param   container
     *          The container containing the ingredient.
     */ // container gets removed when used.
    public void addIngredients(IngredientContainer container) {

    }

    /**
     * Function that returns the contents of this device in a new container.
     * @return  A container of the result of the
     */
    public IngredientContainer removeResult() {
        return null;
    }

    /**
     * Function that executes the operation of the device.
     */
    public abstract void execute();





}

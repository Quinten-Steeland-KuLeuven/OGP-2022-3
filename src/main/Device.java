

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
    IngredientContainer ingredients;
    /**
     * Function that adds this device to a laboratory.
     * @param   laboratory
     *          The laboratory to add the device to.
     */
    public void addToLaboratory(Laboratory laboratory) {
        laboratory.addDevice(this);
    }

    /**
     * Function that removes this device from its laboratory.
     */
    public void removeFromLaboratory() {
        this.laboratory.removeDevice(this);
    }

    /**
     * Function that sets this.laboratory to laboratory.
     * @param   laboratory
     *          The laboratory to set this.laboratory to.
     */
    protected void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }


    /**
     * Function that adds ingredients to the device.
     * @param   container
     *          The container containing the ingredient.
     */ // container gets removed when used.
    public void addIngredients(IngredientContainer container) {
        this.ingredients = container
    }

    /**
     * Function that returns the contents of this device in a new container.
     * @return  A container of the result of the
     */
    public IngredientContainer removeResult() {
        return null;
    }

    /**
     * Function that executes the operation of the device if it is in a laboratory.
     * @pre Device should be in a laboratory
     *      | this.laboratory != null
     */
    public abstract void execute();





}

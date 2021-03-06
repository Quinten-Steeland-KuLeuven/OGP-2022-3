import java.util.ArrayList;
import java.util.List;

/**
 * A class for devices.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public abstract class Device {

    /** The ingredient(s) stored in the device. */
    List<AlchemicIngredient> contents = new ArrayList<>();

    /** The laboratory this device is in. */
    Laboratory laboratory;

    /**
     * Function that adds this device to a laboratory.
     * @param   laboratory
     *          The laboratory to add the device to.
     */
    public void addToLaboratory(Laboratory laboratory) {
        laboratory.addDevice(this);
    }

    /**
     * Function that removes this device from its laboratory, if it is in one.
     */
    public void removeFromLaboratory() {
        if (isInALaboratory()) {
            this.laboratory.removeDevice(this);
        }
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
        //TODO  check if ingredient is the same as the one currently in the device (if any)
        //      Overwrite in kettle because multiple ingredients are allowed there.
        //      If it is the same, change the quantity of the ingredient stored to:
        //        ingre1.quantity +
        this.contents.add(container.getStoredIngredient());
    }

    /**
     * Function that returns the contents of this device in a new container.
     * @return  A container of the result of the
     */
    public IngredientContainer removeResult() {
        return null;
    }

    /**
     * Check if this device is in a laboratory.
     * @return True if in a laboratory.
     */
    public boolean isInALaboratory() {
        return this.laboratory != null;
    }

    /**
     * Function that executes the operation of the device if it is in a laboratory.
     * @pre Device should be in a laboratory
     *      | isInALaboratory
     */
    public abstract void execute();





}

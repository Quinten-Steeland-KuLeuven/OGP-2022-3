import java.util.HashSet;
import java.util.Set;

/**
 * A class for laboratory.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class Laboratory {

    //capacity
    //usedCapacity
    //storedIngredients
    Set<Device> devices = new HashSet<>();

    /**
     * Function that executes a recipe.
     * @param   recipe
     *          The recipe to execute.
     * @param   amount
     *          The amount of times the recipe should be executed.
     */ //MOET NIET UITBUNDIG WORDEN GESPECIFEERD (=COMENTAAR)
    public void execute(Recipe recipe, int amount) {

    }

    /*
    /**
     * Function that returns the items stored in the laboratory.
     * @return  The items stored in laboratory.
     */
    /*
    public Map getInventory() {

        //TODO inhoud van labo bijhouden als map???
        return null; //Map inventory;
    }
    */

    /*
    /**
     * Function that removes an ingredient from the laboratory storage.
     * @param   name
     *          The name of the ingredient.
     * @param   amount
     *          The amount of ingredient to remove.
     * @return  A container with given amount of ingredient.
     */ //A new container is made every time.
    /*
    public IngredientContainer removeIngredient(String name, Quantity amount) {

        //TODO
        return null;
    }
    */

    /*
    /**
     * Function that adds an ingredient to the laboratory storage.
     * @param   container
     *          The container of the ingredient that needs to be stored.
     */ //The container gets destroyed.

    /*
    public void addIngredient(IngredientContainer container) {

    }

     */

    /**
     * Get list of all devices in the lab.
     * @return Set of all devices in the lab.
     */
    public Set<Device> getDevices() {
        return devices;
    }

    /**
     * Add a device to this laboratory if it can be added.
     * @param   device
     *          The device to add.
     * @effect  If this device can be added to the lab, it will be added. Otherwise,
     *          nothing will happen.
     *          | if canHaveAsDevice(device)
     *          |     this.addDeviceToLab(device)
     */
    public void addDevice(Device device) {
        if (canHaveAsDevice(device)) {
            addDeviceToLab(device);
        }
    }

    /**
     * Add a device to this laboratory.
     * @param   device
     *          The device to add.
     */
    private void addDeviceToLab (Device device) {
        this.devices.add(device);
        device.setLaboratory(this);
    }

    /**
     * Check if device can be added to the lab.
     * @param   device
     *          The device to check.
     * @return  True if it can be added.
     *          | device.getClass() not in this.devices.getClass()
     *          |   && !device.isInALaboratory
     */
    public boolean canHaveAsDevice(Device device) {
        boolean canHave = true;
        for (Device deviceInLab : this.devices) {
            //Kan waarschijnelijk efficenter.
            if (deviceInLab.getClass().equals( device.getClass())) {
                canHave = false;
                break;
            }
        }
        if (canHave && device.isInALaboratory()) {
            canHave = false;
        }
        return canHave;
    }

    /**
     * Remove a device from this lab.
     * @param   device
     *          The device to remove.
     */
    public void removeDevice(Device device) {
        if (this.devices.contains(device)) {
            this.devices.remove(device);
            device.setLaboratory(null);
        }
    }

}

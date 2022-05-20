/**
 * A class for ingredient containers.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class IngredientContainer {

    //capacity
    //usedCapacity
    /** The ingredient stored in the container. */
    AlchemicIngredient storedIngredient;

    /**
     * Getter for the stored ingredient.
     * @return The stored ingredient.
     */
    public AlchemicIngredient getStoredIngredient() {
        return this.storedIngredient;
    }
}

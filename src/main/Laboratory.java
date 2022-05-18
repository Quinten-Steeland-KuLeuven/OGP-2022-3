import java.util.Map;

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
    //devices

    /**
     * Function that executes a recipe.
     * @param   recipe
     *          The recipe to execute.
     * @param   amount
     *          The amount of times the recipe should be executed.
     */ //MOET NIET UITBUNDIG WORDEN GESPECIFEERD (=COMENTAAR)
    public void execute(Recipe recipe, int amount) {

    }

    /**
     * Function that returns the items stored in the laboratory.
     * @return  The items stored in laboratory.
     */
    public Map getInventory() {

        //TODO inhoud van labo bijhouden als map???
        return null; //Map inventory;
    }

    /**
     * Function that removes an ingredient from the laboratory storage.
     * @param   name
     *          The name of the ingredient.
     * @param   amount
     *          The amount of ingredient to remove.
     * @return  A container with given amount of ingredient.
     */ //A new container is made every time.
    public IngredientContainer removeIngredient(String name, Quantity amount) {

        //TODO
        return null;
    }

    /**
     * Function that adds an ingredient to the laboratory storage.
     * @param   container
     *          The container of the ingredient that needs to be stored.
     */ //The container gets destroyed.
    public void addIngredient(IngredientContainer container) {

    }

}

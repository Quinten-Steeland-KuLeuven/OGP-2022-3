import java.util.ArrayList;
import java.util.List;

/**
 * A class for a collection of recipes: a recipe book.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class RecipeBook {

    /** A list of recipes. */
    List<Recipe> recipes;


    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public RecipeBook(Recipe recipe) {
        this();
        this.addRecipe(recipe);
    }

    /**
     * Function that adds a recipe to the end of the recipe book.
     * @param   recipe
     *          The recipe to add.
     */
    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    /**
     * Function that removes a recipe from the recipe book.
     * @param   recipe
     *          The recipe to remove.
     */
    public void removeRecipe(Recipe recipe) {
        this.recipes.remove(recipe);
    }

}

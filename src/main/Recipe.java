import be.kuleuven.cs.som.annotate.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class for recipes.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class Recipe {

    /** Name of the recipe. */
    String name;

    /** A list of steps for the recipe. */
    List<String> steps = new ArrayList<>();

    List<String> VALID_STEPS = List.of("add", "heat", "cool", "mix");

    /** A list of ingredients for the recipe. */
    List<AlchemicIngredient> ingredients = new ArrayList<>();

    public Recipe(String name, List<String> steps, List<AlchemicIngredient> ingredients) {
        this.name = name;
        for (String step : steps) {
            if (this.VALID_STEPS.contains(step.toLowerCase())) {
                this.steps.add(step.toLowerCase());
            }
        }
        if (!this.steps.isEmpty()) {
            String lastStep = this.steps.get(this.steps.size()-1);
            if (!Objects.equals(lastStep, "mix")) {
                this.steps.add("mix");
            }
        } else {
            this.steps.add("mix");
        }
        this.ingredients = ingredients;
    }

    /**
     * Getter for the name of the recipe.
     * @return The name of the recipe.
     */
    @Basic
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the list of steps of the recipe.
     * @return List of steps.
     */
    @Basic
    public List<String> getSteps() {
        return this.steps;
    }

    /**
     * Getter for the list of steps of the recipe.
     * @return
     */
    @Basic
    public List<AlchemicIngredient> getIngredients() {
        return this.ingredients;
    }
}

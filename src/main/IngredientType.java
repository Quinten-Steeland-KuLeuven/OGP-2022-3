import be.kuleuven.cs.som.annotate.*;

import java.util.List;

/**
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class IngredientType {

    /** The name of the ingredientType. */
    Name name;

    /** The state of the ingredientType. */
    final State state;

    /** The temperature of the ingredientType.  */
    final Temperature temperature;

    /**
     * Initialize an ingredientType with given name, state, and temperature.
     * @param   name
     *          The name of the ingredientType.
     * @param   state
     *          The state of the ingredientType.
     * @param   temperature
     *          The temperature of the ingredientType.
     */
    public IngredientType(Name name, State state, Temperature temperature) {
        this.name = name;
        this.state = state;
        this.temperature = temperature;
    }

    /**
     * Initialize an ingredientType with given name, and temperature.
     * This ingredientType will have a liquid state.
     * @param   name
     *          The name of the ingredientType.
     * @param   temperature
     *          The temperature of the ingredientType.
     */
    public IngredientType(Name name, Temperature temperature) {
        this(name, State.LIQUID, temperature);
    }

    /**
     * Initialize an ingredientType with the name water, a liquid state and a temperature of [0, 20]
     */
    public IngredientType() {
        //TODO water als naam.
        this(new Name(), State.LIQUID, new Temperature(0, 20));
    }

    /**
     * Basic getter for the name of the ingredientType.
     * @return The name of the ingredientType.
     */
    @Basic
    public Name getName() {
        return name;
    }

    /**
     * Basic getter for the state of the ingredientType.
     * @return The state of the ingredientType.
     */
    @Basic
    public State getState() {
        return state;
    }

    /**
     * Basic getter for the state of the ingredientType.
     * @return The temperature of the ingredientType.
     */
    @Basic
    private Temperature getTemperatureObject() {
        return this.temperature;
    }

    /**
     * Getter for the temperature of the ingredientType.
     * @return The temperature of the ingredientType as a list of [coldness, hotness].
     */
    public List<?> getTemperature() {
        return temperature.getTemperature();
    }
}

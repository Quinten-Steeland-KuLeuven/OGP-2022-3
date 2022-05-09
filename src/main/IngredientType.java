import java.util.List;

/**
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class IngredientType {

    Name name;
    final State state;
    final Temperature temperature;

    public IngredientType(Name name, State state, Temperature temperature) {
        this.name = name;
        this.state = state;
        this.temperature = temperature;
    }

    public Name getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public List<?> getTemperature() {
        return temperature.getTemperature();
    }
}

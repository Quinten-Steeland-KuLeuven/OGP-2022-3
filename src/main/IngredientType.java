import be.kuleuven.cs.som.annotate.*;
import java.util.List;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import be.kuleuven.cs.som.annotate.*;

/**
 * Class for ingredient types.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class IngredientType {




    private String simpleName;
    private String specialName;

    private final List<String> specialWords = new ArrayList<String>(Arrays.asList("mixed", "with"));

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
    public IngredientType(String name, State state, Temperature temperature) {
        setSimpleName(name);
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
    public IngredientType(String name, Temperature temperature) {
        this(name, State.LIQUID, temperature);
    }

    /**
     * Initialize an ingredientType with the name water, a liquid state and a temperature of [0, 20]
     */
    public IngredientType() {
        this("Water", State.LIQUID, new Temperature(0, 20));
    }

    /**
     * returns the simple name of this ingredientType
     */
    @Basic
    public String getSimpleName() {
        return simpleName;
    }

    /**
     * returns the special name of this ingredientType
     */
    @Basic
    public String getSpecialName() {
        return specialName;
    }

    /**
     * sets the simpleName to the given name if this name is a correct non-mixed name
     * @param simpleName
     * @throws IllegalArgumentException
     *         the given simpleName is not a correct non-mixed name
     *         | !isCorrectNonMixedName(simpleName)
     */
    public void setSimpleName(String simpleName) throws IllegalArgumentException {
        if (!isCorrectNonMixedName(simpleName))
            throw new IllegalArgumentException("given name: " + simpleName + " is not correct");
        this.simpleName = simpleName;
    }

    /**
     * sets the simpleName to the given name if this name is a correct mixed name
     * @param simpleName
     * @throws IllegalArgumentException
     *         the given simpleName is not a correct mixed name
     *         | !isCorrectMixedName(simpleName)
     */
    public void setSimpleNameMixed(String simpleName) throws IllegalArgumentException {
        if (!isCorrectMixedName(simpleName))
            throw new IllegalArgumentException("given name: " + simpleName + " is not correct");
        this.simpleName = simpleName;
    }

    /**
     * set the specialName to the given name if this name is a correct non-mixed name
     * @param specialName
     * @throws IllegalArgumentException
     *         the given specialName is not a correct non-mixed name
     *         | !isCorrectNonMixedName(specialName)
     */
    public void setSpecialName(String specialName) throws IllegalArgumentException {
        if (!isCorrectNonMixedName(specialName))
            throw new IllegalArgumentException("given name: " + specialName + " is not correct");
        this.specialName = specialName;
    }

    /**
     * checks whether the given name is a correct name for a non-mixed ingredient
     * @param nonMixedName
     */
    private boolean isCorrectNonMixedName(String nonMixedName) {
        String[] words = nonMixedName.split(" ");
        if(words.length == 0) {
            return false;
        }
        int minWordLength = (words.length == 1) ? 3: 2;
        for(String word : words) {
            if(word.length() < minWordLength) {
                return false;
            }
            if (specialWords.contains(word.toLowerCase())) {
                return false;
            }
            Pattern pattern = Pattern.compile("^([A-Z'])[a-z']*$");
            Matcher matcher = pattern.matcher(word);
            if(!matcher.find()) {
                return false;
            }
        }
        return true;
    }
    /**
     * checks whether the given name is a correct name for a mixed ingredient
     * @param mixedName
     */
    private  boolean isCorrectMixedName(String mixedName) {

        if(!isCorrectlyStructured(mixedName))
            return false;

        if(!hasCorrectIngredientNames(mixedName))
            return false;

        return true;
    }
    /**
     * checks whether the given name has a correct structure for a mixed ingredient
     * this structure consists of correct non-mixed ingredient names with in between the names first one "mixed with" followed
     * with a "," between the next names and at the end of the list an "and". the non-mixed names also have to be
     * alphabetically ordered.
     * @param mixedName
     */
    private boolean isCorrectlyStructured(String mixedName) {
        String s = mixedName.replaceAll("mixed with", "0")
                .replaceAll(",", "1").replaceAll("and", "2")
                .replaceAll("\\D", "");
        Pattern pattern = Pattern.compile("^(0)1*(2)$|^(0)(2)$|^(0)$");
        Matcher matcher = pattern.matcher(s);
        if(!matcher.find()) {
            return false;
        }
        String[] nonMixedNames = mixedName.split(" mixed with |, | and ");
        if (!isAlphabetical(nonMixedNames))
            return false;

        return true;
    }

    /**
     * checks whether an array of strings is alphabetically ordered
     * @param names
     */
    private boolean isAlphabetical(String[] names) {
        String previous = names[0];
        for(String name : names) {
            if (name.compareTo(previous) < 0)
                return false;
        }
        return true;
    }

    /**
     * checks whether the given mixed name contains correct ingredient names
     * @param mixedName
     */
    private boolean hasCorrectIngredientNames(String mixedName) {
        String[] nonMixedNames = mixedName.split(" mixed with |, | and ");

        for(String name : nonMixedNames) {
            if (!isCorrectNonMixedName(name))
                return false;
        }
        return true;
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
     * Basic getter for the temperature of the ingredientType.
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

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class IngredientType {

    private String simpleName;
    private String specialName;

    private List<String> specialWords = new ArrayList<String>(Arrays.asList("mixed", "with"));
    final State state;
    final Temperature temperature;

    public IngredientType(String name, State state, Temperature temperature) {
        setSimpleName(name);
        this.state = state;
        this.temperature = temperature;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSimpleName(String simpleName) {
        if (!isCorrectNonMixedName(simpleName))
            throw new IllegalArgumentException("given name: " + simpleName + " is not correct");
        this.simpleName = simpleName;
    }

    public void setSimpleNameMixed(String simpleName) {
        if (!isCorrectMixedName(simpleName))
            throw new IllegalArgumentException("given name: " + simpleName + " is not correct");
        this.simpleName = simpleName;
    }

    public void setSpecialName(String specialName) {
        if (!isCorrectNonMixedName(specialName))
            throw new IllegalArgumentException("given name: " + specialName + " is not correct");
        this.specialName = specialName;
    }

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

    private  boolean isCorrectMixedName(String mixedName) {

        if(!isCorrectlyStructured(mixedName))
            return false;

        if(!hasCorrectIngredientNames(mixedName))
            return false;

        return true;
    }

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

    private boolean isAlphabetical(String[] names) {
        String previous = names[0];
        for(String name : names) {
            if (name.compareTo(previous) < 0)
                return false;
        }
        return true;
    }

    private boolean hasCorrectIngredientNames(String mixedName) {
        String[] nonMixedNames = mixedName.split(" mixed with |, | and ");

        for(String name : nonMixedNames) {
            System.out.println(name);
            if (!isCorrectNonMixedName(name))
                return false;
        }
        return true;
    }

    public State getState() {
        return state;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}

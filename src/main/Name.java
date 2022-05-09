import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class Name {
    private String simpleName = "";
    public String completeName = "";
    private String specialName = "";
    private List<String> specialWords = new ArrayList<String>(Arrays.asList("mixed", "with"));

    void setSimpleName(String name) {
        if(!hasCorrectNonMixedName(name))
            throw new IllegalArgumentException("Incorrect name given: " + name);
        simpleName = name;
    }

    void setSpecialName(String name) {
        if(!hasCorrectNonMixedName(name))
            throw new IllegalArgumentException("Incorrect name given: " + name);
        specialName = name;
    }

    private boolean hasCorrectNonMixedName(String name) {
        String[] words = name.split(" ");
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

    public String getSimpleName() {
        return simpleName;
    }

    public String getSpecialName() {
        return simpleName;
    }
}

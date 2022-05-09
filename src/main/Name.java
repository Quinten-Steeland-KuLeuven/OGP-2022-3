import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class Name {
    private String simpleName = "";
    public String completeName = "";
    public String specialName = "";
    private List<String> specialWords = new ArrayList<String>(Arrays.asList("mixed", "with"));

    void setSimpleName(String name) {
        String[] words = name.split(" ");
        if(words.length == 0) {
            throw new IllegalArgumentException("No name given");
        }
        int minWordLength = (words.length == 1) ? 3: 2;
        for(String word : words) {
            if(word.length() < minWordLength) {
                throw new IllegalArgumentException("wrong word size");
            }
            if (specialWords.contains(word.toLowerCase())) {
                throw new IllegalArgumentException("name contains " + word);
            }
            Pattern pattern = Pattern.compile("^([A-Z'])[a-z']*$");
            Matcher matcher = pattern.matcher(word);
            if(!matcher.find()) {
                throw new IllegalArgumentException("incorrect format or character");
            }
        }

        simpleName = name;
    }

    public String getSimpleName() {
        return simpleName;
    }
}

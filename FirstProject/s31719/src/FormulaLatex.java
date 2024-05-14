import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaLatex extends Content {
    public String latexFormula;

    public FormulaLatex(String content) {
        super.content = content;

        Pattern pattern = Pattern.compile("(\\w+\\s*=)?\\s*\\$(.*?)\\$");
        Matcher matcher = pattern.matcher(content);

        StringBuilder latexFormulas = new StringBuilder();
        String currentSetName = null; // To keep track of the current set name

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                currentSetName = matcher.group(1).trim();
            }
            if (matcher.group(2) != null) {
                if (currentSetName != null) {
                    latexFormulas.append(currentSetName).append(" ");
                    currentSetName = null; // Reset the set name after using it
                }
                latexFormulas.append(matcher.group(2)).append(" "); // replaced with a space
            }
        }

        latexFormula = latexFormulas.toString().trim();
    }

    public String getLatexFormula() {
        return latexFormula;
    }

    @Override
    public String toString() {
        return getLatexFormula();
    }
}
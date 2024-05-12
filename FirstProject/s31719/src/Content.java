import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public
    abstract class Content {

    public String content;
    public String latexFormula;
    public String imageFormula;
    public String taskContentFormula;
    public List<Content> contentList = new ArrayList<Content>();

    public String getLatexFormula(String content) {
        FormulaLatex formulaLatex = new FormulaLatex(content);
        String line = formulaLatex.getLatexFormula();
        this.latexFormula = line;
        if(formulaLatex instanceof Content) {
            contentList.add(formulaLatex);
        }
        return line + "\n";
    }

    public String getImageFormula(String content) {
        Image image = new Image(content);
        String line = image.getExtractedImages();
        this.imageFormula = line;
        if(image instanceof Content) {
            contentList.add(image);
        }
        return line + "\n";
    }

    public String getTextFormula(String content) {
        TaskContent taskContent = new TaskContent(content);
        String line = taskContent.getTaskContent();
        this.taskContentFormula = line;
        if(taskContent instanceof Content) {
            contentList.add(taskContent);
        }
        return line + "\n";
    }

}

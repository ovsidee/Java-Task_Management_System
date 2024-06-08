import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public
     class Content {
    String dataToDetect;
    public String content;
    public String latexFormula;
    public String imageFormula;
    public String taskContentFormula;

    public List<Content> contentList = new ArrayList<>();
    Map<String, List<Content> > fileContentMap = new HashMap<>();

    public String getLatexFormula(String content) {
        FormulaLatex formulaLatex = new FormulaLatex(content);
        String line = formulaLatex.getLatexFormula();
        this.latexFormula = line;
        if(!line.isEmpty()){
            contentList.add(formulaLatex);
        }
        return line;
    }

    public String getImageFormula(String content) {
        Image image = new Image(content);
        String line = image.getExtractedImages();
        this.imageFormula = line;
        if (!line.isEmpty()) {
            contentList.add(image);
        }
        return line;
    }

    public String getTextFormula(String content) {
        TaskContent taskContent = new TaskContent(content);
        String line = taskContent.getTaskContent();
        this.taskContentFormula = line;
        if (!line.isEmpty()) {
            contentList.add(taskContent);
        }
        return line;
    }

}

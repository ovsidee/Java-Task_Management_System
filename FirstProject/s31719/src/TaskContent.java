
public class TaskContent extends Content {

    private final String taskContent;

    public TaskContent(String content) {
        this.content = content;
        String tempContent = content;
        tempContent = tempContent.replaceAll("\\$[^$]*\\$", "");
        tempContent = tempContent.replaceAll("\\\\href\\{[^}]*\\}", "");
        tempContent = tempContent.replaceAll("−", "");
        this.taskContent = tempContent.trim();
    }

    public String getTaskContent() {
        return taskContent;
    }

    @Override
    public String toString() {
        return getTaskContent();
    }
}
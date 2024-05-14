import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
    class Image extends Content {

    public String imageFormula;

    public Image(String content) {
        this.content = content;

        Pattern pattern = Pattern.compile("(\\\\href\\{(.*?(jpg|jpeg|png|gif))\\})|(^(https?|ftp):\\/\\/[^\\s/$.?#].[^\\s]*\\.(jpg|jpeg|png|gif)$)");
        Matcher matcher = pattern.matcher(content);

        StringBuilder images = new StringBuilder();

        while (matcher.find()) {
            if(matcher.group(1) != null) {
                images.append(matcher.group(1)).append(" "); // replaced with a space
            }
        }

        this.imageFormula = images.toString().trim();
    }

    public String getExtractedImages() {
        return imageFormula;
    }

    @Override
    public String toString() {
        return getExtractedImages();
    }

}

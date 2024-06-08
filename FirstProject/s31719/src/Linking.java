import java.io.File;
import java.util.*;

public class Linking {

    public List<String> pathToLinkedFiles = new ArrayList<>();
    public static Map<String , List<String >> linkedFiles = new HashMap<>();
    public static List<File> allPathsToDirectoriesInStudent = new ArrayList<>();

    public Linking(String fileName) {
        String fileNameWithoutTxt = fileName.replace(".txt", "");

        File studentsDirectory = new File("./Students/");

        //just path to all directories inside "Student" (eg. Students\First Last)
        allPathsToDirectoriesInStudent = Arrays.asList(studentsDirectory.listFiles());
        for (File studentDir : allPathsToDirectoriesInStudent) {
            String path = studentDir + "\\" + fileNameWithoutTxt + "\\" + fileName;
            pathToLinkedFiles.add(path);
            linkedFiles.put(fileNameWithoutTxt, pathToLinkedFiles);
        }
        System.out.println("Successfully linked!");
//        printing the linked files
//        for (Map.Entry<String, List<String >> entry : linkedFiles.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
    }
}
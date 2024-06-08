import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sequential implements ActionsWithFiles {

    private ListIterator<Path> solutionFileIterator;
    private List<Path> javaFiles;
    private List<File> foldersInsideStudent;

    public Sequential() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the first name and the last name of the student whose solutions you want to check, " +
                    "or type \"stop\" to go back to the menu: ");
            String studentName = scanner.nextLine();

            if ("stop".equalsIgnoreCase(studentName)) break;


            File studentDir = new File("./Students/" +
                    studentName);

            foldersInsideStudent = Arrays.asList(studentDir.listFiles());
            System.out.println("The following folders exists in the given student: ");
            for (File file : foldersInsideStudent){
                System.out.println(file.getName());
            }

            if (studentDir.exists() && studentDir.isDirectory()) {
                System.out.println("Enter task number to check (e.g., Task1), or type \"stop\"");
                String taskName = scanner.nextLine();

                if ("stop".equalsIgnoreCase(taskName)) return;

                File taskDir = new File(studentDir, taskName);
                if (taskDir.exists() && taskDir.isDirectory()) {
                    //javafiles of given folder
                    javaFiles = doesFileExist(taskDir, ".java");
                    if (javaFiles.size() > 0) {

                        if (javaFiles.size() == 1){
                            System.out.println("Here is only one file exists, you cannot move next or back.\n" + "The file: ");
                            if(solutionFileIterator.hasNext()) readSolutionFile(solutionFileIterator.next());
                            break;
                        }

                        System.out.println("First file: ");
                        if(solutionFileIterator.hasNext())  readSolutionFile(solutionFileIterator.next());
                        while (true) {
                            System.out.println("\nTo move to the next file, type \"next\". " +
                                    "To move to the previous file, type \"prev\". " +
                                    "To return to the menu, type \"stop\".");

                            String userInput = scanner.nextLine();

                            if ("stop".equalsIgnoreCase(userInput)) {
                                break;
                            } else if ("next".equalsIgnoreCase(userInput)) {
                                moveToNextFile();
                            } else if ("previous".equalsIgnoreCase(userInput)) {
                                moveToPreviousFile();
                            } else {
                                System.out.println("Invalid command, please try again.");
                            }
                        }
                    }
                } else {
                    System.out.println("The task directory does not exist. Please try again.");
                }
            } else {
                System.out.println("Given student does not exist. Please try again.");
            }
        }
    }

    private void moveToNextFile() {
        if (solutionFileIterator.hasNext()) {
            readSolutionFile(solutionFileIterator.next());
        } else {
            System.out.println("There are no more java files in this directory.");
        }
    }

    private void moveToPreviousFile() {
        if (solutionFileIterator.hasPrevious()) {
            readSolutionFile(solutionFileIterator.previous());
        } else {
            System.out.println("You are currently at the start, unable to move back!");
        }
    }

    private void readSolutionFile(Path javaFilePath) {
        try {
            Files.lines(javaFilePath).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Path> doesFileExist(File directory, String fileEnd) {
        List<Path> javaFiles = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(directory.toPath())) {
            paths.filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(fileEnd))
                    .forEach(javaFiles::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        solutionFileIterator = javaFiles.listIterator();
        return javaFiles;
    }
}
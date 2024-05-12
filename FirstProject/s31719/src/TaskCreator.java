import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public
    class TaskCreator implements ActionsWithFiles {
    public TaskCreator() {
        while (true) {
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            String fullPath = "E:\\Java\\Java-First-Project\\FirstProject\\s31719\\Tasks";
            File directory = new File(fullPath);

            File txtFile = createTxtFileInDirectory(directory);

            if(txtFile != null) {
                System.out.println("Now you can start inputting the task content: " +
                        "(or write \"stop\" to stop the input file). ");
                new WriteToFile(txtFile);
            } else {
                break;
            }
        }
    }

    public File createTxtFileInDirectory(File directory) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the task:" +
                "(or write \"stop\" to stop the creating files) ");
        String nameOfTheFileByUser = scan.nextLine();

        if (nameOfTheFileByUser.equals(Operations.STOP.getText())) {
            System.out.println("Stopped editing files\n");
            return null;
        }

        File txtFile = new File(directory, nameOfTheFileByUser + ".txt");

        if(createFile(txtFile)) {
            return txtFile;
        } else {
            return null;
        }
    }

    public boolean createFile(File txtFile) {
        String filename = txtFile.getName();
        File path = txtFile.getParentFile();

        if (doesFileExist(path, filename)) {
            System.out.println("File already exists! Or directory does not exist!");
            return false;
        }

        try {
            if (txtFile.createNewFile()) {
                System.out.println("File created successfully!");
                return true;
            } else {
                System.out.println("File could not be created!");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Something went wrong...");
            throw new RuntimeException(e);
        }



    }

    @Override
    public boolean doesFileExist(File directory, String fileName) {
        if (directory.exists() && directory.isDirectory()) {
            return Arrays.stream(directory.listFiles())
                    .anyMatch(file -> file.isFile()
                            && file.getName().equals(fileName));
        }
        return false;
    }

}

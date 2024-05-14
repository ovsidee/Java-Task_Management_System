import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccessTasks {

    private File[] files;

    public AccessTasks() {
        int index = 0;

        while (true) {
            Scanner scan = new Scanner(System.in);

            // TODO DELETE PATH
            // TODO DELETE PATH
            // TODO DELETE PATH
            // TODO DELETE PATH
            // TODO DELETE PATH

            File directory = new File("E:\\Java\\Java-First-Project\\FirstProject\\s31719\\Tasks");
            this.files = directory.listFiles();

            System.out.println("You are now in this file: " + files[index].getName());
//            readFileContent(files[index]);

            System.out.println("\nTo move to the next file type \"next\""
                    + " or type \"stop\" to return to the menu");

            String line = scan.nextLine();
            if (line.equalsIgnoreCase(CheckingOperations.STOP.getText())) break;

            if (line.equalsIgnoreCase("next")) {
                if (index < files.length - 1) {
                    index++;
                } else {
                    System.out.println("There are no more files. Returning to the menu...");
                    break;
                }
            }
        }
    }

//for printing
    public void readFileContent(File file) {
        System.out.println("Content of the file " + file.getName() + ":");

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class AccessTasks {

    private Iterator<File> fileIterator;

    public AccessTasks() {


        File directory = new File("./Tasks/");
        this.fileIterator = Arrays.asList(directory.listFiles()).iterator();

        Scanner scan = new Scanner(System.in);

        while (true) {
            if (!fileIterator.hasNext()) {
                System.out.println("There are no more files. Returning to the menu...");
                break;
            }

            File file = fileIterator.next();
            System.out.println("You are now in this file: " + file.getName());

            System.out.println("\nTo move to the next file type \"next\""
                    + " or type \"stop\" to return to the menu");

            String line = scan.nextLine();
            if (line.equalsIgnoreCase("stop")) {
                break;
            }
        }
    }
}
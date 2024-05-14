import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfSolutions {
    public int count;

    public NumberOfSolutions(){
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the task name to get amount: (without txt) \n" +
                    "or write \"stop\" to return to the menu");
            String fileName = scan.nextLine();
            if (fileName.equalsIgnoreCase(CheckingOperations.STOP.getText())) break;

            this.count = countSolutions(fileName);
            System.out.println("The amount of received solution to the " + fileName + " is: \n" + this.count);
        }
    }

    public int countSolutions(String taskName) {
        //TODO DELETE PATH
        //TODO DELETE PATH
        //TODO DELETE PATH
        //TODO DELETE PATH
        //TODO DELETE PATH
        //TODO DELETE PATH
        //TODO DELETE PATH
        File studentsPath = new File("E:\\Java\\Java-First-Project\\FirstProject\\s31719\\Students");
        File[] studentFolders = studentsPath.listFiles();
        int count = 0;
        System.out.println(Arrays.toString(studentFolders));

        // Iterate over each student's folder (by their path)
        for (File studentFolder : studentFolders) {
            //checks whether this path is exists (creates path, and then checks, do not create file)
            File taskFolder = new File(studentFolder, taskName);
            if (taskFolder.exists() && taskFolder.isDirectory()) {
                count++;
            }
        }
        return count;
    }
}
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public
    class NumberOfSolutions extends Solutions {

    public NumberOfSolutions(){
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the task name to get amount: (without txt) \n" +
                    "or write \"stop\" to return to the menu");
            String fileName = scan.nextLine();
            if (fileName.equalsIgnoreCase(CheckingOperations.STOP.getText())) break;

            super.count = countSolutions(fileName);
            System.out.println("The amount of received solution to the " + fileName + " is: \n" + this.count);
        }
    }

    @Override
    public int countSolutions(String taskName) {

        File studentsPath = new File("./Students/");
        File[] studentFolders = studentsPath.listFiles();
        int count = 0;
        //printing array
//        System.out.println(Arrays.toString(studentFolders));

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
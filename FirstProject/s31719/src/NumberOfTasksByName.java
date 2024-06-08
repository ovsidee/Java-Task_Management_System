import java.io.File;
import java.util.Scanner;

public
    class NumberOfTasksByName extends Solutions {

    public NumberOfTasksByName() {
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the first name and last name of the student that you want to check: "
                              + "or write \"stop\" to go back to the menu.");
            String student = scan.nextLine();

            if(student.equalsIgnoreCase(CheckingOperations.STOP.getText())) break;

            super.count = countSolutions(student);
        }
    }

    @Override
    public int countSolutions(String student) {

        File studentsPath = new File("./Students/" + student);
        if (studentsPath.exists() && studentsPath.isDirectory()) {
            File[] studentFolders = studentsPath.listFiles();
            //to prevent NullPointerException
            if (studentFolders != null) {
                if (studentFolders.length > 0) {
                    System.out.println("The number of tasks which were submitted by \"" + student + "\" is: \n" + studentFolders.length);
                    return studentFolders.length;
                } else {
                    System.out.println("The number of tasks which were submitted by \"" + student + "\" is: \n" + 0);
                }
            }
        } else {
            System.out.println("This student does not exist.");
        }
        return 0;
    }
}

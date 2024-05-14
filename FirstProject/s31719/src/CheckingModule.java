import java.util.Scanner;

public class CheckingModule {

    private boolean exit = false;

    public CheckingModule() {
        Scanner scan = new Scanner(System.in);
        CheckingOperations userAction;

        while (!exit) {
            System.out.println("\nSelect what you want to check: \n" +
                    "The number of received solutions for a specific task write \"amount of solutions\". \n" +
                    "To access to all tasks in sequence write \"access\". \n" +
                    "To know how many tasks were submitted by a student write \"tasks by name\". \n" +
                    "To get the sequential preview of all solutions provided by a specific student write \"sequential\". \n" +
                    "To exit from the Checking Module write \"exit\".");
            String userInput = scan.nextLine();
            userAction = CheckingOperations.fromString(userInput);
            if (userAction == null) {
                System.out.println("Invalid input. Please try again.\n");
            } else {
                performTaskAction(userAction);
            }
        }

    }

    public void performTaskAction(CheckingOperations action) {
        switch(action) {
            case NUMBER_OF_RECEIVED_SOLUTIONS:
                new NumberOfSolutions();
                break;
            case ACCESS_TASKS:
                new AccessTasks();
                break;
            case NUMBER_OF_TASKS_BY_STUDENT_NAME:

                break;
            case SEQUENTIAL_TASKS:

                break;
            case KILL_PROGRAM:
                exit = true;
                break;
            case STOP:
                System.out.println("Invalid input. Please try again.\n");
                 break;
            default:
                throw new IllegalArgumentException("Invalid operation.");
        }
    }
}

import java.util.Scanner;

public class TaskManagementSystem {
    public TaskManagementSystem() {
        Scanner scan = new Scanner(System.in);
        Operations userAction;
        while (true) {
            System.out.println("Welcome to the Task Management System!\n\n" +
                    "Type \"editing module\" to go to the Editing Module. \n" +
                    "Type \"checking module\" to go to the Task Checking Module.\n" +
                    "Type \"exit\" to go kill the program.");
            String userInputsAction = scan.nextLine();
            userAction = Operations.fromString(userInputsAction);
            if (userAction == null) {
                System.out.println("Invalid action. Please try again.\n");
            } else {
                selectAction(userAction);
            }
        }
    }

    public void selectAction(Operations operation){
        switch (operation) {
            case EDITING_MODULE:
                new EditingModule();
                break;
            case CHECKING_MODULE:
                new CheckingModule();
                break;
            case KILL_PROGRAM:
                System.exit(0);
            default:
                throw new IllegalArgumentException("Invalid operation.");
        }
    }
}

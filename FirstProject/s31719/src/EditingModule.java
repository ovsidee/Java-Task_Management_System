import java.util.Scanner;

public
    class EditingModule {

    private boolean exit = false;

    public EditingModule() {
        Scanner scan = new Scanner(System.in);
        Operations userAction;

        while (!exit) {
            System.out.println("Select what you want to do: \n" +
                    "To create the file write \"create\". \n" +
                    "To read the file write \"read\". \n" +
                    "To edit the file write \"edit\". \n" +
                    "To exit from the Editing Module write \"exit\".");
            String userInput = scan.nextLine();
            userAction = Operations.fromString(userInput);
            if (userAction == null) {
                System.out.println("Invalid input. Please try again.\n");
            } else {
                 performTaskAction(userAction);
            }
        }

    }

    public void performTaskAction(Operations action) {
        switch(action) {
            case CREATE_FILE:
                new TaskCreator();
                break;
            case EDIT_TASK:
                new EditingTask();
                break;
            case READ_FIlE:
                new ReadingFile();
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

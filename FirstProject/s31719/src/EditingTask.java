import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public
    class EditingTask
          extends Content implements ActionsWithFiles {

        public EditingTask() {
            while (true) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the name of the task that you wish to edit: \n" +
                        "(or write \"stop\" to stop the input file) ");

                String fileToEdit = scan.nextLine();

                if (fileToEdit.equals(Operations.STOP.getText())) {
                    System.out.println("Stopped editing files\n");
                    break;
                }

                //TODO REPLACE WITH NEW PATH!
                //TODO REPLACE WITH NEW PATH!
                //TODO REPLACE WITH NEW PATH!
                //TODO REPLACE WITH NEW PATH!
                //TODO REPLACE WITH NEW PATH!
                //TODO REPLACE WITH NEW PATH!


                File directory = new File("E:\\Java\\Java-First-Project\\FirstProject\\s31719\\Tasks" +
                        "\\" + fileToEdit + ".txt");

                if (!doesFileExist(directory, fileToEdit)){
                    new EditingTask();
                }

                File file = new File(directory.toString());

                try {
                    FileWriter fileWriter = new FileWriter(file);
                    System.out.println("You can now edit the file, please start typing:\n" +
                            "(or write \"stop\" to stop the input file) ");
                    new WriteToFile(file);
                    if (content == null){
                        content = "";
                    }
                    fileWriter.write(content);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    @Override
    public boolean doesFileExist(File file, String fileName) {
        if (file.exists() && file.isFile() && file.getName().equals(fileName + ".txt")) {
            return true;
        } else {
            System.out.println("This file does not exist, you can edit only existing file\n");
            return false;
        }
    }


}

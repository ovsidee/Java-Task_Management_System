import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public
    class EditingTask
          extends Content implements ActionsWithFiles {

    public EditingTask() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the name of the task that you wish to edit: \n" +
                    "(or write \"stop\" to go back to the main menu). ");

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

            if (!doesFileExist(directory, fileToEdit)) {
                new EditingTask();
            }

            File file = new File(directory.toString());

            System.out.println("You can now edit the file, please start typing:\n" +
                    "(or write \"stop\" to stop the input file) ");
            new WriteToFile(file);

//rewriting the value of the map, because we edited our file
            this.dataToDetect = getDataToDetect(file.getAbsolutePath());

            this.content = getLatexFormula(dataToDetect);
            this.content = getImageFormula(dataToDetect);
            this.content = getTextFormula(dataToDetect);

            //adding here content for map
            fileContentMap.put(fileToEdit + ".txt", new ArrayList<>
                    (Arrays.asList(contentList.toArray(new Content[0]))));

            contentList.clear();// Clear the old contentList for the next file.


            //TODO it is to show the content file
//            System.out.println("Content for file " + fileToEdit + ":");
//            if (contentList != null && !contentList.isEmpty()) {
//                contentList.stream().forEach(System.out::println);
//            }
//            System.out.println("Key set in fileContentMap: " + fileContentMap.keySet());
//            System.out.println("ENTER THE fileNameByTheUser ");
//            String fileNameByTheUser = scan.nextLine();
//            System.out.println(getContentListByFilename(fileNameByTheUser));

        }
    }
            //TODO it is to show the content file
//    public List<Content> getContentListByFilename(String filename) {
//        return fileContentMap.get(filename);
//    }

    public String getDataToDetect(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line.trim());
                data.append(" ");
            }
            return data.toString();
        } catch (IOException e){
            e.printStackTrace();
            return null;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public
    class TaskCreator
        extends Content implements ActionsWithFiles {


    public TaskCreator() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            String fullPath = "E:\\Java\\Java-First-Project\\FirstProject\\s31719\\Tasks";
            File directory = new File(fullPath);

            File txtFile = createTxtFileInDirectory(directory);

            if(txtFile != null) {
                System.out.println("Now you can start inputting the task content: " +
                        "(or write \"stop\" to stop). ");
                new WriteToFile(txtFile);

                //detecting types of data
                this.dataToDetect = getDataToDetect(txtFile.getAbsolutePath());

                this.content = getLatexFormula(dataToDetect);
                this.content = getImageFormula(dataToDetect);
                this.content = getTextFormula(dataToDetect);

                //adding here content for map
                String fileName = txtFile.getName();
                fileContentMap.put(fileName, new ArrayList<>
                        (Arrays.asList(contentList.toArray(new Content[0]))));
                contentList.clear(); // Clear the old contentList for the next file.



                //TODO it is to show the content file

//                System.out.println("Content for file " + fileName + ":");
//                if (contentList != null && !contentList.isEmpty()) {
//                    contentList.stream().forEach(System.out::println);
//                }
//                System.out.println("Key set in fileContentMap: " + fileContentMap.keySet());
//                System.out.println("ENTER THE fileNameByTheUser ");
//                String fileNameByTheUser = scan.nextLine();
//                System.out.println(getContentListByFilename(fileNameByTheUser));
            } else {
                break;
            }
        }
    }
            //TODO it is to show the content file
//    public List<Content> getContentListByFilename(String filename) {
//        return fileContentMap.get(filename);
//    }

    public File createTxtFileInDirectory(File directory) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the task:" +
                "(or write \"stop\" to comeback to the menu). ");
        String nameOfTheFileByUser = scan.nextLine();

        if (nameOfTheFileByUser.equals(Operations.STOP.getText())) {
            System.out.println("Stopped editing files\n");
            return null;
        }

        File txtFile = new File(directory, nameOfTheFileByUser + ".txt");

        if(createFile(txtFile)) {
            return txtFile;
        } else {
            return null;
        }
    }

    public boolean createFile(File txtFile) {
        String filename = txtFile.getName();
        File path = txtFile.getParentFile();

        if (doesFileExist(path, filename)) {
            System.out.println("File already exists! Or directory does not exist!");
            return false;
        }

        try {
            if (txtFile.createNewFile()) {
                System.out.println("File created successfully!");
                return true;
            } else {
                System.out.println("File could not be created!");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Something went wrong...");
            throw new RuntimeException(e);
        }



    }

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
    public boolean doesFileExist(File directory, String fileName) {
        if (directory.exists() && directory.isDirectory()) {
            return Arrays.stream(directory.listFiles())
                    .anyMatch(file -> file.isFile()
                            && file.getName().equals(fileName));
        }
        return false;
    }
}

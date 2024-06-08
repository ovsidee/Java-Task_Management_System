import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public
    class ReadingFile
        extends Content implements ActionsWithFiles {

    public String data;

    public ReadingFile() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the name of the file that you want to read" +
                    "(or write \"stop\" to comeback to the menu). ");

            String nameOfTheFileToRead = scan.nextLine();

            String directoryPath = "./Tasks/";

            String filePath = directoryPath + "\\" + nameOfTheFileToRead + ".txt";

            File directory = new File(directoryPath);

            if (nameOfTheFileToRead.equalsIgnoreCase(Operations.STOP.getText())) break;

            if (!doesFileExist(directory, nameOfTheFileToRead) ){
                System.out.println("File does not exist\n");
                continue;
            }
            System.out.println("The file: ");
            this.data = getDataFromFile(filePath);
            System.out.println(data);
        }
    }

    public String getDataFromFile(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line.trim());
                data.append("\n");
            }
            return data.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Boolean - object type, can have null, true, false. methods toString, value can be undefined or not yet set for example
    @Override
    public Boolean doesFileExist(File directory, String fileName) {
        if (directory.exists() && directory.isDirectory()) {
            if(directory.listFiles() != null) {
                return Arrays.stream(directory.listFiles() )
                        .anyMatch(file -> file.isFile() && file.getName().equals(fileName + ".txt") );
            }
        }
        return false;
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public
    class ReadingFile
        extends Content implements ActionsWithFiles {

    public String data;
    public String dataToDetectTypes;

    public ReadingFile() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the name of the file that you want to read" +
                    "(or write \"stop\" to stop the input file) ");

            String nameOfTheFileToRead = scan.nextLine();

            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!
            //TODO REPLACE WITH NEW PATH!

            String directoryPath = "E:\\Java\\Java-First-Project\\FirstProject\\s31719\\Tasks";

            String filePath = directoryPath + "\\" + nameOfTheFileToRead + ".txt";

            File directory = new File(directoryPath);

            if (nameOfTheFileToRead.equals(Operations.STOP.getText())) break;

            if (!doesFileExist(directory, nameOfTheFileToRead) ){
                System.out.println("File does not exist\n");
                continue;
            }

            //printing file
            System.out.println("The file: ");
            this.data = getDataFromFile(filePath);
            this.dataToDetectTypes = getDataToDetect(filePath);
            System.out.println(data);

            //get latex
//            System.out.println("Latex formula: ");
            this.content = getLatexFormula(dataToDetectTypes);
//            System.out.println(latexFormula + "\n");

            //get image
//            System.out.println("Image formula: ");
            this.content = getImageFormula(dataToDetectTypes);
//            System.out.println(imageFormula);

            //get task content
//            System.out.println("Task content: ");
            this.content = getTextFormula(dataToDetectTypes);
//            System.out.println(taskContentFormula);

            System.out.println("LISTTTTTTTTTTTTTTTTTTTTTTTTTTT:\n");
            if (contentList != null && !contentList.isEmpty()) {
                contentList.stream().forEach(System.out::println);
            }
            ////////////////////////////////////////////////////

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

    @Override
    public boolean doesFileExist(File directory, String fileName) {
        if (directory.exists() && directory.isDirectory()) {
            if(directory.listFiles() != null) {
                return Arrays.stream(directory.listFiles() )
                        .anyMatch(file -> file.isFile() && file.getName().equals(fileName + ".txt") );
            }
        }
        return false;
    }
}

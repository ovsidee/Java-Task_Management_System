import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public
    class WriteToFile extends Content {

    public WriteToFile(File txtFile) {
        Scanner scan = new Scanner(System.in);
        try (FileWriter writer = new FileWriter(txtFile)) {

            StringBuilder content = new StringBuilder();

            while (true) {
                String line = scan.nextLine();
                if (line.equals(Operations.STOP.getText())) {
                    System.out.println("Stopped editing files.\n");
                    break;
                }
                content.append(line + "\n");
                writer.write(line + "\n");
            }

            this.content = content.toString();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
            throw new RuntimeException(e);
        }
    }


}

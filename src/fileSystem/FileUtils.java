package fileSystem;

import java.io.*;

public class FileUtils {
    public static String readFile(String filePath){
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }
        catch (IOException e){
            System.out.println("Read failed");
        }

        return content.toString();
    }
    public static void writeFile(String filePath, String content) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            bw.write(content);
            bw.flush();
        }
        catch (IOException e){
            System.out.println("Write failed");
        }
    }
}

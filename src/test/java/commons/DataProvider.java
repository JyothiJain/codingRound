package commons;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jyothijain on 16/08/18.
 */
public class DataProvider {
    public String readData(String fileName) throws FileNotFoundException {

        StringBuilder result = new StringBuilder();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line);
        }
        scanner.close();
        return result.toString();

    }
}

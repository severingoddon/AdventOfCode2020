
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SeventhDez {

    private static int resultCounter = 0;
    private static boolean didIt = false;
    private static int number;

    public static void main(String[] args) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList();
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeKalender/src/main/resources/bags2.txt")); //mac path
        //BufferedReader myBufferedReader = new BufferedReader(new FileReader("C:\\Users\\sevi\\Desktop\\IntelliJProjects\\Kalender\\src\\main\\java\\passports.txt")); //windows path
        try {
            String line = myBufferedReader.readLine();
            while (line != null) {
                line = myBufferedReader.readLine();
                if (line != null) {
                    if (line.trim().isEmpty()) line += "-";
                    sevisList.add(line);
                }
            }
        } finally {
            myBufferedReader.close();
        }
        for(int i = 0; i<sevisList.size(); i++){
            System.out.println(sevisList.get(i));
        }





    }

}


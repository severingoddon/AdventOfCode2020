
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FifthDez {

    private static int resultCounter = 0;
    private static boolean didIt = false;
    private static int number;

    public static void main(String[] args) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList();
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeKalender/src/main/java/boarding.txt")); //mac path
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
            String boardingPass = sevisList.get(i);
            String binary = "",  binary2 = "";
            for(int j = 0; j<boardingPass.length()-3; j++){
                if(boardingPass.charAt(j)=='F')binary+="0";
                else binary+="1";
            }
            for(int j = 7; j<boardingPass.length(); j++){
                if(boardingPass.charAt(j)=='L') binary2+="0";
                else binary2+="1";
            }
            int row = Integer.parseInt(binary,2);
            int column = Integer.parseInt(binary2,2);
            numbers.add(8*row + column);
        }
        Collections.sort(numbers);
        int mySeat = 0;
        for(int i = 0; i<numbers.size()-1; i++){
            int number = numbers.get(i);
            if(numbers.get(i+1)-number>1){
                mySeat = number+1;
            }
        }
        System.out.println(mySeat);




    }

}


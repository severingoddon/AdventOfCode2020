
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NinthDez {

    private static long[] resultArray;
    private static boolean found;

    public static void main(String[] args) throws IOException {
        ArrayList<Long> sevisList = new ArrayList();
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeKalender/src/main/resources/preambels.txt")); //mac path
        //BufferedReader myBufferedReader = new BufferedReader(new FileReader("C:\\Users\\sevi\\Desktop\\IntelliJProjects\\Kalender\\src\\main\\java\\passports.txt")); //windows path
        try {
            String line = myBufferedReader.readLine();
            while (line != null) {
                line = myBufferedReader.readLine();
                if (line != null) {
                    if (line.trim().isEmpty()) line += "-";
                    sevisList.add(Long.parseLong(line));
                }
            }
        } finally {
            myBufferedReader.close();
        }
        for(int i = 0; i<sevisList.size(); i++){
            long[] tester = new long[20];
            int x = i;
            for(int j = 0; j<tester.length; j++){
                tester[j] = sevisList.get(x);//fill up the test array
                x++;
            }
            long checksum = 0;
            for(int j = 0; j<tester.length; j++){
                checksum+= tester[j];
                if(checksum==466456641){
                    resultArray = new long[j+1];
                    for(int k = 0; k<resultArray.length; k++){
                        resultArray[k] = tester[k];
                    }
                    found = true;

                }
            }
            if(found)break;
        }
        System.out.println(Arrays.toString(resultArray));
        long max = resultArray[0];
        long min = resultArray[0];
        for(int i = 0; i<resultArray.length; i++){
            if(resultArray[i]<min) min = resultArray[i];
            if(resultArray[i]>max) max = resultArray[i];
        }
        System.out.println(min + max);
    }

}


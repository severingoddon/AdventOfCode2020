import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ThirdDez {

    private static int resultCounter = 0;
    private static int indexToRight = 0;
    private static final String treeString = "#";

    public static void main(String[] args) throws IOException {
        BigInteger resultat = checkPath(1,1).multiply(checkPath(3,1)).multiply(checkPath(5,1).multiply(checkPath(7,1)).multiply(checkPath(1,2)));
        System.out.println("*********************************************************");
        System.out.println();
        System.out.println("The result is: " + resultat);
    }

    //read the file and store the lines in an ArrayList
    public static BigInteger checkPath(int stepRight, int stepDown) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        BufferedReader sevisBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeCalendar/src/main/java/forest.txt"));
        try {
            String line = sevisBufferedReader.readLine();
            while (line != null) {
                line = sevisBufferedReader.readLine();
                if(line != null) {
                    sevisList.add(line);
                }
            }
        } finally {
            sevisBufferedReader.close();
        }


        for(int i = 0; i<sevisList.size(); i+=stepDown) {
            String currentLine = sevisList.get(i);

            if(currentLine.charAt(indexToRight) == treeString.charAt(0)){ //if char == #
                resultCounter++;
                StringBuilder newLocal = new StringBuilder(currentLine);  //Stringbuilder only for graphics in console
                newLocal.setCharAt(indexToRight, 'X');
                System.out.println(newLocal);
            }
            else{
                StringBuilder newLocal = new StringBuilder(currentLine);
                newLocal.setCharAt(indexToRight, '0');
                System.out.println(newLocal);
            }
            indexToRight = (indexToRight+stepRight)%currentLine.length();
        }
        System.out.println(resultCounter);
        int returnValue = resultCounter;
        indexToRight = 0;
        resultCounter = 0;
        return BigInteger.valueOf(returnValue);
    }

}

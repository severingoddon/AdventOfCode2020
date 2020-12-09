package seventhdez;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BagWriter {

    private static int resultCounter = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList();
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeKalender/src/main/resources/bags.txt")); //mac path
        PrintWriter writer = new PrintWriter("bags2.txt");
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
        for (int i = 0; i <sevisList.size() ; i++) {
            String line = sevisList.get(i);
            String newLine = "";
            String[] words = line.split(" ");

            for(int j = 0; j<words.length; j++){
                String word = words[j];
                if(!(word.equals("bag"))&&!(word.equals("bags"))&&!(word.equals("bag,"))&&!(word.equals("bags,"))&&!(word.equals("bag."))&&!(word.equals("bags."))&&!(word.equals("contain"))){
                     if(word.equals("1")||word.equals("2")||word.equals("3")||word.equals("4")||word.equals("5")){
                         word= "|";
                     }
                    newLine+= word;
                }
            }
            writer.println(newLine);
        }



    }

}


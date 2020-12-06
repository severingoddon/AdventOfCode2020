import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SixtDez {
    private static int resultCounter = 0;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        ArrayList<String> answers = new ArrayList();
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeKalender/src/main/java/questions.txt")); //mac path
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

        for (int i = 0; i < sevisList.size(); i++) {
            String local = "";
            while (!(sevisList.get(i).equals("-")) && i < sevisList.size() - 1) {
                local += sevisList.get(i) + " ";
                i++;
            }
            if (!(local.trim().isEmpty())) {
                answers.add(local);
            }
        }

        for (int i = 0; i <answers.size() ; i++) {
            String answer = answers.get(i);
            String[] personAnswer = answer.split(" ");
            for(int j = 0; j<alphabet.length(); j++){
                String letter = String.valueOf(alphabet.charAt(j));
                int checker = 0;
                for(int k = 0; k<personAnswer.length; k++){
                    if(personAnswer[k].contains(letter))checker++;
                }
                if(checker==personAnswer.length) resultCounter++;
            }
        }
        System.out.println(resultCounter);
    }
}

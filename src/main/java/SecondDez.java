import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SecondDez {

    private static int resultCounter = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        BufferedReader sevisBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeCalendar/src/main/java/passwords.txt"));
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

        for(int i = 0; i<sevisList.size(); i++){
            String word = sevisList.get(i);
            String[] firstSplit = word.split(":");
            String condition = firstSplit[0];
            String password = firstSplit[1];

            //prepare the condition
            String[] conditionSplit1 = condition.split(" ");
            String letter = conditionSplit1[1];
            String conditionWithRegex = conditionSplit1[0];
            String[] conditionSplit2 = conditionWithRegex.split("-");
            int firstPos = Integer.parseInt(conditionSplit2[0]);
            int secondPos = Integer.parseInt(conditionSplit2[1]);

            //prepare the password
            String preparedPassword = password.replace(" ", "");

            char searchedLetter = letter.charAt(0);

            int counter = 0;
            String notUseful = "$";
            char pos1 = notUseful.charAt(0);
            char pos2 = notUseful.charAt(0);

            int test = preparedPassword.length();

            if(preparedPassword.length() > firstPos-1){
                pos1 = preparedPassword.charAt(firstPos-1);
            }

            if(preparedPassword.length() > secondPos-1){
                pos2 = preparedPassword.charAt(secondPos-1);
            }

            if(pos1 == searchedLetter){
                counter++;
            }
            if(pos2 == searchedLetter){
                counter++;
            }
            if(counter == 1){
                resultCounter++;
            }
            counter = 0;
        }

        System.out.println(resultCounter);
    }
}

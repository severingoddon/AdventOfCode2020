import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FirstDez{

    private  static boolean breakstatement = false;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> sevisList = new ArrayList();
        BufferedReader sevisBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeCalendar/src/main/java/sevisNummern5.txt"));
        try {
            String line = sevisBufferedReader.readLine();
            while (line != null) {
                line = sevisBufferedReader.readLine();
                if(line != null) {
                    sevisList.add(Integer.parseInt(line));
                }
            }
        } finally {
            sevisBufferedReader.close();
        }
        for(int i = 0; i<sevisList.size(); i++){
            if(breakstatement){
                break;
            }
            for(int j = 0; j<sevisList.size(); j++){
                if(breakstatement){
                    break;
                }
                for(int k = 0; k<sevisList.size(); k++) {
                    if(breakstatement){
                        break;
                    }
                    int result = sevisList.get(i) + sevisList.get(j) + sevisList.get(k);
                    if (result == 2020) {
                        System.out.println("Erste Nummer: " + sevisList.get(i));
                        System.out.println("Zweite Nummer: " + sevisList.get(j));
                        System.out.println("Dritte Nummer: " + sevisList.get(k));
                        System.out.println("ergibt addiert: " + result);
                        System.out.println("ergibt multipliziert: " + sevisList.get(i) * sevisList.get(j)*sevisList.get(k));
                        breakstatement = true;
                        break;
                    }
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FourthDez {

    private static int resultCounter = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        ArrayList<String> passports = new ArrayList();
        //BufferedReader sevisBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeCalendar/src/main/java/passports.txt")); //mac path
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("C:\\Users\\sevi\\Desktop\\IntelliJProjects\\Kalender\\src\\main\\java\\passports.txt")); //windows path
        try {
            String line = myBufferedReader.readLine();
            while (line != null) {
                line = myBufferedReader.readLine();
                if(line != null) {
                    if (line.trim().isEmpty()) line+="-";
                    sevisList.add(line);
                }
            }
        } finally {
            myBufferedReader.close();
        }

        for(int i = 0; i<sevisList.size(); i++){
            String local = "";
            while(!(sevisList.get(i).equals("-")) && i<sevisList.size()-1){
                local+=sevisList.get(i)+" ";
                i++;
            }
            if(!(local.trim().isEmpty())){
                passports.add(local);
            }
        }

        for(int i = 0; i<passports.size(); i++){
            System.out.println(passports.get(i));
            String password = passports.get(i);
            int checker = 0;
            if(password.contains("ecl:")) checker++;
            if(password.contains("pid:")) checker++;
            if(password.contains("eyr:")) checker++;
            if(password.contains("hcl:")) checker++;
            if(password.contains("byr:")) checker++;
            if(password.contains("iyr:")) checker++;
            if(password.contains("hgt:")) checker++;

            if(checker==7){
                if(checkPassoword(password)) resultCounter++;
            }
        }

        System.out.println(resultCounter);
    }
    public static boolean checkPassoword(String password){
        String[] elements = password.split(" ");
        int checker = 0;
        for(int i = 0; i<elements.length; i++){
            String element = elements[i];
            if(element.contains("ecl:")){
                if(checkECL(element)) checker++;
            }
            if(element.contains("pid:")){
                if(checkPID(element)) checker++;
            }
            if(element.contains("eyr:")){
                if(checkEYR(element)) checker++;
            }
            if(element.contains("hcl:")){
                if(checkHCL(element)) checker++;
            }
            if(element.contains("byr:")){
                if(checkBYR(element)) checker++;
            }
            if(element.contains("iyr:")){
                if(checkIYR(element)) checker++;
            }
            if(element.contains("hgt:")){
                if(checkHGT(element)) checker++;
            }
        }
        return checker == 7;
    }

    public static boolean checkECL(String element){
        return true;
    }
    public static boolean checkPID(String element){
        return true;
    }
    public static boolean checkEYR(String element){
        String[] arguments = element.split(":");
        if((arguments[1].length()==4))return false;
        int date = Integer.parseInt(arguments[1]);
        return date >= 2020 && date <= 2030;
    }
    public static boolean checkHCL(String element){
        return true;
    }
    public static boolean checkBYR(String element){
        String[] arguments = element.split(":");
        if((arguments[1].length()==4))return false;
        int date = Integer.parseInt(arguments[1]);
        return date >= 1920 && date <= 2002;
    }
    public static boolean checkIYR(String element){
        String[] arguments = element.split(":");
        if((arguments[1].length()==4))return false;
        int date = Integer.parseInt(arguments[1]);
        return date >= 2010 && date <= 2020;
    }
    public static boolean checkHGT(String element){
        return true;
    }

}

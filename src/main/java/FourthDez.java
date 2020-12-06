import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FourthDez {

    private static int resultCounter = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        ArrayList<String> passports = new ArrayList();
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeKalender/src/main/resources/passports.txt")); //mac path
        //BufferedReader myBufferedReader = new BufferedReader(new FileReader("C:\\Users\\sevi\\Desktop\\IntelliJProjects\\Kalender\\src\\main\\java\\passports.txt")); //windows path
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
                if(checkPassword(password)) resultCounter++;
            }
        }

        System.out.println(resultCounter);
    }
    public static boolean checkPassword(String password){
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
        String[] arguments = element.split(":");
        String color = arguments[1];
        String validColors = "amb blu brn gry grn hzl oth";
        return validColors.contains(color);
    }
    public static boolean checkPID(String element){
        String[] arguments = element.split(":");
        String pid = arguments[1];
        return pid.length()==9;
    }

    public static boolean checkHCL(String element){
        String[] arguments = element.split(":");
        String color = arguments[1];
        if(color.contains("#")){
            String[] color2 = color.split("#");
            String code = color2[1];
            if(code.length()==6){
                if(checkColor(code))return true;
            }
        }
        return false;
    }


    public static boolean checkEYR(String element){
        String[] arguments = element.split(":");
        if(!((arguments[1].length()==4)))return false;
        int date = Integer.parseInt(arguments[1]);
        return date >= 2020 && date <= 2030;
    }

    public static boolean checkBYR(String element){
        String[] arguments = element.split(":");
        if(!((arguments[1].length()==4)))return false;
        int date = Integer.parseInt(arguments[1]);
        return date >= 1920 && date <= 2002;
    }
    public static boolean checkIYR(String element){
        String[] arguments = element.split(":");
        if(!((arguments[1].length()==4)))return false;
        int date = Integer.parseInt(arguments[1]);
        return date >= 2010 && date <= 2020;
    }
    public static boolean checkHGT(String element){
        String[] arguments = element.split(":");
        String second = arguments[1];
        if(second.charAt(second.length()-2) == 'c' ){
            String[] secondsplit = second.split("c");
            int number = Integer.parseInt(secondsplit[0]);
            if(number >= 150 && number <=193){
                return true;
            }else{
                return false;
            }
        }
        if(second.charAt(second.length()-2) == 'i' ){
            String[] secondsplit = second.split("i");
            int number = Integer.parseInt(secondsplit[0]);
            if(number >= 59 && number <=76){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public static boolean checkColor(String color){
        String digits = "0123456789";
        String letters = "abcdef";
        int checker = 0;
        for(int i = 0; i<color.length(); i++){
            if(digits.indexOf(color.charAt(i))!= -1 || letters.indexOf(color.charAt(i))!= -1 ){
                checker++;
            }
        }
        return checker == 6;
    }

}

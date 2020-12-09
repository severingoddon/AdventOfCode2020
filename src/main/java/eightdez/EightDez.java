package eightdez;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class EightDez {

    private static int acc = 0;


    public static int doWork(int indexToChange) throws IOException {
        ArrayList<String> sevisList = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList();
        BufferedReader myBufferedReader = new BufferedReader(new FileReader("/Users/severingoddon/Desktop/CodeKalender/src/main/resources/instructions.txt")); //mac path
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

        int counter = 0;
        int index = 0;
        while(true){
            String line = sevisList.get(index);
            if(line.contains("/")){
                return 1;
            }
            String[] linesplit = line.split(" ");
            String instruction = linesplit[0];
            if(index == indexToChange){
                if(instruction.equals("nop")) instruction = "jmp";
                if(instruction.equals("jmp")) instruction = "nop";
            }
            String operation = String.valueOf(linesplit[1].charAt(0));
            String[] operationsplit;
            if(operation.equals("+")) {
                operationsplit = linesplit[1].split("\\+");
            }
            else{
                operationsplit = linesplit[1].split("\\-");
            }
            int number = Integer.parseInt(operationsplit[1]);

            if(instruction.equals("jmp")){
                if(operation.equals("+")) index+=number;
                if(operation.equals("-")) index-=number;
            }
            if(instruction.equals("nop")){
                index++;
            }
            if(instruction.equals("acc")){
                if(operation.equals("+")) acc+=number;
                if(operation.equals("-")) acc-=number;
                index++;
            }


            if(counter > 100000)return 0;
            counter++;

        }






    }

}



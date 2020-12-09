package eightdez;

import eightdez.EightDez;

import java.io.IOException;

public class TestEightDez {
    public static void main(String[] args) throws IOException {
        int index = 0;
        while(true){
            if(EightDez.doWork(index)==1){
                System.out.println("index changed: "+ index);
                break;
            }
            index++;
            System.out.println(index);
        }

    }
}

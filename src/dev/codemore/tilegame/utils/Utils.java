package src.dev.codemore.tilegame.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        File file = new File(path); 
        System.out.println(path);

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null )
                builder.append(line + "\n"); 
            
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        // System.out.println(builder.toString());
        return builder.toString();
    }

    public static int parseInt(String number){
        try {
            return Integer.parseInt(number); 
        } catch (NumberFormatException e) {
            //TODO: handle exception
            e.printStackTrace();
            return 0; 
        }
    }

}
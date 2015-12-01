package assignment_7_yang_zhang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 1.Open a local file, read the file line by line. Each line should be imported as a string and stored in ArrayList. 
 * Then print out the ArrayList reversely. You can create your own file to test.
 */

public class ReadFileReversely {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/gotta/Documents/workspace/Assignment_7/src/assignment_7_yang_zhang/TestFile.txt"); 
        if (file.exists()) {
            System.out.println("File exists");
            ArrayList<String> a = AddLineToList(file);
            printListReversely(a);
        }
    }
    
    private static ArrayList<String> AddLineToList(File file) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String  thisLine = null;
        while ((thisLine = br.readLine()) != null) {
            result.add(thisLine);
        } 
        br.close();
        return result;
    }
   
    public static void printListReversely(ArrayList<String> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            System.out.println(a.get(i));
        }
    }
}

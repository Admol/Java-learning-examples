package net.admol.jingling.demo.algorithm;

import java.io.*;

/**
 * @author : admol
 * @Date : 2019/10/25
 */
public class Solution {

  
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String string = bufferedReader.readLine();

        Character result = FindChar.mostFrequentLetter(string);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

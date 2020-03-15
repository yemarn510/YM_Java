package jp.co.acroquest.training.JavaExercises;

import java.util.HashMap;
import java.util.Scanner;

/*
 * This is the dictionary function for the input English word.
 * This function prints the error message and the Japanese word.
 */
public class Exercise5
{
    /*
     * This is the main method for getting the English word and changing it to 
     * the Japanese word inside the dictionary storage.
     * @param args Command Line Argument
     */
    public static void main(String[] args)
    {
        HashMap<String, String> engToJapDict = new HashMap<String, String>();
        engToJapDict.put("hello", "kon-nichiwa");
        engToJapDict.put("name", "namae");
        engToJapDict.put("book", "hin");
        engToJapDict.put("chair", "isu");
        engToJapDict.put("dog", "inu");

        Scanner scan = new Scanner(System.in);
        String input, output;
        System.out.print("Input English Word : ");
        input = scan.nextLine();
        output = engToJapDict.get(input);
        if (output != null && !output.isEmpty())
        {
            System.out.println("Japanese Word is   : " + output);
        }
        else
        {
            System.out.println(
                    "The word \"" + input + "\" is not in the dictionary.");
        }
        scan.close();
    }
}

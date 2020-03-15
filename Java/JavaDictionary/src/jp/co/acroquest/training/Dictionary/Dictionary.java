package jp.co.acroquest.training.Dictionary;

import java.util.HashMap;

import jp.co.acroquest.training.Dictionary.DictionaryImport;
import jp.co.acroquest.training.Dictionary.DictionaryProcess;
public class Dictionary
{
//    C:\AcroWorks\git\angular\Java\JavaDictionary\src\jp\co\acroquest\training\Dictionary\Book2.csv
    /*
     * This is the main class for getting file name from the command line argument and calling the
     * process file to execute the functions.
     * @param args command line argument for getting file name
     */
    public static void main(String[] args)
    {
        HashMap<String, String> dictionary;
        if(args.length>0)
        {
            String fileName = args[0];
            dictionary = DictionaryImport.FileReader(fileName);
            if (dictionary.get("errorMsg") == "noError")
            {
                System.out.println("Welcome to Dictionary application \n");
                DictionaryProcess.Execute(dictionary, fileName);
            }
            else 
            {
                System.out.println("The file path does not exist");
            }
        }
        else
        {
            System.out.println("Please enter the file path");
        }
    }
}

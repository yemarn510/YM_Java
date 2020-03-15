package jp.co.acroquest.training.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * This is the main class for getting the file name and checking if the file name
 * is valid or not.
 */
public class DictionaryImport
{

    /*
     * This method is for getting the file name from the main class and checking
     * if the file exists.
     * @parm args fileName the name of the file from the argument
     *       return dictionary the Hashmap with keywords and values
     */
    public static HashMap<String, String> FileReader(String fileName)
    {

        HashMap<String, String> dictionary = new HashMap<String, String>();
        String pathToCsv = null;
        String row;
        pathToCsv = fileName;
        File fileExists = new File(pathToCsv);
        if (fileExists.exists() && !fileExists.isDirectory())
        {
            BufferedReader csvReader;
            try
            {
                csvReader = new BufferedReader(new FileReader(pathToCsv));
                while ((row = csvReader.readLine()) != null)
                {
                    String[] data = row.split(",");
                    dictionary.put(data[0], data[1]);
                }
                dictionary.put("errorMsg", "noError");
                csvReader.close();
            }
            catch (FileNotFoundException fileError)
            {
                dictionary.put("errorMsg", "fileNotExists");
                fileError.printStackTrace();
            }
            catch (IOException filePathError)
            {
                dictionary.put("errorMsg", "fileNotExists");
                filePathError.printStackTrace();
            }

        }
        else
        {
            dictionary.put("errorMsg", "fileNotExists");
        }
        return dictionary;
    }

}

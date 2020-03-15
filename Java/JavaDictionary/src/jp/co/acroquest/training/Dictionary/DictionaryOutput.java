package jp.co.acroquest.training.Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*
 * This is the main class for printing data into the CSV file
 */
public class DictionaryOutput
{
    /*
     * This method is for putting data into the CSV file.
     * @param args fileName the name of the file that the data will be written
     *             Dictionary the keywords and values that will be put into the CSV file
     */
    public static void main(HashMap<String, String> Dictionary, String fileName)
    {
        Set<String> keySet = Dictionary.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collection<String> values = Dictionary.values();
        ArrayList<String> listOfValues = new ArrayList<String>(values);
        StringBuilder sb = new StringBuilder();
        try (PrintWriter writer = new PrintWriter(new File(fileName)))
        {
            for (int index = 0; index < Dictionary.size(); index++)
            {
                sb.append(listOfKeys.get(index));
                sb.append(',');
                sb.append(listOfValues.get(index));
                sb.append('\n');
            }
            writer.write(sb.toString());

            System.out.println("\nExported Successfully\n");

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }

}

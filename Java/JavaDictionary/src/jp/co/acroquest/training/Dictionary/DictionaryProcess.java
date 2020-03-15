package jp.co.acroquest.training.Dictionary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/*
 * This is the main class for executing the process
 */
public class DictionaryProcess
{
    /*
     * This is the main method for executing the process that the user inputed from
     * the console.
     * @param args dictionary The HashMap with keyword and value
     *             fileName The Name of the file
     */

    public static void Execute(
            HashMap<String, String> dictionary, String fileName)
    {
        Scanner userInput = new Scanner(System.in);
        String choose = "0";
        boolean stay = true;
        while (stay)
        {
            switch (choose)
            {
                case "0":
                {
                    dictionary.remove("errorMsg");
                    System.out.print(
                            "1: Search\n" + "2: Register/update\n" + "3: Delete\n"
                                    + "4: Display\n" + "5: Export\n" + "q: Quit\n\n"
                                    + "Please input menu number(1-5 or q) : ");
    
                    String oo = "";
                    oo = userInput.nextLine();
                    if (oo.equals("q") || oo.equals("Q"))
                    {
                        choose = "6";
                        break;
                    }
                    else
                    {
                        try
                        {
                            int jj = Integer.parseInt(oo);
                            if (jj > 6)
                            {
                                choose = "0";
                                break;
                            }
                            else
                            {
                                choose = jj + "";
                                break;
                            }
                        }
                        catch (Exception error)
                        {
                            error.printStackTrace();
                            choose = "7";
                            break;
                        }
                    }
    
                }
                case "1":
                {
                    String keyword = "";
                    System.out.println("\nDictionary Search\n");
                    System.out.print("Please input a keyword:");
                    keyword = userInput.nextLine();
                    if (null == dictionary.get(keyword))
                    {
                        System.out.println("\nSorry cannot find your keyword.\n");
                        choose = "0";
                        break;
                    }
                    else
                    {
                        dictionary.get(keyword);
                        System.out.println("\nKeyword:" + keyword);
                        System.out.println(
                                "Explanation: " + dictionary.get(keyword) + '\n');
                        choose = "0";
                        break;
                    }
    
                }
                case "2":
                {
                    String keyword = "";
                    System.out.println("\nDictionary Register / Update\n");
                    System.out.print("Please input a keyword:");
                    keyword = userInput.nextLine();
                    System.out.print("Please input explanation :");
                    String explanation = userInput.nextLine();
                    dictionary.put(keyword, explanation);
                    System.out.println("\nRegister/Update finished.\n");
                    choose = "0";
                    break;
                }
                case "3":
                {
                    String keyword = "";
                    System.out.println("Dictionary Delete");
                    System.out.print("\nPlease input a keyword:");
                    keyword = userInput.nextLine();
    
                    if (null == dictionary.get(keyword))
                    {
                        System.out.println("\nSorry cannot find out and delete "
                                + keyword + "\n");
                        choose = "0";
                        break;
                    }
    
                    else if (dictionary.get(keyword).length() > 0)
                    {
                        dictionary.remove(keyword);
                        System.out.println("\nDelete Finished\n");
                        choose = "0";
                        break;
                    }
                }
                case "4":
                {
                    System.out.println("\nDictionary Display\n");
                    System.out.println(
                            "Following list is and all data of dictionary data");
                    System.out.println("[keyword],[explanation]");
                    Set<?> set = dictionary.entrySet();
                    Iterator<?> iterator = set.iterator();
                    while (iterator.hasNext())
                    {
                        Map.Entry mentry = (Map.Entry) iterator.next();
                        System.out.print(mentry.getKey() + ",");
                        System.out.println(mentry.getValue());
                    }
                    System.out.println();
                    choose = "0";
                    break;
                }
                case "5":
                {
    
                    DictionaryOutput.main(dictionary, fileName);
                    choose = "0";
                    break;
                }
                case "6":
                {
                    System.out.println("(End.)");
                    userInput.close();
                    stay = false;
                    break;
                }
                case "7":
                {
                    System.out.println("\nPlease input valid number\n");
                    choose = "0";
                    break;
                }
                }

        }
    }
}

package jp.co.acroquest.training.JavaExercises;

import java.util.Scanner;

/*
 * This is the main class for showing Fizz buzz
 * This class accepts the number from the user input and print it according to the
 * user input number.
 */
public class FizzBuzz
{
    final static int MAXNUM = 15;
    final static int MIDNUM = 5;
    final static int MINNUM = 3;
    final static int ONESECOND = 1000;
    final static int MAXCOUNT = 100;
    /*
     * This is the main class for playing Fizz Buzz. The number of line showing is
     * according to the user input.
     * @param args Command Line Argument
     */
    public static void main(String[] args)
    {
        String input;
        boolean runningIsOkay = true;
        while (runningIsOkay)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print(
                    "Please input the number of times to output for one second : ");
            input = scan.nextLine();
            try
            {
                int checkInput = Integer.parseInt(input);
                if (checkInput > 0)
                {
                    final long timeInterval = ONESECOND / checkInput;
                    Runnable runnable = new Runnable() {
                        boolean run = true;

                        public void run()
                        {
                            while (run)
                            {
                                try
                                {
                                    for (int count = 1; count <= MAXCOUNT; count++)
                                    {
                                        Thread.sleep(timeInterval);
                                        if (count % MAXNUM == 0)
                                        {
                                            System.out.println("FizzBuzz");
                                        }
                                        else if (count % MIDNUM == 0)
                                        {
                                            System.out.println("Buzz");
                                        }
                                        else if (count % MINNUM == 0)
                                        {
                                            System.out.println("Fizz");
                                        }
                                        else
                                        {
                                            System.out.println(count);
                                        }
                                    }
                                    run = false;
                                }
                                catch (InterruptedException err)
                                {
                                    err.printStackTrace();
                                }
                            }
                        }
                    };
                    Thread thread = new Thread(runnable);
                    thread.start();
                    runningIsOkay = false;
                    scan.close();
                }
                else if (checkInput <= 0)
                {
                    System.out.println("The input must be positive integer.");
                }
            }
            catch (Exception error)
            {
                System.out.println("The input must be positive integer.");
                scan.close();
                error.printStackTrace();
            }
        }
    }
}

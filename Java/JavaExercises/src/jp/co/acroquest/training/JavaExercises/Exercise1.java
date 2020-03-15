package jp.co.acroquest.training.JavaExercises;

/*
 * This is the main class for summing up the odd numbers
 * starting from 1 to 99.
 */
public class Exercise1
{
    /*
     * This is the main method for summing up the odd numbers
     * from 1 to 99. It skips 2 numbers while in the for loop.
     * @param args command line argument
     */
    public static void main(String[] args)
    {
        final int STARTINDEX = 1;
        final int ENDINDEX = 100;
        final int SKIPINT = 2;
        int sum = 0;
        for (int index = STARTINDEX; index < ENDINDEX; index += SKIPINT)
        {
            sum = sum + index;
        }
        System.out.println(sum);
    }
}

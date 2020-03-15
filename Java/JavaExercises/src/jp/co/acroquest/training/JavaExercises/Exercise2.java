package jp.co.acroquest.training.JavaExercises;
/*
 * This is the main class for summing up the numbers
 * starting from 1 to 1000. If the number cannot be divided by
 * 2,3,5 or 7 , it is assume as the prime number.
 */

public class Exercise2
{
    /*
     * This method is the main method for summing up the
     * prime numbers between 1 and 10000. 
     * @param args command line arguments
     */
	public static void main(String args[])
	{
		int sum = 0;
		final int FIRSTPRIME = 2;
		final int SECONDPRIME = 3;
		final int THIRDPRIME = 5;
		final int FOURTHPRIME = 7;
		final int MAXFORLOOP = 1000;
		for(int rollingNumber=0 ; rollingNumber < MAXFORLOOP ; rollingNumber++)
		{
			if(rollingNumber% FIRSTPRIME != 0 && rollingNumber % SECONDPRIME !=0 
					&& rollingNumber % THIRDPRIME !=0 && rollingNumber % FOURTHPRIME !=0)
			{
				sum = sum + rollingNumber;
			}
		}
		System.out.println("Answer is : "+ sum);
	}
}

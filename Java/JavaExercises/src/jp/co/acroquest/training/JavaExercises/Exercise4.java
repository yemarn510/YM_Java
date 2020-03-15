package jp.co.acroquest.training.JavaExercises;
import java.util.ArrayList;
import java.util.List;

/*
 * This is the main class for making the arrayList containing of
 * prime numbers between 1 and 10000. And then the number from 
 * the command line argument is divided by the prime numbers and
 * finding the prime factor decomposition.
 */
public class Exercise4
{
    /*
     * This is the main method for finding the factor decomposition
     * from the command line argument and printing out on the console.
     * @param args command line argument.
     */
	public static void main(String[] args) 
	{	
		final int STARTINDEX = 2;
		final int ENDINDEX = 10000;
		boolean isPrimeNumber= true;
		List<Integer> primeNumberList = new ArrayList<>();
		
		for(int index = STARTINDEX; index<=ENDINDEX; index++)
		{
			for(int idx = STARTINDEX ; idx <= index; idx++)
			{
				if(idx !=index && index%idx ==0)
				{
					isPrimeNumber = false;
					break;
				}
			}
			if(isPrimeNumber)
			{
				primeNumberList.add(index);
			}
			isPrimeNumber = true;	
		}
		
		ArrayList<Integer> ansArrayList = new ArrayList<Integer>();
		if(args.length>0)
		{
			try 
			{
				int num = Integer.parseInt(args[0]);
				System.out.print(num + " = ");
				for(int arrIndex =0; arrIndex < primeNumberList.size() ; arrIndex++)
				{	
					while(num % primeNumberList.get(arrIndex) == 0)
					{
						num = num / primeNumberList.get(arrIndex);
						ansArrayList.add(primeNumberList.get(arrIndex));
						System.out.print(primeNumberList.get(arrIndex));
						if(num == 1)
						{
						}
						else
						{
							System.out.print(" * ");
						}
					}
					
				}System.out.println();
			}
			catch(Exception error)
			{
				error.printStackTrace();
				System.out.println("Error");
			}
		}
	}
	
}

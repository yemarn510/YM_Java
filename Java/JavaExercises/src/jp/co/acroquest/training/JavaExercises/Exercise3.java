package jp.co.acroquest.training.JavaExercises;

/*
 * This is the main class for finding the maximum and
 * minimum value in the command line arguments.
 */
public class Exercise3
{
    /*
     * This is the main method for getting the command line
     * arguments and finding the minimum and maximum value
     * from it.
     * @param args command line arguments.
     */
	public static void main(String[] args)
	{	double rollingNumber;
		double max = 0, min = 0;
		if (args.length > 0) 
		{
		    try
		    {
		    	min = Double.parseDouble(args[0]);
		    	for(int index = 0; index <= args.length -1 ; index++)
		    	{
		    		rollingNumber = Double.parseDouble(args[index]);
		    		if (rollingNumber > max)
		    		{
		    			max = rollingNumber;
		    		}
		    		else if ( rollingNumber < min)
		    		{
		    			min = rollingNumber;
		    		}
		    	}
		    	System.out.println("Min Number : " + min);	
		    	System.out.println("Max Number : " + max);
		    }
		    catch(NumberFormatException NumError)
		    {
		    	NumError.printStackTrace();
		    	System.out.println("Argument" + args[0] + " must be an integer.");
		    }
		}
	}
}

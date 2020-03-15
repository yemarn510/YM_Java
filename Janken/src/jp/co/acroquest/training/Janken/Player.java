// package jp.co.acroquest.training.Janken;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * This is the main class for players for storing their data.
 */
public class Player
{
    int numPlay;
    int playerStrategy;
    List<Integer> jankenArray = new ArrayList<Integer>();
    int playerCount;
    /*
     * This method stores the data from the argument and then stored into the attributes.
     * @param numPlay numbers of gamePlay.
     *        playerStrate each player's strategy.
     *        Array the generated array to be stored.
     *        count the number of winning counts.
     */
    public Player(int numPlay, int playerStrate,List<Integer> Array, int count)
    {
        this.numPlay = numPlay;
        this.jankenArray = Array;
        this.numPlay = numPlay;
        this.playerStrategy = playerStrate;
        this.playerCount = count;
    }
    
    /*
     * This method is for generating the arrayList for the users to play.
     * Strategy 1 is for generating random arrays, 2 for generating arrayList
     * containing only rock and 3 for generating rock,paper,scissors in the
     * sequence.
     * @param numPlay number of game plays.
     *        strategy the strategy of players
     *  return list the array list generated according to the strategy.
     */
    public static List<Integer> generateArray( int numPlay, int strategy)
    {
        final int MAX_RDM = 4;
        final int MIN_RDM = 1;
        final int SEC_STRATEGY = 2;
        final int THIRD_STRATEGY =3;
        final int ROCK = 2;
        final int FINAL_INDEX = 3;
        List<Integer> list = new ArrayList<Integer>();
        if (strategy == 1)
        {
            Random rand = new Random(); 
            for(int generate=1; generate <= numPlay; generate++)
            {
                int rand_int1 = rand.nextInt(MAX_RDM - MIN_RDM) + MIN_RDM;
                list.add(rand_int1);
            }
            return list;
        }
        else if (strategy == SEC_STRATEGY)
        {
            for(int generate=1; generate <= numPlay; generate++)
            {
                list.add(ROCK);
            }
            return list;
        }
        else if (strategy == THIRD_STRATEGY)
        {
            int startIndex = 1;
            for(int generate=1; generate <= numPlay; generate++)
            {
                list.add(startIndex);
                if (startIndex == FINAL_INDEX){startIndex = 1;}
                else { startIndex += 1;}
            }
            return list;
        }
        else
        {   
            return null;
        }
    }
    /*
     * This method is for getting stored array for each player.
     * return jankenArray the stored Array for each player
     */
    public List<Integer> getList() 
    {   
        return jankenArray; 
    }
    
    /*
     * This method is for counting up by 1 when this function is called
     * by each player.
     * return playerCount each player's winning count
     */
    public int countUp()
    {
        playerCount ++;
        return playerCount;
    }
    /*
     * This method is for getting the strategy of each player.
     * return playerStrategy the strategy of each player.
     */
    public int getStrate()
    {
        return playerStrategy;
    }
}

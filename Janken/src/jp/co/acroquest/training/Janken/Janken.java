package jp.co.acroquest.training.Janken;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class is for playing Janken for 2 players.
 * if user input 4 on either one of the player strategy, the user
 * can also play.
 */
public class Janken
{

    private static Scanner userPlayer;

    /*
     * This is the main method for calling generated arrays, number of game 
     * plays, number of winning counts, the players' strategies and storing 
     * into the player object 
     *@param args the command line argument.
     */
    public static void main(String[] args)
    {
        int numPlay = 0;
        int firstStrate = 1, secStrate = 1;
        int playerOneCount = 0, playerTwoCount = 0;
        List<Integer> playerOneArray = new ArrayList<Integer>();
        List<Integer> playerTwoArray = new ArrayList<Integer>();

        if(args.length == 4)
        {
            System.out.println("Argument : " + args.length);
            numPlay = Integer.parseInt(args[1]);
            firstStrate = Integer.parseInt(args[2]);
            secStrate = Integer.parseInt(args[3]);
        }
        else if (args.length == 3)
        {
            System.out.println("Argument : " + args.length);   
            numPlay = Integer.parseInt(args[1]);
            firstStrate = Integer.parseInt(args[2]);
            if(firstStrate == 4)
            {
                firstStrate = 1;
                secStrate = 4;
            }
        }
        else if (args.length == 2)
        {
            System.out.println("Argument : " + args.length);
            numPlay = Integer.parseInt(args[1]);
        }
        

        playerOneArray = Player.generateArray(numPlay, firstStrate);
        playerTwoArray = Player.generateArray(numPlay, secStrate);

        Player playerOne = new Player(numPlay, firstStrate, playerOneArray,
                playerOneCount);
        Player playerTwo = new Player(numPlay, secStrate, playerTwoArray,
                playerTwoCount);

        judging(playerOne, playerTwo);
    }

    /*
     * This method is for judging the players and user inputs.
     * @param playerOne the objects of the First player
     *        playerTwo the objects of the Second player
     */
    private static void judging(Player playerOne, Player playerTwo)
    {
        final int MAX_STRATEGY = 4;
        final int MAX_DIFF = 2;
        String[] rounds =
        { "[First Play]", "[Second Play]", "[Third Play]", "[Fourth Play]",
                "[Fifth Play]", "[Sixth Play]", "[Seventh Play]",
                "[Eighth Play]", "[Nineth Play]", "[Tenth Play]",
                "[Eleventh Play]", "[Twelveth Play]", "[Thirteenth Play]" };
        String[] Janken =
        { "", "Rock", "Paper", "Scissors" };
        System.out.println("[Start Janken]\n");
        for (int judging = 0; judging < playerOne.jankenArray.size(); judging++)
        {

            int playingOne = playerOne.jankenArray.get(judging);
            int playingTwo = 0;
            if (playerOne.getStrate() == MAX_STRATEGY
                    || playerTwo.getStrate() == MAX_STRATEGY)
            {
                userPlayer = new Scanner(System.in);
                System.out.println("Input 1.Rock " + "2.Paper" + "3.Scissors");
                String userJanken = userPlayer.nextLine();
                playingTwo = Integer.parseInt(userJanken);
            }
            else
            {
                playingTwo = playerTwo.jankenArray.get(judging);
            }

            System.out.println(rounds[judging]);

            if (playingOne - playingTwo == -1
                    || playingOne - playingTwo == MAX_DIFF)
            {

                System.out.println(
                        Janken[playingOne] + "-" + Janken[playingTwo]);
                System.out.println("Player 2 wins.\n");
                playerTwo.countUp();
            }
            else if (playingTwo - playingOne == -1
                    || playingTwo - playingOne == MAX_DIFF)
            {
                System.out.println(
                        Janken[playingOne] + "-" + Janken[playingTwo]);
                System.out.println("Player 1 wins\n");
                playerOne.countUp();
            }
            else
            {
                System.out.println(
                        Janken[playingOne] + "-" + Janken[playingTwo]);
                System.out.println("Even.\n");
            }
        }

        if (playerOne.countUp() > playerTwo.countUp())
        {
            System.out.println("Player one is the winner");
        }
        else if (playerOne.countUp() < playerTwo.countUp())
        {
            System.out.println("Player two is the winner");
        }
        else
        {
            System.out.println("Game is draw");
        }

    }
}

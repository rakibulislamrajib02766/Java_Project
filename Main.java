import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int current = 0;
        int i = 0;
        int player1 = 0;
        int player2 = 0;
        int mode=0;
        int round=0;
        int guess=0;
        do {
            System.out.println("One (1) or Two (2) Player Mode?");  //to make it as single and double both mode
            mode = sc.nextInt();
            if (mode < 1 || mode > 2) {
                System.out.println("Invalid Input. Press 1 or 2");
            }
        }while (mode < 1 || mode > 2);
                    /* here, if i dont use anything, then after this message, rest of
                     the code will still run. but if i use "return;", then it will stop
                     the code here. but if i just want to show this invalid message to user and
                     want to give the chance to input again continuosly until he press the
                     right input, then i have to use do_while loop */


        do {
            System.out.println("How many Rounds?");
            round = sc.nextInt();
            if (round < 1) {
                System.out.println("Invalid Input. 1 or above");
            }
        }while(round<1);

        for (i = 1; i <= round; i++) {
            System.out.println("Rounds: "+ i+" of "+round);

            /*if (mode<1 || mode>3)
            {
                System.out.println("Invalid Input. Press 1 or 2");

                break;}
            else{*/
            switch (mode) {
                case 1:
                    current = r.nextInt(3) + 1;
                    break;
                case 2:
                    do {
                        System.out.println("Player_1: (1) paper, (2) Scissors, (3) Rock");
                        current = sc.nextInt();
                        if (current<1 || current>3) {
                            System.out.println("Invalid Input. Press 1, 2 or 3");
                        }
                    }while(current<1 || current>3);
            }

            do {
                System.out.println("Player_2: (1) paper, (2) Scissors, (3) Rock");
                guess = sc.nextInt();
                if (guess<1 || guess>3) {
                    System.out.println("Invalid Input. Press 1, 2 or 3");
                }
            }while(guess<1 || guess>3);


            switch (current)  //to show the user what computer/another player picked
            {
                case 1:
                    System.out.println("Player_1 chose Paper");
                    break;
                case 2:
                    System.out.println("Player_1 chose Scissors");
                    break;
                case 3:
                    System.out.println("Player_1 chose Rock");
                    break;
                default:
                    System.out.println("Invalid Input. Press 1 or 2 or 3");
                    break;
            }

            if (current == guess) {
                System.out.println("Tie");
            } else if ((current == 1 && guess == 2) || (current == 2 && guess == 3) || (current == 3 && guess == 1)) {
                /*Paper beats Rock
                 Scissors beats Paper
                 Rock beats Scissors*/
                System.out.println("Player_2 Won!");
                player2++;      //"Counter" increament to update the score_board after every round.
            } else {
                System.out.println("Player_1 Won!");
                player1++;
            }
            System.out.println("Current Score: Player1 vs Player2= " + player1 + " : " + player2);
            //to show the score_board.
        }
        if (player1 < player2) {
            System.out.println("Player_2 is the Winner");
        }
        else if (player1 == player2) {
            System.out.println("Draw game");
        }
        else
        {
            System.out.println("Player_1 is the Winner");
        }
    }
}

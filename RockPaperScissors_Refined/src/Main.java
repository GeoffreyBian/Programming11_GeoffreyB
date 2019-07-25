import java.util.Scanner;
//This line of code above imports a scanner so we could obtain input from the user.
public class Main {
    public static void main(String[] args) {

        //Integers for to keep track of score which could not be inside the while loop, because we want it to become larger, not go back to being 0
        int compScore = 0;
        int userScore = 0;
        //Two integers are created(one for the player's score, one for the computer's score). At the start of the game they equal 0, but once rounds are played the integers will become larger based on whether the player wins, losses, or ties.
        //The scores are 0 at the start but later in the code, the scores will be given 1 or nothing based on the victor of the round.
        System.out.println("Choose rock, paper, or scissors. '1' for rock, '2' for paper, and '3' for scissors. To exit choose '4.'");
        //The lines of code above simply prints out a line asking the user to type in 1(rock), 2(paper), 3(scissors), or 4(exit).

        //WHILE loop to ensure the game could run forever if wanted
        int forever = 0;
        while (forever == 0) {
            //The while loop above allows the game to be played as many times as wanted. The integer "forever" will always be 0 and while forever is 0, the game will repeat.

            //Player Score and User Score
            System.out.println("******************************************");
            System.out.println("Wins: " + userScore + "\tLosses: " + compScore);
            //The score is printed. The score is added to the integers "compScore" and "userScore," during the process of finding a winner in the code below.

            //USER CHOICE
            System.out.println("Player's Choice:");
            Scanner scan = new Scanner(System.in);
            int choice = Integer.parseInt(scan.next());
            //Line 25 prints "Player Choice:" to ask the player to choose a selection.
            //Line 26 of code creates a scanning variable called "scan," that allows us to store whatever the user inputs.
            //Line 27 of code creates an integer variable called "choice". The integer will be equal to the user input of either 1, 2, 3, or 4. The user input would be a string, but the code will parse the string to make it an integer.
            String user = "";
            //Right now, we are assigning the string, "user," nothing as it will be assigned within the if and else if statements below.
            if (choice == 1) {
                user = "rock";
            } else if (choice == 2) {
                user = "paper";
            } else if (choice == 3) {
                user = "scissors";
            } else if (choice == 4) {
                System.out.println("Thank you for playing!");
                break;
            }
            //The if statement (line 33) and the else if statements (line 35 and 37) tests whether the integer the user chose is 1, 2, or 3. It then assigns the string "user," either rock, paper, or scissors based on the choice of the user.
            //Ex. If the user chose rock, the computer would understand that the first condition is being fully met, therefore it will assign the string "user": "rock."
            //The final else if statement (line 39) tests if the user wants to stop playing the game. In the question asking the user for input, 4 was a selection to exit.
            //...This else if statement is saying that if the user choice is 4, the computer will print "thank you for playing," and break the while loop. Now that the while loop is broken, the code will stop repeating and it will end.

            //COMPUTER CHOICE
            int random = (int) (Math.random() * 100 - 1);
            //Line 49 of code creates an integer called "random," which stores a random number.
            //The function "Math.random" picks a double between 0 and 1. This is multiplied by 100, subtracted by 1, then converted to an integer to give us a random number between 0 and 99.
            String comp = "";
            //Right now, we are assigning the string, "comp," nothing as it will be assign within the if and else if statements below.
            if (random >= 0 && random <= 33) {
                comp = "rock";
            } else if (random >= 34 && random <= 66) {
                comp = "paper";
            } else if (random >= 67 && random <= 99) {
                comp = "scissors";
            }
            //The if statement (line 54) and the else if statements (line 56 and 58) finds out whether the random integer obtained by the computer is going to equal rock, paper, or scissors.
            //The integer generated will be in between 0 and 99. Knowing this, we would separate 99 into 3 groups of the same value.
            //We could make numbers inside the range of 0 and 33 equal to rock, 34 and 66 equal to paper, and 67 and 99 equal to scissors.
            //Ex. If the computer generates the integer 82 which is stored into the variable random. The integer will skip the first 2 conditions as 83 is greater than 33 and 66. It will move onto the third condition which is true.
            //... Since the integer random is greater than 67 and less than 99, the string with no value called "comp" is given the value of "scissors."

            //TO DESIGNATE A WINNER
            //The following "if" statement finds out whether there is a draw.
            if (comp == user) {
                System.out.println("Draw!\n" + "Computer Choice: " + comp + "\t\t Player Choice: " + user + "\n");
                //The if statement above checks is the string "user" is the same as the string "comp."
                //If the strings are the same as each other, that means that there is draw, therefore the computer prints out "Draw!" and after, prints out the computer choice and user choice.
                //The string "comp" and "user" are printed to show the player what the computer used and what they used.
                //Ex. If both the user and the computer chose paper, there would not be a victor, therefore the computer would print that there is a draw.
                //Since this is a draw, neither the integers "compScore" or "userScore" will be given any points.
            }
            //The following "else if" statement finds out whether the computer wins.
            else if (comp == "rock" && user == "scissors" || comp == "scissors" && user == "paper" || comp == "paper" && user == "rock") {
                System.out.println("You Lose!\n" + "Computer Choice: " + comp + "\t\tPlayer Choice: " + user + "\n");
                compScore++;
                //The else if statement above checks whether the computer is the victor.
                //The possible inputs of the computer and the user where the computer wins are all in the condition.
                //If one of the conditions is true, the computer prints "You lose," and the inputs of both the player and the computer.
                //Ex. If the user chose scissors and the computer chose rock, the computer wins, therefore the computer would print that the user lose.
                //The final line in the else if statement adds 1 to the integer "compScore."
                //Assuming that neither the user or the computer has won yet, now that "compScore" is added 1 when the while loop repeats it will print out that the comp's score is 1.
                //...The print statement above in the section, "# of wins and # of losses," will tell us that the computer has ___ amount of wins. For every win, 1 is added to the integer, increasing the total amount of wins.
            }
            //The following "else if" statement finds out whether the user wins.
            else if (comp == "rock" && user == "paper" || comp == "scissors" && user == "rock" || comp == "paper" && user == "scissors") {
                System.out.println("You Win!\n" + "Computer Choice: " + comp + "\t\tPlayer Choice: " + user + "\n");
                userScore++;
                //The else if statement above checks whether the user is the victor.
                //The possible inputs of the computer and the user where the user wins are all in the condition.
                //If one of the conditions is true, the computer prints "You Win," and the inputs of both the player and the computer.
                //Ex. If the user chose paper and the computer chose rock, the user wins, therefore the computer would print that the user wins.
                //The final line in the else if statement adds 1 to the integer "userScore."
                //Assuming that neither the user or the computer has won yet, now that "userScore" is added 1 when the while loop repeats it will print out that the user's score is 1.
                //...The print statement above in the section, "# of wins and # of losses," will tell us that the user has ___ amount of wins. For every win, 1 is added to the integer, increasing the total amount of wins.
            }
            //The following "else" statement tells us that the selection is invalid since it is not accepted by any of the conditions above.
            else {
                System.out.println("Invalid selection please play again." + "\n");
                //If the user puts in an integer that is not one of the possible selection (1, 2, 3, 4), the selection is invalid and the computer prints out that there is an invalid selection.
                //Ex. If the user put in 5, which is not an option to use, the computer would print that there is an invalid selection.
                //No points will be awarded due to the invalid selection.
            }
        }
    }
}
import java.util.Scanner;
//This line of code above imports a scanner so we could obtain an input from the user.

public class Main {
    public static void main(String[] args) {

        //QUESTION asking for input from the user

        System.out.println("Choose rock, paper, or scissors. '1' for rock, '2' for paper, and '3' for scissors.");
        //The line of code above simply prints out a line asking the user to type in 1(rock), 2(paper), or 3(scissors).


        //USER CHOICE

        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.next());
        //Line 15 of code creates a scanning variable called "scan," that allows us to store whatever the user inputs.
        //Line 16 of code creates an integer variable called "choice". The integer will be equal to the user input of either 1, 2, or 3. The user input would be a string, but the code will parse the string to make it an integer.

        String user = "";
        //Right now, we are assigning the string, "user," nothing as it will be assign within the if and else if statements below.

        if (choice == 1) {
            user = "rock";
        } else if (choice == 2) {
            user = "paper";
        } else if (choice == 3) {
            user = "scissors";
        }
        //The if statement (line 23) and the else if statements (line 27 and 31) tests whether the integer is 1, 2, or 3. It then assigns the string "user," either rock, paper, or scissors based on the choice of the user.
        //Ex. If the user chose rock, the computer would understand that the first condition is being fully met, therefore it will assign the string "user": "rock."


        //COMPUTER CHOICE

        int random = (int) (Math.random() * 100);
        //Line 40 of code creates an integer called "random," which stores a random number.
        //The function "Math.random" picks a double between 0 and 1. This is multiplied by 100 and then converted to an integer to give us a random number between 0 and 100.

        String comp = "";
        //Right now, we are assigning the string, "comp," nothing as it will be assign within the if and else if statements below.

        if (random >= 0 && random <= 33) {
            comp = "rock";
        } else if (random >= 34 && random <= 66) {
            comp = "paper";
        } else if (random >= 67 && random <= 100) {
            comp = "scissors";
        }
        //The if statement (line 47) and the else if statements (line 51 and 55) discloses whether the random integer obtained by the computer is going to equal rock, paper, or scissors.
        //The integer generated will be in between 0 and 100. Knowing this, we would separate 100 into 3 groups of around the same value.
        //We could make numbers inside the range of 0 and 33 equal to rock, 34 and 66 equal to paper, and 67 and 100 equal to scissors.
        //Ex. If the computer generates the integer 82 which is stored into the variable random. The integer will skip the first 2 conditions as 83 is greater than 33 and 66. It will move onto the third condition which is true.
        //... Since the integer random is greater than 67 and less than 100, the string with no value called "comp" is given the value of "scissors."


        //TO DESIGNATE A WINNER

        //The following "if" statement finds out whether there is a draw.
        if (comp == user) {
            System.out.println("Draw!\n\n" + "Computer Choice: " + comp + "\t\t Player Choice: " + user);
            //The if statement above checks is the string "user" is the same as the string "comp."
            //If the strings are the same as each other, that means that there is draw, therefore the computer prints out "Draw!" and after, prints out the computer choice and user choice.
            //The string "comp" and "user" are printed to show the player what the computer used and what they used.
            //Ex. If both the user and the computer chose paper, there would not be a victor, therefore the computer would print that there is a draw.
        }

        //The following "else if" statement finds out whether the computer wins.
        else if (comp == "rock" && user == "scissors" || comp == "scissors" && user == "paper" || comp == "paper" && user == "rock") {
            System.out.println("You Lose!\n\n" + "Computer Choice: " + comp + "\t\tPlayer Choice: " + user);
            //The else if statement above checks whether the computer is the victor.
            //The possible inputs of the computer and the user where the computer wins are all in the condition.
            //If one of the conditions is true, the computer prints "You lose," and the inputs of both the player and the computer.
            //Ex. If the user chose scissors and the computer chose rock, the computer wins, therefore the computer would print that the user lose.
        }

        //The following "else if" statement finds out whether the user wins.
        else if (comp == "rock" && user == "paper" || comp == "scissors" && user == "rock" || comp == "paper" && user == "scissors") {
            System.out.println("You Win!\n\n" + "Computer Choice: " + comp + "\t\tPlayer Choice: " + user);
            //The else if statement above checks whether the user is the victor.
            //The possible inputs of the computer and the user where the user wins are all in the condition.
            //If one of the conditions is true, the computer prints "You Win," and the inputs of both the player and the computer.
            //Ex. If the user chose paper and the computer chose rock, the user wins, therefore the computer would print that the user wins.
        }

        //The following "else" statement tells us that the selection is invalid, since it is not accepted by any of the conditions above.
        else {
            System.out.println("Invalid selection please play again.");
            //If the user puts in an integer that is not one of the possible selection (1, 2, 3), the selection is invalid and the computer prints out that there is an invalid selection.
            //Ex. If the user put in 5, which is not an option to use, the computer would print that there is an invalid selection.
        }

    }

}
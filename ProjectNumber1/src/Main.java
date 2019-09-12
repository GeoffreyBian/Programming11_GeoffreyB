public class Main {
    //Problem One
    //Function is created with the parameter of "String s."
    static int problemOne(String s){
        //Creating the integer "answer" where the number of vowels is to be stored.
        int answer = 0;
        //The for loop goes through the string given letter by letter until the last.
        for(int i = 0; i < s.length(); i++){
            //The if statement checks whether the letter in which the variable "i" is at is a vowel.
            //If true, the answer or number of vowels will augment by 1.
            if(s.substring(i,i+1).equals("a")||s.substring(i,i+1).equals("e")||s.substring(i,i+1).equals("i")||s.substring(i,i+1).equals("o")||s.substring(i,i+1).equals("u")){
                    answer++;
                }
            }
        //Giving an output of what the number of vowels is.
        System.out.println("Number of vowels: "+answer);
        //The function ends by returning the an integer which is the answer and the number of vowels.
        return answer;
        }

    //Problem Two
    //Function is created with the parameter of "String s."
    static int problemTwo(String s){
        //Creating the integer "answer" where the number of times bob occurs is to be stored.
        int answer = 0;
        //The for loop goes through the string given letter by letter until the last.
        for(int i = 0; i < s.length(); i++){
            //The if statement bellow prevents an out of bounds error.
            //Since there are 3 letters in "bob," the last two letters in a string would never equal to bob.
            //When the integer, "i," gets to the second last number, this if statement breaks out of the for loop since checking 2 letters for a substring of 3 letters is not possible.
            if(i==s.length()-2){
                break;
            }
            //The if statement bellow checks if the word "bob" appears.
            //The for loop goes through every letter while this if statement checks if the letter and the next 2 letters is equal to "bob."
            //If true, the number of times bob appears(answer) is increased by one.
            if(s.substring(i,i+3).equals("bob")){
                answer++;
            }
        }
        //Giving an output of what the number of times bob appears is.
        System.out.println("Number of times bob occurs is: "+answer);
        //The function ends by returning the an integer which is the answer and the number of times "bob" appears.
        return answer;
    }

    //Problem Three
    //Function is created with the parameter of "String s."
    static String problemThree(String s) {
        //Created a few integers and strings which are going to be used later.
        //"mainString" is for holding the largest substring that is in alphabetical order.
        //"tester" is for holding all the substrings in alphabetical order. It changes as the for loop progress through the letters.
        //"previousNumber" is for creating a border so that the substring breaks out when not alphabetical.
        //"number" is for holding a number based on the letter and testing the next letter to see if its alphabetical.
        String mainString = "";
        String tester = "";
        int previousNumber = 0;
        int number = 0;
        //The following for loop, goes through the string letter by letter while generating the longest alphabetical substring.
        for (int i = 0; i < s.length(); i++) {
            //The following for loop detects what the alphabet is of the letter the for loop is checking.
            //From the letter, a number is assigned to the an integer(number).
            //26 if statements inside the for loop are used to do this.
            for (int x = 0; x < 27; x++) {
                if (s.substring(i, i + 1).equals("a")) {
                    number = 1;
                }if (s.substring(i, i + 1).equals("b")) {
                    number = 2;
                }if (s.substring(i, i + 1).equals("c")) {
                    number = 3;
                }if (s.substring(i, i + 1).equals("d")) {
                    number = 4;
                }if (s.substring(i, i + 1).equals("e")) {
                    number = 5;
                }if (s.substring(i, i + 1).equals("f")) {
                    number = 6;
                }if (s.substring(i, i + 1).equals("g")) {
                    number = 7;
                }if (s.substring(i, i + 1).equals("h")) {
                    number = 8;
                }if (s.substring(i, i + 1).equals("i")) {
                    number = 9;
                }if (s.substring(i, i + 1).equals("j")) {
                    number = 10;
                }if (s.substring(i, i + 1).equals("k")) {
                    number = 11;
                }if (s.substring(i, i + 1).equals("l")) {
                    number = 12;
                }if (s.substring(i, i + 1).equals("m")) {
                    number = 13;
                }if (s.substring(i, i + 1).equals("n")) {
                    number = 14;
                }if (s.substring(i, i + 1).equals("o")) {
                    number = 15;
                }if (s.substring(i, i + 1).equals("p")) {
                    number = 16;
                }if (s.substring(i, i + 1).equals("q")) {
                    number = 17;
                }if (s.substring(i, i + 1).equals("r")) {
                    number = 18;
                }if (s.substring(i, i + 1).equals("s")) {
                    number = 19;
                }if (s.substring(i, i + 1).equals("t")) {
                    number = 20;
                }if (s.substring(i, i + 1).equals("u")) {
                    number = 21;
                }if (s.substring(i, i + 1).equals("v")) {
                    number = 22;
                }if (s.substring(i, i + 1).equals("w")) {
                    number = 23;
                }if (s.substring(i, i + 1).equals("x")) {
                    number = 24;
                }if (s.substring(i, i + 1).equals("y")) {
                    number = 25;
                }if (s.substring(i, i + 1).equals("z")) {
                    number = 26;
                }
            }
            //The following if statement sees if the number assigned to "number" is larger or equal to the number before, "previousNumber."
            //If true, the string current adds the letter in which the for loop is testing.
            //Previous number is then turned into number to allow the next check to happen.
            if (number >= previousNumber) {
                tester = tester + s.substring(i, i + 1);
                previousNumber = number;
            }
            //The following else if statement sees if an alphabetical string is bigger than another.
            //If yes, the longer one becomes "mainString."
            //The sequence keeps running until the whole string is gone through and the longest alphabetical string is determined.
            //If the two strings are the same size, the statement will not accept it so the first one will stay as "mainString."
            //After, the variables "tester" and "previousNumber" are reset with new values according to the letter it is checking for the next substring in alphabetical order.
            else if (tester.length() > mainString.length()) {
                mainString = tester;
                tester = "" + s.substring(i, i + 1);
                previousNumber = number;
            }
            //If the new string is either smaller or the same as a "mainString," the variables "tester" and "previousNumber" will be reset for the next substring.
            else{
                tester = "" + s.substring(i, i + 1);
                previousNumber = number;
            }
        }
        //The following if statement sees if the whole string is alphabetical.
        //If yes, "mainString" would have been 0, so we assign it "tester," which would be the longest alphabetical substring.
        if (tester.length() > mainString.length()) {
            mainString = tester;
        }
        //We make "s" equal to "mainString" so we could return it and print out the answer.
        s=mainString;
        //Giving an output of what the longest alphabetical substring is.
        System.out.print("Longest substring in alphabetical order is: "+s);
        //Returning the longest alphabetical substring.
        return s;
    }

    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s="azcbobobegghakl";
        problemOne(s);
        problemTwo(s);
        problemThree(s);
    }
}
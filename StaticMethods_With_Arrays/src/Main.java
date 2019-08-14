import java.util.Scanner;
public class Main {

    //Static method that adds 1 value to array
    static int[] addToArray(int []a, int numberAdded) {
        int[] b=new int[a.length+1];
        for (int x = 0; x <= a.length; x++) {
            if(x<a.length){
                b[x] = a[x];
            }
            else{
                b[x]=numberAdded;
            }
        }
        return b;
    }

    //Static method that subtracts the last value in the array
    static int[] subtractToArray(int[] a) {
        int[] b = new int[a.length - 1];
        for (int x = 0; x < a.length - 1; x++) {
            b[x] = a[x];
        }
        return b;
    }

    //Static method that inserts a value into the array where ever the user wants
    static int[] insertToArray(int[] a, int indexNumber, int inputNumber){
        if(indexNumber==0){
            int [] b = new int[a.length+1];
            b[0]=inputNumber;
            for(int x=1;x<=a.length;x++){
                b[x]=a[x-1];
            }
            return b;
        }
        else {
            int[] b = new int[a.length + 1];
            for(int x=a.length+1;x>indexNumber;x--){
                b[x-1]=a[x-2];
            }
            b[indexNumber]=inputNumber;
            for(int x=0;x<indexNumber;x++){
                b[x]=a[x];
            }
            return b;
        }
    }

    public static void main(String[] args) {

        //Creating an array in which the user gets to choose
        Scanner scan = new Scanner(System.in);
        System.out.println("How many values do you want for the array?");
        int valuesNumber = Integer.parseInt(scan.next());
        while(valuesNumber<0){
            System.out.println("There are not enough positions to place values for the array. Please reenter.");
                valuesNumber = Integer.parseInt(scan.next());
        }
        int[] a = new int[valuesNumber];
        int i = 0;
        while (i < valuesNumber) {
            System.out.println("Choose a number for your array in the index " + i + ".");
            int choice = Integer.parseInt(scan.next());
            a[i] = choice;
            i++;
        }

        //Asking for method of changing array
        int methodChoice=0;
        while(methodChoice<=0||methodChoice>=4) {
            System.out.println("Would you like to add a number to your array, subtract a number from your array, or insert a number into your array?\nIf you would like to add a number to your array, type 1.\nIf you would like to subtract the last number from your array, type 2. \nIf you would like to insert a number to your array, type 3.");
            methodChoice = Integer.parseInt(scan.next());
        }

        //Add a number to an array
        if (methodChoice == 1) {
            int addingNumbers=0;
            while(addingNumbers<=0) {
                System.out.println("How many numbers do you want to add to the end of the array?");
                addingNumbers=Integer.parseInt(scan.next());
            }
            int counter=0;
            while(counter<addingNumbers) {
                System.out.println("What is the number #"+(counter+1)+" that you want to add to the end of the array?");
                int numberAdded = Integer.parseInt(scan.next());
                a = addToArray(a, numberAdded);
                counter++;
            }
            System.out.println("Here are the values in your array:");
            int x = 0;
            while (x < a.length) {
                System.out.println(a[x]);
                x++;
            }
        }

        //Subtract the last number from an array
        else if (methodChoice == 2) {
            if(a.length==0){
                System.out.println("Cannot subtract, please restart.");
            }
            else {
                int[] b = subtractToArray(a);
                System.out.println("Here are the values in your array:");
                int x = 0;
                while (x < b.length) {
                    System.out.println(b[x]);
                    x++;
                }
                int y = a[a.length - 1];
                System.out.println("Here is the popped value of the array:\n" + y);
            }
        }

        //Inserting any value into array
        else if (methodChoice == 3) {
            if (valuesNumber==0) {
                System.out.println("Cannot insert, please restart.");
            } else {
                System.out.println("Where do you want to place your number? (Ex. If you choose 2, the number will be placed at the third slot.)");
                int indexNumber = Integer.parseInt(scan.next());
                while(indexNumber < 0||indexNumber>a.length){
                    System.out.println("You need to make sure that the position of your value is inside the array. Please reenter.");
                    indexNumber = Integer.parseInt(scan.next());
                }
                System.out.println("What number do you want to insert?");
                int inputNumber = Integer.parseInt(scan.next());
                int[] b = insertToArray(a, indexNumber, inputNumber);
                System.out.println("Here is your new array:");
                int x = 0;
                while (x < b.length) {
                    System.out.println(b[x]);
                    x++;
                }
            }
        }
    }
}
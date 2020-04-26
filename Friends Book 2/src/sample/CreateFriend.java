package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreateFriend {
    //Fields
    private static String firstName;
    private static String lastName;
    private static String address;
    private static int age;
    private static int iqScore;
    private static boolean isTrustworthy;
    private static String otherNotes;
    private static String type;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> allFriends = new ArrayList<>();
    private static ArrayList<Friend> bestFriends =new ArrayList<>();
    private static ArrayList<Friend> goodFriends = new ArrayList<>();
    private static ArrayList<Friend> normalFriends = new ArrayList<>();

    //Method that reads selected txt file to create friends that were saved
    public static ArrayList createFriends(String fileName) throws IOException {
        fr=new FileReader(fileName);
        br=new BufferedReader(fr);
        String line;
        String friendString="";
        //Going through the file until it reaches ";" (end of the friend's information) Adding the information before to a string
        //Once there, using the string to put values into fields of the friend (parsing the friend) thus recreating the friend
        while((line=br.readLine())!=null){
            if(!line.equals(";")){
                friendString+=line;
            }
            else{
                parseFriend(friendString, fileName);
                friendString="";
            }
        }

        //Returning the recreated array of friends
        if(fileName.equals("bestFriends.txt")){
            return bestFriends;
        }
        else if(fileName.equals("goodFriends.txt")){
            return goodFriends;
        }
        else if(fileName.equals("normalFriends.txt")){
            return normalFriends;
        }
        else{
            return allFriends;
        }
    }

    //Method to parse friend
    private static void parseFriend(String string, String fileName){
        int posOne=0;
        int posTwo=0;
        int posThree=0;
        int posFour=0;
        int posFive=0;
        int posSix=0;
        int posSeven=0;
        int posEight=0;
        //Using inputted symbols from save method to deduct where the friend's field (in a string) starts and ends
        for(int i=0; i<string.length();i++){
            if(string.substring(i,i+1).equals("|")){
                posOne=i;
                firstName=string.substring(0,posOne);
            }
            else if(string.substring(i,i+1).equals("{")){
                posTwo=i;
                lastName=string.substring(posOne+1,posTwo);
            }
            else if(string.substring(i,i+1).equals("}")){
                posThree=i;
                address=string.substring(posTwo+1,posThree);
            }
            else if(string.substring(i,i+1).equals("?")){
                posFour=i;
                age=Integer.parseInt(string.substring(posThree+1,posFour));
            }
            else if(string.substring(i,i+1).equals(",")){
                posFive=i;
                iqScore=Integer.parseInt(string.substring(posFour+1 ,posFive));
            }
            else if(string.substring(i,i+1).equals(".")){
                posSix=i;
                if(string.substring(posFive+1,posSix).equals("Is not trustworthy")){
                    isTrustworthy=false;
                }
                else{
                    isTrustworthy=true;
                }
            }
            else if(string.substring(i, i+1).equals("[")){
                posSeven=i;
                if(string.substring(posSix+1,posSeven).equals("n/a")){
                    otherNotes="";
                }
                else{
                    otherNotes=string.substring(posSix+1,posSeven);
                }
            }
            else if(string.substring(i,i+1).equals("]")){
                posEight=i;
                if(string.substring(posSeven+1,posEight).equals("Best Friends")){
                    type="Best Friends";
                }
                else if(string.substring(posSeven+1,posEight).equals("Good Friends")){
                    type="Good Friends";
                }
                else if(string.substring(posSeven+1,posEight).equals("Normal Friends")){
                    type="Normal Friends";
                }
                else{
                    type="";
                }
            }
        }
        //Putting all gotten values into a new recreated friend object
        Friend friend = new Friend(firstName, lastName, address, age, iqScore, isTrustworthy, otherNotes, type);
        //Checking if friend is the same as an already created list. If so not adding this friend to lists.
        boolean same=false;
        if(fileName.equals("allFriends.txt")){
            for(Friend f : allFriends){
                if(f.compareFriends(friend)){
                    same=true;
                    break;
                }
            }
        }
        else if(fileName.equals("bestFriends.txt")) {
            for (Friend f : bestFriends) {
                if (f.compareFriends(friend)) {
                    same = true;
                    break;
                }
            }
        }
        else if(fileName.equals("goodFriends.txt")){
            for(Friend f : goodFriends){
                if(f.compareFriends(friend)){
                    same=true;
                    break;
                }
            }
        }
        else if(fileName.equals("normalFriends.txt")){
            for(Friend f : normalFriends){
                if(f.compareFriends(friend)){
                    same=true;
                    break;
                }
            }
        }
        //Adding friends that are not the same to the selected list.
        if(!same){
            if(fileName.equals("bestFriends.txt")){
                bestFriends.add(friend);
            }
            else if(fileName.equals("goodFriends.txt")){
                goodFriends.add(friend);
            }
            else if(fileName.equals("normalFriends.txt")){
                normalFriends.add(friend);
            }
            else{
                allFriends.add(friend);
            }
        }

    }




}

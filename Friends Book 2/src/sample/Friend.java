package sample;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Friend {
    //Fields
    public String firstName;
    public String lastName;
    private String address;
    private int age;
    private int iqScore;
    private boolean isTrustworthy;
    private String otherNotes;
    private String type;

    //Constructor
    Friend(String fName, String lName, String ads, int age, int iq, boolean isTrust, String othNotes, String type){
        firstName=fName;
        lastName=lName;
        address=ads;
        this.age=age;
        iqScore=iq;
        isTrustworthy=isTrust;
        otherNotes=othNotes;
        this.type=type;
    }

    //Method that writes friends that are being saved into selected txt file
    public void writeToFile(String fileName) throws IOException{
        //Using filewriter and bufferedwriter to write into a file
        FileWriter fw =new FileWriter(fileName, true );
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(firstName + "|\n");
        bw.write(lastName + "{\n");
        bw.write(address + "}\n");
        bw.write( Integer.toString(age) + "?\n");
        bw.write(Integer.toString(iqScore) + ",\n");
        if(isTrustworthy){
            bw.write("Is trustworthy" + ".\n");
        }
        else if(!isTrustworthy){
            bw.write("Is not trustworthy" + ".\n");
        }

        if(otherNotes.isEmpty()){
            bw.write("n/a"+"[\n");
        }
        else{
            bw.write(otherNotes+"[\n");
        }

        if(type.equals("Best Friends")){
            bw.write("Best Friends"+"]\n");
        }
        else if(type.equals("Good Friends")){
            bw.write("Good Friends"+"]\n");
        }
        else if(type.equals("Normal Friends")){
            bw.write("Normal Friends"+"]\n");
        }
        else{
            bw.write("n/a"+"]\n");
        }

        bw.write(";\n");
        bw.close();
    }

    //Method to check if 2 friends are the same
    public boolean compareFriends(Friend f){
        if((this.firstName+this.lastName+this.address+this.iqScore).equals(f.firstName+f.lastName+f.address+f.iqScore)){
            return true;
        }else{
            return false;
        }
    }

    //Getters
    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean isTrustworthy() {
        return isTrustworthy;
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public int getIQScore() {
        return iqScore;
    }

    public String getType(){ return type;}

    //toString method
    public String toString() {
        return firstName+" "+lastName;
    }
}

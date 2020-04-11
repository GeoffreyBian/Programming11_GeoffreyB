package sample;

public class Friend {
    //Fields
    public String firstName;
    public String lastName;
    private String address;
    private int age;
    private int iqScore;
    private boolean isTrustworthy;
    private String otherNotes;

    //Constructor
    Friend(String fName, String lName, String ads, int age, int iq, boolean isTrust, String othNotes){
        firstName=fName;
        lastName=lName;
        address=ads;
        this.age=age;
        iqScore=iq;
        isTrustworthy=isTrust;
        otherNotes=othNotes;
    }

    //Getters
    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean getIsTrustworthy() {
        return isTrustworthy;
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public int getIQScore() {
        return iqScore;
    }

    //toString method
    public String toString() {
        return firstName+" "+lastName;
    }
}

public class Teacher {
    //This class named Teacher stores values of a teacher. Its fields are firstName, lastName, and subject. With this class, you can define a teacher.
    //Fields
    private String firstName;
    private String lastName;
    private String subject;

    //Constructor
    //The constructor is a method that allows us to create schools outside of this class. The constructor allows us to assign different values to the fields of the schools.
    //Using the this statement, by making the the value given to the constructor equal to the appropriate field, the school will be created.
    Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSubject() {
        return subject;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }


    //This method is a built in function that prints the location of the object. Since we are overriding this method, the specific line we want printed out is printed out when asked.
    public String toString(){
        return "Name: " + this.getFirstName() + " " + this.getLastName() + "    Subject: " + this.getSubject();
    }

}

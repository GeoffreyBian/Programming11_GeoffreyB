public class Student {
    //This class named Student stores values of a student. Its fields are firstName, lastName, grade, studentNumber, and studentId. The studentId increases every time, we create a new student.
    //With this class, you can define a student.
    //Fields
    private String firstName;
    private String lastName;
    private int grade;
    private static int studentNumber=1;
    private int studentId;

    //Constructor
    //The constructor is a method that allows us to create schools outside of this class. The constructor allows us to assign different values to the fields of the schools.
    //Using the this statement, by making the the value given to the constructor equal to the appropriate field, the school will be created.
    //Since we want a static increasing student number. Every time we create a new student, the student number is increased, thus making the student id a new number.
    Student(String firstName, String lastName, int grade){
        this.firstName=firstName;
        this.lastName=lastName;
        this.grade=grade;
        this.studentId=studentNumber;
        studentNumber++;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getGrade() {
        return grade;
    }
    public int getStudentId() {
        return studentId;
    }

    //Setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    //This method is a built in function that prints the location of the object. Since we are overriding this method, the specific line we want printed out is printed out when asked.
    public String toString(){
        return "Name: " + this.getFirstName() + " " + this.getLastName() + "    Grade: " + this.getGrade();
    }

}

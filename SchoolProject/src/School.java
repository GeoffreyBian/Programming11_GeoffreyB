import java.util.ArrayList;

public class School {
    //This class named School holds fields - string fields(school's name, school's location), ArrayList fields(list of teachers, list of students, list of courses), and an integer field(number of students).
    //There are numerous methods that manipulates this school.

    //Fields
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList courses = new ArrayList<>();
    private String schoolName;
    private String schoolLocation;
    private int numberOfStudents;

    //Constructor
    //The constructor is a method that allows us to create schools outside of this class. The constructor allows us to assign different values to the fields of the schools.
    //Using the this statement, by making the the value given to the constructor equal to the appropriate field, the school will be created.
    //The arraylist fields do not need to be initialized through the constructor.
    School(String schoolName, String schoolLocation, int numberOfStudents){
        this.schoolName = schoolName;
        this.schoolLocation= schoolLocation;
        this.numberOfStudents= numberOfStudents;
    }

    //Getters (gets the value of a field from outside this class)
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList getCourses() {
        return courses;
    }
    public String getSchoolName() {
        return schoolName;
    }
    public String getSchoolLocation() {
        return schoolLocation;
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    //Setters (sets the value of a field from outside this class)
    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void setCourses(ArrayList courses) {
        this.courses = courses;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName=schoolName;
    }
    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    //This method uses the arraylist method (add) to add a teacher into the teacher list (named teachers).
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //This method uses the arraylist method (add) to add a student into the student list (named students).
    public void addStudent(Student student){
        students.add(student);
    }

    //This method uses the arraylist method (remove) to remove a teacher from the teacher list (named teachers).
    public void deleteTeacher(Teacher teacher){
        teachers.remove(teacher);
    }

    //This method uses the arraylist method (remove) to remove a student from the student list (named students).
    public void deleteStudent(Student student){
        students.remove(student);
    }

    //This method uses a for loop to loop through the entire teacher list (named teachers) and print out every single teacher.
    public void showTeachers(){
        for(int i=0;i<teachers.size();i++){
            System.out.println(teachers.get(i));
        }
    }

    //This method uses a for loop to loop through the entire student list (named students) and print out every single student.
    public void showStudents(){
        for(int i = 0; i<students.size();i++){
            System.out.println(students.get(i));
        }
    }

}


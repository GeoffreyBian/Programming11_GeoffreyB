public class Main {
    public static void main(String[] args) {
        //This first line creates a new school and assigns it different fields with the constructor.
        School schoolOne= new School("Chel Secondary School", "30 Yonge St.", 713);

        //The next lines create new students and assign appropriate fields for the appropriate students with the constructor.
        Student studentOne=new Student("John", "Carlson", 11);
        Student studentTwo=new Student("Leon", "Draisaitl", 9);
        Student studentThree=new Student("Bobby", "Orr", 10);
        Student studentFour=new Student("Wayne", "Gretzky", 8);
        Student studentFive=new Student("Joe", "Thorton", 10);
        Student studentSix=new Student("Connor", "McDavid", 9);
        Student studentSeven=new Student("Alex", "Ovechkin", 12);
        Student studentEight=new Student("Brent", "Burns", 9);
        Student studentNine=new Student("Elias", "Peterson", 11);
        Student studentTen=new Student("Brad", "Marchand", 8);

        //The next lines use the addStudent method, we created in the school class, to add these students into a student list.
        schoolOne.addStudent(studentOne);
        schoolOne.addStudent(studentTwo);
        schoolOne.addStudent(studentThree);
        schoolOne.addStudent(studentFour);
        schoolOne.addStudent(studentFive);
        schoolOne.addStudent(studentSix);
        schoolOne.addStudent(studentSeven);
        schoolOne.addStudent(studentEight);
        schoolOne.addStudent(studentNine);
        schoolOne.addStudent(studentTen);

        //The next lines create new teachers and assign appropriate fields for the appropriate teachers with the constructor.
        Teacher teacherOne=new Teacher("Travis", "Green", "French");
        Teacher teacherTwo=new Teacher("Joel","Quenneville", "Math");
        Teacher teacherThree=new Teacher("Barry", "Trotz", "Social Studies");

        //The next lines use the addStudent method, we created in the school class, to add these students into a student list.
        schoolOne.addTeacher(teacherOne);
        schoolOne.addTeacher(teacherTwo);
        schoolOne.addTeacher(teacherThree);

        System.out.println("Here is a list of the students:");

        //This line uses the showStudents method from the school class to print the list of students.
        schoolOne.showStudents();

        System.out.println("______________________________________________" );
        System.out.println("Here is a list of the teachers:");

        //This line uses the showTeachers method from the school class to print the list of teachers.
        schoolOne.showTeachers();

        System.out.println("______________________________________________" );

        //This line uses the deleteStudent method from the school class, to remove the students we desire to remove.
        schoolOne.deleteStudent(studentOne);
        schoolOne.deleteStudent(studentTwo);

        //This line uses the deleteTeacher method from the school class, to remove the teachers we desire to remove.
        schoolOne.deleteTeacher(teacherOne);

        System.out.println("Here is a new list of the students:");
        schoolOne.showStudents();
        System.out.println("______________________________________________" );
        System.out.println("Here is a new list of the teachers:");
        schoolOne.showTeachers();
    }
}

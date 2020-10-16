public class Student extends Person {
    private String school;
    private int grade;
    private String number;

    public Student() {
        setFirstName("Unknown");
        setLastName("Name");
        setAddress("Unknown");
        setSchool("Unknown");
        setGrade(-1);
        setNumber("Unknown");
    }

    public Student(String fname, String lname, String add, String school, int grade, String number) {
        setFirstName(fname);
        setLastName(lname);
        setAddress(add);
        setSchool(school);
        setGrade(grade);
        setNumber(number);
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String lname) {
        this.school = lname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int gd) {
        this.grade = gd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String no) {
        this.number = no;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("School: " + getSchool());
        System.out.println("Grade: " + getGrade());
        System.out.println("Student Number: " + getNumber());
    }

    public static void main(String[] args) {
        String fname = "Hiroya";
        String lname = "Watanabe";
        String add = "Kyoto";
        String school = "Kyoto Institute of Technology";
        int gd = 3;
        String number = "18122508";

        Student student = new Student(fname, lname, add, school, gd, number);

        System.out.println("Name: " + student.getName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("School: " + student.getSchool());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Student Number: " + student.getNumber());
        System.out.println();

        student.print();
    }
}

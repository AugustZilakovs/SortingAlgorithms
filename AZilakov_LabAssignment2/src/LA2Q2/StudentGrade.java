package LA2Q2;
import java.util.Comparator;

public class StudentGrade implements Comparable<StudentGrade>{
    private String firstName;
    private String lastName;
    private double grade;
    StudentGrade(){}
    StudentGrade(String firstName, String lastName, double grade){
        this.firstName=firstName;
        this.lastName=lastName;
        this.grade=grade;
    }
    public void setLastName(String lastName){this.lastName=lastName;}
    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setGrade(double grade){this.grade=grade;}
    public String getLastName(){return this.lastName;}
    public String getFirstName(){return this.firstName;}
    public double getGrade(){return this.grade;}
    @Override
    public int compareTo(StudentGrade x) {
        if(this.getGrade()>x.getGrade())
            return (1);
        else if(this.getGrade()<x.getGrade())
            return (-1);
        else
            return 0;
    }
    @Override
    public String toString(){
        return String.format("%20s  :\t%s%n", this.firstName + " " + this.lastName,this.grade);
    }

    public static void printArray(){}

}

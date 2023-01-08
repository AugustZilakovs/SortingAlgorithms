package LA2Q2;


import java.util.Collections;
import java.util.Vector;

public class Augusts_SortNameAndGrade {
    public static void main(String[] args){
        header(2,1);

        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"}; String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};     Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26)};
        Vector<StudentGrade> sg = new Vector<>();//create vector

        for(int i=0;i<fnArray.length;i++){
            sg.addElement(new StudentGrade(fnArray[i],lnArray[i],grd[i]));//populate vector
        }
        StudentGrade[] sgArray = new StudentGrade[fnArray.length];
        sg.copyInto(sgArray);//create and populate array

        System.out.println("Unsorted Array: ");
        for(int i =0; i< fnArray.length;i++){
            System.out.print(sg.get(i).toString());
        }
        //sort using collection and print array
        System.out.println("\nSorted by Grades: ");
        Collections.sort(sg);
        for(int i =0; i< fnArray.length;i++){
            System.out.print(sg.get(i).toString());
        }
        //sort by first name and print array
        System.out.println("\nSorted by first names: ");
        sort(sgArray,1);
        for(int i =0; i< fnArray.length;i++) {
            System.out.print(sgArray[i].toString());
        }
        //sort by last name and print array
        System.out.println("\nSorted by first names: ");
        sort(sgArray,2);
        for(int i =0; i< fnArray.length;i++) {
            System.out.print(sgArray[i].toString());
        }
        footer(2,2);

    }
    public static void sort(StudentGrade[] a, int key){
        //check key
        if(key ==1){
            for(int i=1;i<a.length;i++){
                int j = i-1;
                StudentGrade x = a[i];
                //compare name originally at i to all j's to check where it sorts
                while((j>=0) && ((x.getFirstName().compareTo(a[j].getFirstName()))<0)){
                    //shift elements
                    a[j+1]=a[j];
                    j=j-1;
                }
                a[j+1]=x; //put x back into the array.

            }
        }
        if(key ==2){
            for(int i=1;i<a.length;i++){
                int j = i-1;
                StudentGrade x = a[i];
                //compare name originally at i to all j's to check where it sorts
                while((j>=0) && ((x.getLastName().compareTo(a[j].getLastName()))<0)){
                    //shift elements
                    a[j+1]=a[j];
                    j=j-1;
                }
                a[j+1]=x;//put x back into the array.

            }
        }
    }

    public static void footer(int x, int q){//footer
        System.out.printf("%15s%n","=========================================================");
        System.out.println("Completion of Lab Assignment " + x + ", "+q+" is successful!\nSigning off - Augusts.");
        System.out.printf("%15s%n","=========================================================");
    }
    public static void header(int x, int q){//header
        System.out.printf("%15s%n","=========================================================");
        System.out.println("Lab Exercise " + x+ " "+q);
        System.out.println("Prepared By: Augusts Zilakovs" +
                "\nStudent Number: 251223010" +
                "\nGoal of this Exercise: Implement various sorting algorithms and implement insertion sort to a real life problem. ");
        System.out.printf("%15s%n","=========================================================");
    }
}

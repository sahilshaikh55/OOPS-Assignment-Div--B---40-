
import java.util.Scanner;

class student_class1{
    private String studentName, studentID,Grade;
    private double assignmentOneMarks,assignmentTwoMarks, projectMarks, individualTotalMarks;

    student_class1(){
        final double P = 50.00;
        final double HD = 85.00;
    }
    student_class1(int i)
    {

    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }


    public void setAssignmentOneMarks(double assignmentOneMarks) {
        this.assignmentOneMarks = assignmentOneMarks;
    }

    public double getAssignmentOneMarks() {
        return assignmentOneMarks;
    }

    public void setAssignmentTwoMarks(double assignmentTwoMarks) {
        this.assignmentTwoMarks = assignmentTwoMarks;
    }

    public double getAssignmentTwoMarks() {
        return assignmentTwoMarks;
    }

    public void setProjectMarks(double projectMarks) {
        this.projectMarks = projectMarks;
    }

    public double getProjectMarks() {
        return projectMarks;
    }

    double calculateTotalMarks(double assignmentOneMarks, double assignmentTwoMarks, double projectMarks)
    {
        individualTotalMarks = assignmentOneMarks+assignmentTwoMarks+projectMarks;
        return individualTotalMarks;
    }

    public void setIndividualTotalMarks(double individualTotalMarks) {
        this.individualTotalMarks = individualTotalMarks;
    }

    public double getIndividualTotalMarks() {
        return individualTotalMarks;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getGrade() {
        return Grade;
    }

    String calculateGrade(double individualTotalMarks)
    {
        if(individualTotalMarks >= 85)
        {
            return "HD Grade";
        }
        else if(individualTotalMarks < 85 && individualTotalMarks >= 75)
        {
            return "D Grade";
        }
        else if(individualTotalMarks < 75 && individualTotalMarks >= 65)
        {
            return "C Grade";
        }
        else if(individualTotalMarks < 65 && individualTotalMarks >= 50)
        {
            return "P Grade";
        }
        else{
            return "F Grade";
        }
    }
}
public class GradingManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String st_name,st_ID,grade;
        double assignmentOneMarks,assignmentTwomarks,projectMarks,total;
        System.out.printf("\n|| WELCOME TO GRAD MANAGEMENT SYSTEM ||\n\n");
        System.out.printf("\n Enter No of students:");
        int n = sc.nextInt();
        student_class1 s[] = new student_class1[n];
        int choice,count=0;
        do {
            System.out.printf("\n 1. Enter Students Record \n 2. Display student information \n 3. Display Statistics \n 4. Exit the Application");
            System.out.printf("\n Enter choice:");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:

                    if(count == n){
                        System.out.printf("\n Maximum count reached");
                        break;
                    }
                    else {
                        System.out.printf("\n Enter Student Name:");
                        st_name = sc.nextLine();
                        while (st_name.isEmpty()) {
                            System.out.printf("\n ERROR student name cannot be blank");
                            System.out.printf("\n Enter Student Name:");
                            st_name= sc.nextLine();
                        }

                        System.out.printf("\n Enter Student ID:");
                        st_ID = sc.nextLine();
                        while (st_ID.isEmpty()) {
                            System.out.printf("\n ERROR student ID cannot be blank");
                            System.out.printf("\n Enter Student ID:");
                            st_ID = sc.nextLine();
                        }

                        System.out.printf("\n Enter Assignment 1 marks of student %s:", st_name);
                        assignmentOneMarks = sc.nextDouble();
                        while (assignmentOneMarks== 0) {
                            System.out.printf("\n Marks must be greater than 0");
                            System.out.printf("\n Enter Assignment 1 marks of student %s:", st_name);
                            assignmentOneMarks = sc.nextDouble();
                        }
                        while (assignmentOneMarks > 20) {
                            System.out.printf("\n Marks must be less than 20");
                            System.out.printf("\n Enter Assignment 1 marks of student %s:", st_name);
                            assignmentOneMarks = sc.nextDouble();
                        }

                        System.out.printf("\n Enter Assignment 2 marks of student %s:", st_name);
                        assignmentTwomarks = sc.nextDouble();
                        while (assignmentTwomarks == 0) {
                            System.out.printf("\n Marks must be greater than 0");
                            System.out.printf("\n Enter Assignment 2 marks of student %s:", st_name);
                            assignmentTwomarks = sc.nextDouble();
                        }
                        while (assignmentTwomarks > 30) {
                            System.out.printf("\n Marks must be less than 30");
                            System.out.printf("\n Enter Assignment 2 marks of student %s:", st_name);
                            assignmentTwomarks = sc.nextDouble();
                        }

                        System.out.printf("\n Enter Project marks of student %s:", st_name);
                        projectMarks = sc.nextDouble();
                        while (projectMarks == 0) {
                            System.out.printf("\n Marks must be greater than 0");
                            System.out.printf("\n Enter Project marks of student %s:", st_name);
                            projectMarks = sc.nextDouble();
                        }
                        while (projectMarks > 50) {
                            System.out.printf("\n Marks must be less than 50");
                            System.out.printf("\n Enter Project marks of student %s:", st_name);
                            projectMarks = sc.nextDouble();
                        }
                        for(int i=0;i<=count;i++)
                        {
                            s[count] = new student_class1();
                            s[count].setStudentName(st_name);
                            s[count].setStudentID(st_ID);
                            s[count].setAssignmentOneMarks(assignmentOneMarks);
                            s[count].setAssignmentTwoMarks(assignmentTwomarks);
                            s[count].setProjectMarks(projectMarks);
                            total = s[count].calculateTotalMarks(assignmentOneMarks,assignmentTwomarks,projectMarks);
                            grade = s[count].calculateGrade(total);
                            s[count].setIndividualTotalMarks(total);
                            s[count].setGrade(grade);
                        }
                        count++;
                        //total = s[i].calculateTotalMarks(assignmentOneMarks[i], assignmentTwomarks[i], projectMarks[i]);

                        //grade[i] = s[i].calculateGrade(total[i]);
                        //count++;
                    }


                    break;
                case 2:
                    if(count == 0)
                    {
                        System.out.printf("\n You must enter at least one record");
                        break;
                    }
                    else {
                        for (int i = 0; i < count; i++) {
                            System.out.printf("\n Student Name: %s \t Student ID: %s \t AssignmentOne Marks: %f \t AssignmentTwo Marks: %f \t Project Marks: %f \t Total Marks: %f \t Grade: %s", s[i].getStudentName(), s[i].getStudentID(), s[i].getAssignmentOneMarks(), s[i].getAssignmentTwoMarks(), s[i].getProjectMarks(), s[i].getIndividualTotalMarks(),s[i].getGrade());
                        }
                    }
                    break;

                case 3:

                    if(count == 0)
                    {
                        System.out.printf("\n You must enter at least one record");
                        break;
                    }else {
                        int max = 0, min = 0;
                        for (int i = 0; i < count; i++) {
                            if (s[i].getIndividualTotalMarks() > s[max].getIndividualTotalMarks()) {
                                max = i;
                            }
                        }
                        for (int i = 0; i < count; i++) {
                            if (s[i].getIndividualTotalMarks() < s[min].getIndividualTotalMarks()) {
                                min = i;
                            }
                        }
                        System.out.printf("\n The student %s with student number %s has received maximum marks which is %f", s[max].getStudentName(), s[max].getStudentID(), s[max].getIndividualTotalMarks());
                        System.out.printf("\n The student %s with student number %s has received minimum marks which is %f", s[min].getStudentName(), s[min].getStudentID(), s[min].getIndividualTotalMarks());

                        double avg, sum = 0;
                        for (int i = 0; i < count; i++) {
                            sum = sum + s[i].getIndividualTotalMarks();
                        }
                        avg = sum / count;
                        System.out.printf("\n The average marks of class is %f", avg);
                    }

                    break;

            }
        }while (choice != 4) ;
    }
}
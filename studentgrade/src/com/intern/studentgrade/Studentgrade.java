package com.intern.studentgrade;

import java.util.Scanner;
public class Studentgrade {

	public static void main(String[] args) {
		//using scanner class for getting the input from the user
		Scanner scan = new Scanner(System.in);
		//Getting the input from the user to know the number of subjects
		System.out.print("Enter the number of subjects: ");
        int numSubjects = scan.nextInt();
        
        //initializing the total marks is 0 in initial stage
        int totalMarks = 0;
        //using for loop for getting the marks for the subjects user entered in previous step
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scan.nextInt();
            totalMarks += marks;
        }
        
        //printing the total mark
        System.out.println("The total mark = "+totalMarks);
        //calculating the average percentage and printing it
        double average = (double) totalMarks / numSubjects;
        System.out.println("The average perentage is "+ average);
        
        //Finding the grade of the user using if-else statement and printing the grades to the user
		if(average>=90) {
			System.out.println("The student obtained a grade of A+");
		}
		else if(average>=80 && average<90){
			System.out.println("The student obtained a grade of A");
		}
		else if(average>=70 && average<80){
			System.out.println("The student obtained a grade of B+");
		}
		else if(average>=60 && average<70){
			System.out.println("The student obtained a grade of B");
		}
		else if(average>=50 && average<60){
			System.out.println("The student obtained a grade of C+");
		}
		else if(average>=40 && average<50){
			System.out.println("The student obtained a grade of C");
		}
		else if(average>=30 && average<40){
			System.out.println("The student obtained a grade of D");
		}
		else {
			System.out.println("The student failed in the exam");
		}
		}
	}

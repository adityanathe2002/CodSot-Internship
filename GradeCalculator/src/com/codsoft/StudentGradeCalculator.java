package com.codsoft;

import java.util.Scanner;

public class StudentGradeCalculator {

	static int numOfSubjects;
	static int[] marks;
	static int totalMarks;
	static double average ;
	static String grade;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.err.println("****** Student Grade Calculator ******\n");
		
		System.out.println("Enter the number of subjects: ");
		numOfSubjects = scanner.nextInt();

		marks = new int[numOfSubjects];
		totalMarks = 0;

		for (int i = 0; i < numOfSubjects; i++) {
			System.out.println("Enter Marks for Subjects " + (i + 1) + ": ");
			marks[i] = scanner.nextInt();
			totalMarks += marks[i];
		}

		average = totalMarks / (double) numOfSubjects;

		
		if (average >= 90) {
			grade = "A+";
		} else if (average >= 80) {
			grade = "A";
		} else if (average >= 70) {
			grade = "B";
		} else if (average >= 60) {
			grade = "C";
		} else if (average >= 50) {
			grade = "D";
		} else {
			grade = "E";
		}
		System.err.println("\n*** Results ***");
        System.out.println("Total Marks: " + totalMarks + "/" + (numOfSubjects * 100));
        System.out.println("Average Percentage: "+ average +"%");
        System.out.println("Grade: " + grade);
	}
}

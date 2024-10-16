package com.codsoft.SMS.Controller;

import java.util.List;
import java.util.Scanner;

import com.codsoft.SMS.dao.StudentDao;
import com.codsoft.SMS.dto.Student;

public class SMSController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao dao = new StudentDao();
		boolean smsloop = true;

		do {
			System.err.println("\n ⭐⭐⭐⭐ Welcome CodSoft School ⭐⭐⭐⭐ ");
			System.out.println("1.Create Student");
			System.out.println("2.Update Student");
			System.out.println("3.Delete Student");
			System.out.println("4.Fetch Student by RollNum");
			System.out.println("5.Fetch All Student");
			System.out.println("6.Exit ");
			System.out.print("Enter an Option: ");
			int option = scanner.nextInt();

			switch (option) {
			case 1: {
				System.err.println("***Add Student Data***");
				Student student = new Student();
				System.out.print("enter student name: ");
				student.setName(scanner.next());
				scanner.nextLine();
				System.out.print("enter student email : ");
				student.setEmail(scanner.next());
				System.out.print("enter student contact: ");
				student.setContact(scanner.nextLong());
				scanner.nextLine();
				System.out.print("enter Student location");
				student.setLocation(scanner.nextLine());
				System.out.print("enter student grade: ");
				student.setGrade(scanner.next());
				dao.addStudent(student);
				System.out.println("Student Added successfully");

			}
				break;

			case 2: {
				System.out.print("Enter Roll Number to update: ");
				int rollNumber = scanner.nextInt();
				Student student = dao.viewStudentByRoll(rollNumber);

				if (student != null) {
					boolean updating = true;
					while (updating) {
						System.err.println("\n**** Update Student ****");
						System.out.println("1. Update Name");
						System.out.println("2. Update Email");
						System.out.println("3. Update Contact");
						System.out.println("4. Update Location");
						System.out.println("5. Update Grade");
						System.out.println("6. Exit");
						System.out.print("Enter an option: ");
						int updateOption = scanner.nextInt();
						scanner.nextLine(); 

						switch (updateOption) {
						case 1:
							System.out.print("Enter new Name: ");
							student.setName(scanner.nextLine());
							dao.updateStudent(student);
							System.out.println("Name updated successfully.");
							break;

						case 2:
							System.out.print("Enter new Email: ");
							student.setEmail(scanner.nextLine());
							dao.updateStudent(student);
							System.out.println("Email updated successfully.");
							break;

						case 3:
							System.out.print("Enter new Contact: ");
							student.setContact(scanner.nextLong());
							scanner.nextLine(); 
							dao.updateStudent(student);
							System.out.println("Contact updated successfully.");
							break;

						case 4:
							System.out.print("Enter new Location: ");
							student.setLocation(scanner.nextLine());
							dao.updateStudent(student);
							System.out.println("Location updated successfully.");
							break;

						case 5:
							System.out.print("Enter new Grade: ");
							student.setGrade(scanner.nextLine());
							dao.updateStudent(student);
							System.out.println("Grade updated successfully.");
							break;

						case 6:
							updating = false; 
							System.out.println("Exiting update menu.");
							break;

						default:
							System.out.println("Invalid option! Please try again.");
						}
					}
				} 
				else 
				{
					System.out.println("Roll Number " + rollNumber + " not found.");
				}
			}
				break;

			case 3: {
				System.out.print("Enter Roll Number to delete: ");
				int rollNumber = scanner.nextInt();

				Student student = dao.viewStudentByRoll(rollNumber);
				System.out.println("Student Deleted successfully");

				if (student != null) {

					dao.deleteStudent(student);
					System.out.println("Student with Roll Number " + rollNumber + " has been deleted.");
				} else {

					System.out.println("Roll Number " + rollNumber + " not found.");
				}
			}
				break;

			case 4: {
				System.out.print("enter Roll Number: ");
				Student student = dao.viewStudentByRoll(scanner.nextInt());
				System.out.println(student);
			}
				break;

			case 5: {
				List<Student> students = dao.getAllStudents();
				for (Student student : students) {
					System.out.println(student);
					System.out.println("---------------");
				}
			}
			break;
			case 6:{
				System.out.println("Thank you for using CodSoft School Management System!");
                smsloop = false;
			}
				break;
			default:
				break;
			}
			 if (smsloop) {
	                System.out.print("\nEnter y to continue: ");
	            }

		} while ( smsloop && "y".equalsIgnoreCase(scanner.next()));
	}

}



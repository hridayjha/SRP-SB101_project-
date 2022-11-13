package Acess;

import java.util.Scanner;

import StudentDao.StudentDaoImp;

public class  Main{
	public static void main(String[] args) {
		
		
		StudentDaoImp ps= new StudentDaoImp();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose your option");
		System.out.println("1. for Aministrator");
		System.out.println("2. for Student");
		int choice=sc.nextInt();
		if(choice==1) {
			while(true) {
				System.out.println("Enter your choice");
				System.out.println("1.Add a new course");
				System.out.println("2.Update fees of course");
				System.out.println("3.Delete  a course from any Training session");
				System.out.println("4 Search information about a course.");
				System.out.println("5.Allocate students in a Batch under a course.");
				System.out.println("6.Update total seats of a batch.");
				System.out.println("7.View the students of every batch");
				System.out.println("8.Exit");
				int op=sc.nextInt();
				if(op==1) {  
					System.out.println("Enter course id");
					int id=sc.nextInt();
					System.out.println("Enter course name");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("Enter the avaialble seats");
					int seat=sc.nextInt();
					System.out.println("Enter fees");
					int fee=sc.nextInt();
					ps.addCourse(id, name, seat, fee);
				}
				else if(op==2) {
					System.out.println("Enter course id");
					int id=sc.nextInt();
					System.out.println("Enter fees");
					int fee=sc.nextInt();
					ps.updateFees(id, fee);
					
					
				}
				else if(op==3) {
					System.out.println("Enter course id that you want to delete");
					int id=sc.nextInt();
					ps.dltCor(id);
					
				}
				else if(op==4) {
					System.out.println("Enter course id that you want to get information about");
					int id=sc.nextInt();
					ps.corDet(id);
				}
				else if(op==5) {
					
					  System.out.println("enter student name");
					  String n = sc.next();
					  System.out.println("enter your email id");
					  String n1 = sc.next();
					  System.out.println("enter your password");
					 int pas=sc.nextInt();
					  
					  System.out.println("enter your batch id");
					  int bd = sc.nextInt();
					  
				ps.allocateStudent(n, n1, pas, bd);
					
				}
				else if(op==6) {
					System.out.println("Enter course id ");
					int id=sc.nextInt();
					System.out.println("Enter updated seats");
					int fee=sc.nextInt();
			      ps.updateSeat(id, fee);
					
				}
				else if(op==7) {
					ps.viewDet();
				}
				else if(op==8)break;
				else System.out.println("Invalid choice try again");
			
				
			}
			System.out.println("Thank you===");
			
		}
		
		else if(choice ==2) {
			while(true) {
			System.out.println("Enter your option");
			System.out.println("1.Registration");
			System.out.println("2.Update your profile");
			System.out.println("3.See the course detail");
			System.out.println("4.Exit");
			int op=sc.nextInt();
			if(op==1) {

				  System.out.println("enter student name");
				  String n = sc.next();
				  System.out.println("enter your email id");
				  String n1 = sc.next();
				  System.out.println("enter your password");
				 int pas=sc.nextInt();
				  
				  System.out.println("enter your batch id");
				  int bd = sc.nextInt();
				  
			ps.allocateStudent(n, n1, pas, bd);
				
			}
			else if(op==2) {
				
				System.out.println("Enter your choice---");
				System.out.println("1.name");
				System.out.println("2.Email");
				System.out.println("3.password");
				System.out.println("4.batch");
				int x=sc.nextInt();
				if(x==1) {
					System.out.println("Enter your roll number-----");
					int roll=sc.nextInt();
					System.out.println("Enter updated name");
					sc.nextLine();
					String name=sc.nextLine();
					ps.updateName(roll, name);
				}
				else if(x==2) {
					System.out.println("Enter your roll number-----");
					int roll=sc.nextInt();
					System.out.println("Enter updated email");
					
					String email=sc.next();
					ps.updaEmail(roll, email);
					
				}
				else if(x==3) {
					System.out.println("Enter your roll number-----");
					int roll=sc.nextInt();
					System.out.println("Enter updated password");
					
					int pass=sc.nextInt();
					ps.updatePassword(roll, pass);
					
				}
				
				
				else if(x==4) {
					System.out.println("Enter your roll number-----");
					int roll=sc.nextInt();
					System.out.println("Enter updated Batch id");
					
					int pass=sc.nextInt();
				ps.updateBatch(roll, pass);
					
				}
				else System.out.println("Invalid choice--");
				
			}
			else if(op==3)ps.courseDet();
			else if(op==4)break;
			else System.out.println("Invalid choice----");
			
			
		}
			System.out.println("thank yoou");
		}
	

	}
	

}

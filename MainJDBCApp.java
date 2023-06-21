package com.student;

import java.util.Scanner;

public class MainJDBCApp 
{
public static void main(String[] args) throws Exception
{
	int ch,ch1;
	Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println("<<<<<<<<<<WELCOME TO STUDENT MANAGEMENT SYSTEM>>>>>>>>>>");
	System.out.println();
	while(true) {
		System.out.println("Admin Login Or Student Login");
		System.out.println();
		System.out.println("1.ADMIN LOGIN \n2.STUDENT REGISTRATION \n3.STUDENT LOGIN");
		 System.out.println("===================================");
		ch=sc.nextInt();
		switch(ch){
		case 1:if(AdminOperation.AdminLogin())
		{
			System.out.println("Login Successfully..!!");
			System.out.println();
			System.out.println("******Welcome To Admin Dashboard*******");
			System.out.println();
			
		      while(true)
		      {
		    	  System.out.println("1.VIEW STUDENT \n2.DELETE STUDENT \n3.VIEW COURSE \n4.ADD COURSE \n5.DELETE COURSE \n6.UPDATE COURSE");
		    	  System.out.println("===================================");
		    	 ch1=sc.nextInt();
		    	 switch(ch1)
		    	 {
		    	 case 1:AdminOperation.viewStudents();
		    		 break;
		    	 case 2:AdminOperation.deleteStudent();
		    	     break;
		    	 case 3:AdminOperation.viewCourse();
		    	     break;
		    	 case 4:AdminOperation.addCourse();
		    	     break;
		    	 case 5:AdminOperation.deleteCourse();
		    	     break;
		    	 case 6:AdminOperation.updateCourse();
	    	     break;
		    	 }
		    	 System.out.println();
		    		System.out.println("'Admin' Do you want to Perform Other Operation Press 'y' for Yess AND Press 'N' for No");
		    		   char choice=sc.next().charAt(0);
		    		   if(choice=='n') 
		    		   {
		    			   break;
		    		   }
		    	 
		      }//while
		}
		else
		{
			System.out.println("Incorrct Login ");
		}
		  
		break;
		case 2:if(StudentOperations.StudRegistration())
		{
			System.out.println("Successfully Registrated..Please login");
		}
		else
		{
			System.out.println("Student Already Registered...Please Login");
		}
		      
		      break;
		         
		case 3:if(StudentOperations.Studlogin())
		{
			System.out.println("Login Successfully..!!");
			System.out.println();
			System.out.println("******Welcome To Student Dashboard*******");
			System.out.println();
			while(true)
			{
				System.out.println("1.VIEW PROFILE \n2.UPDATE PROFILE \n3.ENROLL COURSE \n4.VIEW ENROLL COURSE");
				 System.out.println("===================================");
				ch1=sc.nextInt();
				switch(ch1)
				{
				case 1:StudentOperations.ViewProfile();
					break;
				case 2:StudentOperations.UpdateProfile();
					break;
				case 3:StudentOperations.CourseEnroll();
				    break;
				case 4:StudentOperations.ViewEnrolledCourse();
				    break;
				}
				System.out.println();
				System.out.println("'Student' Do you want to Perform Other Opearion Press 'y' for continue AND 'n' for stop");
	    		   char choice=sc.next().charAt(0);
	    		   if(choice=='n') 
	    		   {
	    			   break;
	    		   }
			}
		}
		else
		{
			System.out.println("Incorrect Credentials..!! Or first Registered your self");
		}
		      break;
		
		}//switch
//		System.out.println("Do you Want To Login...Press 'y' for Yess AND Press 'N' for No");
//	   char choice=sc.next().charAt(0);
//	   if(choice=='n') {
//		   break;
//	   }
	}//while

}//main
}

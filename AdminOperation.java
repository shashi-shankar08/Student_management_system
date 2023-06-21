package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminOperation 
{
   static Connection con;
   static String course_name;
   static String Duration;
   static float course_fee;
   static String Email_id,Password;
   public static boolean AdminLogin() throws Exception {
		
		con=DatabaseConnection.getConnection();
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Email Id:");
		Email_id=sc.next();
		pst=con.prepareStatement("select * from  AdminLogin where Email_id=?");
	    pst.setString(1,Email_id );
	    ResultSet rs=pst.executeQuery();
	    
		if(rs.next())
		{
				System.out.println("Enter the Password:");
				Password=sc.next();
		
			if(rs.getString(2).contentEquals(Email_id) && rs.getString(3).contentEquals(Password))
			{
				return true;
//				System.out.println("Login succefully");
			}
			else
			{
				return false;
				//System.out.println("Password Wrong...!!");
			
			}
		}	
		else
		
			//System.out.println("Email Id not present Wrong...!!");
		return false;
	}
	public static void viewStudents() throws Exception 
	{
	con=DatabaseConnection.getConnection();
	PreparedStatement pst=con.prepareStatement("select * from Student_Registration");
	ResultSet rs=pst.executeQuery();
	System.out.println("STUD_ID\t\tEMAIL ID\t\tPASSWORD\tNAME\tMOBILE\t\tAGE\tADDRESS\tDOB\t\t GENDER");
	System.out.println("..........................................................................................................................");
	while(rs.next())
	{
		
		System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)
		+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
	}

	
	
	}
	
	public static void viewCourse() throws Exception 
	{
	con=DatabaseConnection.getConnection();
	PreparedStatement pst=con.prepareStatement("select * from course");
	ResultSet rs=pst.executeQuery();
	System.out.println("CID\tCOURSE NAME\tDuration\tFee");
	System.out.println("......................................................");
	while(rs.next())
	{
		
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getFloat(4));
	}
	}
	
	public static void addCourse() throws Exception 
	{	
		con=DatabaseConnection.getConnection();
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the course ID:");
		int cid=sc.nextInt();
		pst=con.prepareStatement("select * from course where cid=?");
		pst.setInt(1, cid);
		ResultSet rs=pst.executeQuery();
		if(!rs.next())
		{

			System.out.println("Enter the Course Name:");
			course_name=sc.next();
			System.out.println("Enter the Course Duration:");
			Duration=sc.next();
			System.out.println("Enter the Course fee:");
			course_fee=sc.nextFloat();
			
			pst=con.prepareStatement("insert into course values(?,?,?,?)");
			pst.setInt(1, cid);
			pst.setString(2, course_name);
			pst.setString(3, Duration);
			pst.setFloat(4, course_fee);
			int k=pst.executeUpdate();
			if(k>0)
			{
				System.out.println("Course Inserted SuccessFully!!");
			}
			
		}
		else
		{
			System.out.println("Course ID already Presents");
		}
	}
	public static void deleteCourse() throws Exception 
	{
		con=DatabaseConnection.getConnection();
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Course Id To delete the Course:");
		int cid=sc.nextInt();
		pst=con.prepareStatement("select * from course where cid=?");
		pst.setInt(1, cid);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			pst=con.prepareStatement("delete from course where cid=?");
			pst.setInt(1, cid);
			int k=pst.executeUpdate();
			if(k>0)
			{
				System.out.println("Course Deleted Successfully...!!");
			}
			
		}
		else
		{
			System.out.println("Course Not Present");
		}
}
	public static void deleteStudent() throws Exception 
	{
		con=DatabaseConnection.getConnection();
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Id To delete the Student:");
		int Stud_id=sc.nextInt();
		pst=con.prepareStatement("select * from Student_Registration where Stud_id=?");
		pst.setInt(1, Stud_id);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			pst=con.prepareStatement("delete from Student_Registration where Stud_id=?");
			pst.setInt(1, Stud_id);
			int k=pst.executeUpdate();
			if(k>0)
			{
				System.out.println("Student Record Deleted Successfully...!!");
			}
			
		}
		else
		{
			System.out.println("Student Record Not Present");
		}
	}
	public static void updateCourse() throws Exception 
	{
		con=DatabaseConnection.getConnection();
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Course Id To Update the Course:");
		int cid=sc.nextInt();
		pst=con.prepareStatement("select * from course where cid=?");
		pst.setInt(1, cid);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			while(true)
			{
				 System.out.println("Which Feild do you want to update");
				 System.out.println("====================================");
					System.out.println("1 UPDATE COURSE NAME  \n2 UPDATE COURSE DURATION \n3 UPDATE COURSE FEE");
					int ch=sc.nextInt();
			   switch(ch)	
			   {
			   case 1:System.out.println("enter the Course Name To update");
			         course_name=sc.next();
				String str="update course set course_name=? where cid=?";
				  
				 pst=con.prepareStatement(str);
				 pst.setString(1, course_name);
				 pst.setInt(2, cid);
				   int k=pst.executeUpdate();
				   if(k>0)
				   {
					   System.out.println("Record Updated Succesfully");
				   }
				   else
				   {
					   System.out.println("Not Updated...");
				   }
				   
				   break;
				   
			   case 2:System.out.println("enter the Course Duration");
		         Duration=sc.next();
	               str="update course set Duration=? where cid=?";
			  
			 pst=con.prepareStatement(str);
			 pst.setString(1, Duration);
			 pst.setInt(2, cid);
			   k=pst.executeUpdate();
			   if(k>0)
			   {
				   System.out.println("Record Updated Succesfully");
			   }
			   else
			   {
				   System.out.println("Not Updated...");
			   }
			   
			   break;
			   
			   
			   case 3:System.out.println("enter the Course Fees");
		         course_fee=sc.nextFloat();
	               str="update course set course_fee=? where cid=?";
			  
			 pst=con.prepareStatement(str);
			 pst.setFloat(1, course_fee);
			 pst.setInt(2, cid);
			   k=pst.executeUpdate();
			   if(k>0)
			   {
				   System.out.println("Record Updated Succesfully");
			   }
			   else
			   {
				   System.out.println("Not Updated...");
			   }
			   
			   break;
			   }
			   System.out.println();
			   System.out.println("Want to Update Other Records...Press 'y' for Yess AND Press 'N' for No");
				char choice=sc.next().charAt(0);
				if(choice=='n')
				{
					break;
				}
			}
		}
		else
		{
			System.out.println("Course ID Not Present");
		}
	}
	
	 
}

package com.student;

import java.sql.*;
import java.util.Scanner;
public class StudentOperations {

static Connection con;
static String Email_id,Password,Full_Name,Mobile_No,Address,Gender,Date_Of_Birth;
static int age,Stud_id;

public static boolean StudRegistration() throws Exception
{
	con=DatabaseConnection.getConnection();
	PreparedStatement pst;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Email Id:");
	Email_id=sc.next();
	pst=con.prepareStatement("select * from  Student_Registration where Email_id=?");
    pst.setString(1,Email_id );
    
     ResultSet rs=pst.executeQuery();
     if(!rs.next())
     {
    	 System.out.println("Enter the Password:");
    	 Password=sc.next();
    	 System.out.println("Enter the Name:");
    	 Full_Name=sc.next();
    	 System.out.println("Enter the Mobile Number:");
    	 Mobile_No=sc.next();
    	 System.out.println("Enter the Age:");
    	 age=sc.nextInt();
    	 System.out.println("Enter the Address:");
    	 Address=sc.next();
    	 System.out.println("Enter the Date Of Birth:");
    	 Date_Of_Birth=sc.next();
    	 System.out.println("Enter the Gender:");
    	 Gender=sc.next();
    	 pst=con.prepareStatement("insert into Student_Registration(Email_id,Password,Full_Name,Mobile_No,age,Address,Date_Of_Birth, Gender) values(?,?,?,?,?,?,?,?) ");
    	 pst.setString(1, Email_id);
    	 pst.setString(2, Password);
    	 pst.setString(3, Full_Name);
    	 pst.setString(4, Mobile_No);
    	 pst.setInt(5, age);
    	 pst.setString(6, Address);
    	 pst.setString(7, Date_Of_Birth);
    	 pst.setString(8, Gender);
    	 
    	 int k=pst.executeUpdate();
    	   if(k>0)
    	 {
//    		System.out.println("Record Insertted successfully"); 
    		   return true;
    	 }
    	   else
    	   {
    		   return false;  
    	   }
    	 
     }
     else
    	// System.out.println("Student Email Already Presents");
      
	
	return false;

}

public static boolean Studlogin() throws Exception
{
	con=DatabaseConnection.getConnection();
	PreparedStatement pst;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Email Id:");
	Email_id=sc.next();
	pst=con.prepareStatement("select * from  Student_Registration where Email_id=?");
    pst.setString(1,Email_id );
    ResultSet rs=pst.executeQuery();
    
	if(rs.next())
	{
			System.out.println("Enter the Password:");
			Password=sc.next();
	
		if(rs.getString(2).contentEquals(Email_id) && rs.getString(3).contentEquals(Password))
		{
			return true;
			//System.out.println("Login succefully");
		}
		else
		{
			return false;
			//System.out.println("Password Wrong....First Register Your self");
		}
	}	
	else
	
		//System.out.println("Email sId not present Wrong....First Register Your self");
	
	return false;
}

public static void CourseEnroll() throws SQLException
{
       
   		Scanner sc=new Scanner(System.in);
   		PreparedStatement pst;
   		System.out.println("Which Course Do You Want To Do");
   		pst=con.prepareStatement("select * from course ");
   		ResultSet rs=pst.executeQuery();
   		System.out.println("ID\tCName\tDuration\tFee");
   		System.out.println("---------------------------------------");
   		String Email_id=StudentOperations.Email_id;
   		while(rs.next())
   		{
   			
   			System.out.println(rs.getInt(1)+"=   "+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
   			
   		}
   		while(true)
			{
   			System.out.println("Enter Your choice:");
				int ch1=sc.nextInt();
	   			switch(ch1)
	   			{
	   			case 111:
	   				pst=con.prepareStatement("select Stud_id from Student_Registration where Email_id=?");
	   			
	   				pst.setString(1, Email_id);
	   				ResultSet rs1=pst.executeQuery();
	   
	   				while(rs1.next())
	   				{
	   					Stud_id=rs1.getInt(1);
	   				}
	   				int Cid=111;
	   				System.out.println("Pay course fee");
	   				float fees=sc.nextFloat();
	   				pst=con.prepareStatement("insert into EnrollCourse(Stud_id,Cid,fees) values(?,?,?)");
	   				pst.setInt(1, Stud_id);
	   				pst.setInt(2, Cid);
	   				pst.setFloat(3, fees);
	   		        int k=pst.executeUpdate();
	   		     if(k>0)
	   		        {
	   		        	System.out.println("Course Enroll Successfully.........!!");
	   		        }
	   		        else
	   		        {
	   		        	System.out.println("Not Enroll");
	   		        }
	   				break;
	   				
	   			case 222:
	   				pst=con.prepareStatement("select Stud_id from Student_Registration where Email_id=?");
		   			
	   				pst.setString(1, Email_id);
	   				rs1=pst.executeQuery();
	   
	   				while(rs1.next())
	   				{
	   					Stud_id=rs1.getInt(1);
	   				}
	   			     Cid=222;
	   				System.out.println("Pay course fee");
	   				fees=sc.nextFloat();
	   				pst=con.prepareStatement("insert into EnrollCourse(Stud_id,Cid,fees) values(?,?,?)");
	   				pst.setInt(1, Stud_id);
	   				pst.setInt(2, Cid);
	   				pst.setFloat(3, fees);
	   		         k=pst.executeUpdate();
	   		     if(k>0)
	   		        {
	   		        	System.out.println("Course Enroll Successfully.........!!");
	   		        }
	   		        else
	   		        {
	   		        	System.out.println("Not Enroll");
	   		        }
	   				break;
	   				
	   			case 333:
                    pst=con.prepareStatement("select Stud_id from Student_Registration where Email_id=?");
		   			
	   				pst.setString(1, Email_id);
	   				rs1=pst.executeQuery();
	   
	   				while(rs1.next())
	   				{
	   					Stud_id=rs1.getInt(1);
	   				}
	   			     Cid=333;
	   				System.out.println("Pay course fee");
	   				fees=sc.nextFloat();
	   				pst=con.prepareStatement("insert into EnrollCourse(Stud_id,Cid,fees) values(?,?,?)");
	   				pst.setInt(1, Stud_id);
	   				pst.setInt(2, Cid);
	   				pst.setFloat(3, fees);
	   		         k=pst.executeUpdate();
	   		     if(k>0)
	   		        {
	   		        	System.out.println("Course Enroll Successfully.........!!");
	   		        }
	   		        else
	   		        {
	   		        	System.out.println("Not Enroll");
	   		        }
	   				break;
	   				
	   				
	   			case 444:
                    pst=con.prepareStatement("select Stud_id from Student_Registration where Email_id=?");
		   			
	   				pst.setString(1, Email_id);
	   				rs1=pst.executeQuery();
	   
	   				while(rs1.next())
	   				{
	   					Stud_id=rs1.getInt(1);
	   				}
	   			     Cid=444;
	   				System.out.println("Pay course fee");
	   				fees=sc.nextFloat();
	   				pst=con.prepareStatement("insert into EnrollCourse(Stud_id,Cid,fees) values(?,?,?)");
	   				pst.setInt(1, Stud_id);
	   				pst.setInt(2, Cid);
	   				pst.setFloat(3, fees);
	   		         k=pst.executeUpdate();
	   		     if(k>0)
	   		        {
	   		        	System.out.println("Course Enroll Successfully.........!!");
	   		        }
	   		        else
	   		        {
	   		        	System.out.println("Not Enroll");
	   		        }
	   				break;
	   				
	   				
	   			case 555:
                    pst=con.prepareStatement("select Stud_id from Student_Registration where Email_id=?");
		   			
	   				pst.setString(1, Email_id);
	   				rs1=pst.executeQuery();
	   
	   				while(rs1.next())
	   				{
	   					Stud_id=rs1.getInt(1);
	   				}
	   			     Cid=555;
	   				System.out.println("Pay course fee");
	   				fees=sc.nextFloat();
	   				pst=con.prepareStatement("insert into EnrollCourse(Stud_id,Cid,fees) values(?,?,?)");
	   				pst.setInt(1, Stud_id);
	   				pst.setInt(2, Cid);
	   				pst.setFloat(3, fees);
	   		         k=pst.executeUpdate();
	   		     if(k>0)
	   		        {
	   		        	System.out.println("Course Enroll Successfully.........!!");
	   		        }
	   		        else
	   		        {
	   		        	System.out.println("Not Enroll");
	   		        }
	   				break;
	   				
	   				
	   			case 666:
                    pst=con.prepareStatement("select Stud_id from Student_Registration where Email_id=?");
		   			
	   				pst.setString(1, Email_id);
	   				rs1=pst.executeQuery();
	   
	   				while(rs1.next())
	   				{
	   					Stud_id=rs1.getInt(1);
	   				}
	   			     Cid=666;
	   				System.out.println("Pay course fee");
	   				fees=sc.nextFloat();
	   				pst=con.prepareStatement("insert into EnrollCourse(Stud_id,Cid,fees) values(?,?,?)");
	   				pst.setInt(1, Stud_id);
	   				pst.setInt(2, Cid);
	   				pst.setFloat(3, fees);
	   		         k=pst.executeUpdate();
	   		     if(k>0)
	   		        {
	   		        	System.out.println("Course Enroll Successfully.........!!");
	   		        }
	   		        else
	   		        {
	   		        	System.out.println("Not Enroll");
	   		        }
	   				break;
	   				
	   			}
	   			System.out.println();
	   		System.out.println("Want to Enroll Other Courses....Press 'n' for No and Press 'y' for Yes");
		char choice=sc.next().charAt(0);
		if(choice=='n')
		{
			break;
		}
			}	
   		}
   		


public static void ViewEnrolledCourse() throws Exception
{
	PreparedStatement pst;
	String Email_id=StudentOperations.Email_id;
	pst=con.prepareStatement("select Full_Name,Mobile_No,Email_id,course_name,Duration, course_fee from Student_Registration s,course c,EnrollCourse e where Email_id=? AND s.Stud_id=e.Stud_id AND c.Cid=e.Cid");
    pst.setString(1, Email_id);
    ResultSet rs=pst.executeQuery();
    System.out.println("FULL NAME\tMOBILE_NO\tEMAIL_ID\t\tCOURSE_NAME\tDURATION\tCOURSE_FEE");
    System.out.println("...................................................................................................");
    while(rs.next())
    {
    	System.out.println(rs.getString("Full_Name")+"\t\t"+rs.getString("Mobile_No")+"\t"+rs.getString("Email_id")+"\t"+rs.getString("course_name")+"\t\t"+rs.getString("Duration")+"\t"+rs.getFloat("course_fee"));
    	
    }
}

public static void ViewProfile() throws Exception 
{
	con=DatabaseConnection.getConnection();
	PreparedStatement pst;
	Scanner sc=new Scanner(System.in);
	String Email_id=StudentOperations.Email_id;
	pst=con.prepareStatement("select * from Student_Registration where Email_id=?");
	pst.setString(1, Email_id);
	ResultSet rs=pst.executeQuery();
	System.out.println("ID\tEMAIL_ADDRESS\t\tPASSWORD\tNAME\tMOBILE_NUMBER\tAGE\tADDRESS\t\tDATE_OB\t\tGENDER");
	System.out.println(".........................................................................................................................");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getString(7)+"\t\t"+rs.getString(8)+"\t"+rs.getString(9));
	}
}

public static void UpdateProfile() throws Exception
{
	con=DatabaseConnection.getConnection();
	//create a statement object
			Statement st=con.createStatement();
			Scanner sc=new Scanner(System.in);
			String Email_id=StudentOperations.Email_id;
			int ch;
			PreparedStatement pst;
			pst=con.prepareStatement("select * from Student_Registration where Email_id=?");
			pst.setString(1, Email_id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				while(true)
				{
				    System.out.println("Which Feild do you want to update");
				    System.out.println();
					System.out.println("1 UPDATE NAME  \n2 UPDATE PASSWORD \n3 UPDATE MOBILE NUMBER \n4 AGE \n5 ADDRESS \n6 DATE_Of_BIRTH \n7 GENDER");
					 System.out.println("===================================");
					ch=sc.nextInt();
					
					switch(ch)
					{
					case 1: 
						System.out.println("enter the ename");
						Full_Name=sc.next();
						 String str="update Student_Registration set Full_Name=? where Email_id=?";
						   //System.out.println(str);
						 pst=con.prepareStatement(str);
						 pst.setString(1, Full_Name);
						 pst.setString(2, Email_id);
						   int k=pst.executeUpdate();
						   if(k>0)
						   {
							   System.out.println("Record Updated Succesfully");
						   }
						   else
						   {
							   System.out.println("Not Updated....");
						   }
						break;
						
//					case 2:
//						System.out.println("enter the Email");
//						String Email=sc.next();
//						 str="update Student_Registration set Email_id=? where Email_id=?";
//						 
//						  // System.out.println(str);
//						 pst=con.prepareStatement(str);
//						 pst.setString(1, Email_id);
//						 pst.setInt(2, _id);
//						   k=pst.executeUpdate();
//						   if(k>0)
//						   {
//							   System.out.println("Record Updated Succesfully");
//						   }
//						   else
//						   {
//							   System.out.println("Not Updated...");
//						   }
//						break;
						
					case 2:
						System.out.println("enter the Password");
						Password=sc.next();
						 str="update Student_Registration set Password=? where Email_id=?";
						  // System.out.println(str);
						 pst=con.prepareStatement(str);
						 pst.setString(1, Password);
						 pst.setString(2, Email_id);
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
					 
						   
					case 3:
						System.out.println("enter the Mobile number");
						Mobile_No=sc.next();
						 str="update Student_Registration set Mobile_No=? where Email_id=?";
						  // System.out.println(str);
						 pst=con.prepareStatement(str);
						 pst.setString(1, Mobile_No);
						 pst.setString(2, Email_id);
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
						   
					case 4:
						System.out.println("enter the Age");
						age=sc.nextInt();
						 str="update Student_Registration set age=? where Email_id=?";
						  // System.out.println(str);
						 pst=con.prepareStatement(str);
						 pst.setInt(1, age);
						 pst.setString(2, Email_id);
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
						   
					case 5:
						System.out.println("enter the Address");
						Address=sc.next();
						 str="update Student_Registration set Address=? where Email_id=?";
						  // System.out.println(str);
						 pst=con.prepareStatement(str);
						 pst.setString(1, Address);
						 pst.setString(2, Email_id);
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
						   
					case 6:
						System.out.println("enter the Date_Of_Birth");
						Date_Of_Birth=sc.next();
						 str="update Student_Registration set Date_Of_Birth=? where Email_id=?";
						  // System.out.println(str);
						 pst=con.prepareStatement(str);
						 pst.setString(1,Date_Of_Birth);
						 pst.setString(2, Email_id);
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
						   
					case 7:
						System.out.println("enter the Gender");
						Gender=sc.next();
						 str="update Student_Registration set Gender=? where Email_id=?";
						  // System.out.println(str);
						 pst=con.prepareStatement(str);
						 pst.setString(1,Gender);
						 pst.setString(2, Email_id);
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
				System.out.println("ID Not Present");
			}
			
	
}


}

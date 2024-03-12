package luckMan;

import java.sql.*;

import java.util.*;



public class MainClass {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Scanner sc = new Scanner(System.in);
	int no=0;
	do{
		
		Random r = new Random();
		int [] sgn = new int[4];
//		system generated no and stort it 
		for (int i = 0; i < sgn.length; i++) {
			sgn[i]=(r.nextInt(10));
			
		}
//		System.out.println(Arrays.toString(sgn));
		
		System.out.println("Enter your the Name: ");
		String Name = sc.nextLine();
		int point=0;
		int uin [] = new int[4];
		for (int i = 0; i < uin.length; i++) {
			System.out.print("Enter the Number: ");
			uin[i]=sc.nextInt();
			//check input and system generate no
			
			if(uin[i]==sgn[i])
			{   point+=10;
				System.out.println("congulation your Luck Man you got "+point+" points.");
				
			}
			else{
				System.out.println("sorry your are unlucky.plz try agin");
			}
		}
//		 jdbc
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		   
		   CallableStatement p = c.prepareCall("insert into details values(?,?,?,?)");
		   
		   p.setString(1, Name);
		   p.setString(2, Arrays.toString(sgn));
//		   to convert the array into String
		   p.setString(3, Arrays.toString(uin));
		   p.setInt(4, point);
		   
		   p.executeUpdate();
		   c.close();
		
	
		System.out.println("Quite for game press 0");
		System.out.println("contines for press graher 0 vlues");
		no=sc.nextInt();
	}while(no!=0);
	
	
}

}

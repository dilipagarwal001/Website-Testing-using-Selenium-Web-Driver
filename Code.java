package Testing;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Code
{
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost/E-tuitions/index.php");
		
		
		// Checking for logo link is working or not  in navbar
		
		System.out.println("\n  Test Case:"+ 1 + "\n  Checking that 'Logo' is working or not\n");
		driver.findElement(By.className("navbar-brand")).click();
		String URL1 = driver.getCurrentUrl();
		if(URL1.equals("http://localhost/E-tuitions/"))
			System.out.println("  The Logo is working. It successfully navigates To Home page");
		else
			System.out.println("  The logo is not working. Some Error was occurred");
		System.out.println("------------------------------------------------------------------------------------------------------------------\n");
		

		// Checking for Internal links for More Teachers is working or not  on homepage
		
		System.out.println("  Test Case 2: \n  Checking For 'More Teachers' is internal link Or external link");
		try
		{
			driver.findElement(By.linkText("More Teachers")).click();
			String URL3 = driver.getCurrentUrl();
			if (URL3.contains("E-tuitions"))
				System.out.println("  It is an Internal Link - Redirecting to another page in the Same Application - Passed");
		}
		catch  (NoSuchElementException e) { 
			System.out.println("  It is an External Link - Redirecting to another page in different Application - Failed");}
		System.out.println("------------------------------------------------------------------------------------------------------------------\n");
		
		
		// Checking for View Profile Link is working or not in search students page
		
		System.out.println("  Test Case:"+ 3 + "\n  Checking that 'view profile link' is working or not in search Teacher page  \n");
		driver.findElement(By.linkText("View Profile")).click();
		String URL7 = driver.getCurrentUrl();
		if(URL7.equals("http://localhost/E-tuitions/studentlogin.php"))
			System.out.println("  The link is working. It successfully navigates To student login page");
		else
			System.out.println("The link is not working. Some Error was occurred");
		System.out.println("------------------------------------------------------------------------------------------------------------------\n");
		
		
		driver.get("http://localhost/E-tuitions/");
		
		// Checking for Internal link of More Students is working or not  on homepage
		
		System.out.println("  Test Case 4: \n  Checking For 'More Students' is internal link or external link");
		try
		{
			driver.findElement(By.linkText("More Students")).click();
			String URL2 = driver.getCurrentUrl();
			if (URL2.contains("E-tuitions"))
				System.out.println("  It is an Internal Link - Redirecting to another page in the Same Application - Passed");
		}
		catch (NoSuchElementException e) { 
			System.out.println("  It is an External Link - Redirecting to another page in different Application - Failed");}
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		
		// Checking for View Profile Link is working or not in search students page
		System.out.println("\n  Test Case:"+ 5 + "\n  Checking that 'view profile link' is working or not in search students page  \n");
		driver.get("http://localhost/E-tuitions/students.php");
		driver.findElement(By.linkText("View Profile")).click();
		String URL6 = driver.getCurrentUrl();
		if(URL6.equals("http://localhost/E-tuitions/teacherlogin.php"))
			System.out.println("  The link is working. It successfully navigates To teacher login page");
		else
			System.out.println("The link is not working. Some Error was occurred");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		

		// Checking for About Us Link is working or not  in navbar
		
		System.out.println("\n  Test Case:"+ 6 + "\n  Checking that 'About Us link' is working or not\n");
		driver.findElement(By.linkText("About Us")).click();
		URL1 = driver.getCurrentUrl();
		if(URL1.equals("http://localhost/E-tuitions/aboutus.php"))
			System.out.println("  The About Us Page is working. It successfully navigates To About Us page");
		else
			System.out.println("  The About Us link is not working. Some Error was occurred");
		System.out.println("------------------------------------------------------------------------------------------------------------------\n");


		// Checking for Reach Us Link is working or not  in navbar
		System.out.println("  Test Case:"+ 7 + "\n  Checking that 'Reach Us link' is working or not\n");
		driver.findElement(By.linkText("Reach Us")).click();
		URL1 = driver.getCurrentUrl();
		if(URL1.equals("http://localhost/E-tuitions/contactus.php"))
			System.out.println("  The Reach Us Page is working. It successfully navigates To Contact Us page");
		else
			System.out.println("  The Reach Us link is not working. Some Error was occurred");
		
		//  Now Test will start for teacher login Input Section
		
		int i=8;
		System.out.println("\n\n========================== Now The Test will start for Teacher Login Input Section  ===========================");
		teacherLoginLoop: while(true)
		{
			Scanner obj = new Scanner(System.in);
			System.out.println("\nPress 1: For Test Teacher Login");
			System.out.println("Press 2: For Exit From Teacher Login Section");
			System.out.print("\nPut Your Choice Here: ");
			int choice=obj.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("\n---------------------------------------------------------------------------------------------------------\n");
					System.out.println("  Test Case:"+ i + "\n  Checking For 'Teacher Login' is valid or not\n");
					driver.get("http://localhost/E-tuitions/teacherlogin.php");
					Scanner sc = new Scanner(System.in);
					
					System.out.print("  Enter UserId: ");
					String userid = sc.nextLine();
					
					System.out.print("  Enter Password: ");
					String password = sc.nextLine();
		
					driver.findElement(By.className("teacherid")).sendKeys(userid);
					driver.findElement(By.className("teacherpassword")).sendKeys(password);
					driver.findElement(By.id("go")).click();
					String URL4 = driver.getCurrentUrl();
					if (URL4.contains("afterteacherlogin.php"))
					{
							System.out.println("\n  Login Successful!!"); 
							System.out.println("\n-------------------------------------------------------------------------------------------");
					}
					else 
					{
						System.out.println("\n  Login Unsuccessful!!"); 
						System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
					} 
					i++;
					break;
				case 2:
					break teacherLoginLoop;
				default:
					System.out.print("\nPlease Choose From Given Choice Only");
			}
		}
		
		
		//  Test will start for Student login Input Section
		
		System.out.println("\n========================== Now the test will start for Student Login Input Section ===========================\n");
		studentLoginLoop: while(true)
		{
			Scanner obj = new Scanner(System.in);
			System.out.println("\nPress 1: For Test Student Login");
			System.out.println("Press 2: For Exit From Student Login Section");
			System.out.print("\nPut Your Choice Here: ");
			int choice=obj.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("\n-------------------------------------------------------------------------------------------------------------------------\n");
					System.out.println("  Test Case:"+ i + "\n  Checking For 'Teacher Login' is valid or not\n");
					driver.get("http://localhost/E-tuitions/studentlogin.php");
					System.out.print("  Enter UserId: ");
					Scanner sc = new Scanner(System.in);
					String userid = sc.nextLine();
					System.out.print("  Enter Password: ");
					String password = sc.nextLine();
		
					driver.findElement(By.className("teacherid")).sendKeys(userid);
					driver.findElement(By.className("teacherpassword")).sendKeys(password);
					driver.findElement(By.id("go")).click();
					String URL5 = driver.getCurrentUrl();
					if (URL5.contains("afterstudentlogin.php"))
					{
							System.out.println("\n  Login Successful!!"); 
							System.out.println("\n-------------------------------------------------------------------------------------------------------------");
					}
					else 
					{
						System.out.println("\n  Login Unsuccessful!!"); 
						System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
					} 
					i++;
					break;
				case 2:
					break studentLoginLoop;
				default:
					System.out.print("\nPlease Choose From Given Choice Only");
			}
		}
		

		driver.close();
		}
}



import java.util.*;

class Student
{
	int regNumber;
	String Name;
	String Branch;
	float CGPA;
}


class StudentAdmin
{
	public static void main(String args[])
	{
		Student[] Students = new Student[50];
		int n, numberOfStudents;


		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		numberOfStudents = sc.nextInt();
		n = numberOfStudents;
	
		for(int i=0; i<n; i++)
		{
			Students[i] = new Student();
			System.out.println("For student " + (i+1));
			System.out.print("Enter name : ");
			Students[i].Name = sc.next();
			sc.nextLine();
			System.out.print("Enter registration number : ");
			Students[i].regNumber = sc.nextInt();		
			sc.nextLine();
			System.out.print("Enter branch : ");
			Students[i].Branch = sc.next();
			sc.nextLine();
			System.out.print("Enter CGPA : ");
			Students[i].CGPA = sc.nextFloat();
		}

		
		
		int regNumber;
		System.out.print("\nEnter registration number to be searched : ");
		regNumber = sc.nextInt();
		linearSearch(Students, regNumber, n);

		/*
		bubbleSort(Students);

		binarySearch(Students, regNumber);

		insertionSort(Students); */
	
	}

	public static void linearSearch(Student[] arr, int key, int n)
	{
		boolean found = false;
	
		for(int i=0; i<n; i++)
		{
			if( (arr[i].regNumber == key) && !(found) )
			{
				found = true;
				System.out.print("Found!\nName : " + arr[i].Name + "\nBranch : " + arr[i].Branch + "\nCGPA : " + arr[i].CGPA);
			}
		}
		if(!found)
			System.out.println("No student found with this registration number.");
	}

	public static void bubbleSort(Student[] arr, int n)
	{
		for(int i=0; i<(n-1); i++)
		{
			for(int j=(i+1); j<n; j++)
			{
				
				if(arr[i].regNumber > arr[j].regNumber)
					
		
			
}


		
	

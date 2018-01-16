import java.util.*;


class Duplicate {
	public static void main(String[] args)
	{
		int n, new_len, c, c_pos;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of elements in the array : ");
		n = sc.nextInt();

		int arr[] = new int[n];
		
		
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter element " + (i+1) + " : ");
			arr[i] = sc.nextInt();
		}

		new_len = n;

		for(int i=1; i<n; i++)
		{
			if(arr[i] == arr[i-1])
			{
				flag = true;
				c = arr[i], c_pos = i;
				arr[i] = (i+1 == n) ? arr[i] : arr[i+1];	
				new_len--;
			}	
		}

		n = new_len;
		for(int i=0; i<n; i++)
		{
			System.out.print(arr[i]);
		}

	}
}
			
		 


import java.util.*;


class Duplicate {
	public static void main(String[] args)
	{
		int n, new_len, current, current_pos;
		boolean seen;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array : ");
		n = sc.nextInt();

		int arr[] = new int[n];
		
		
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter element " + (i+1) + " : ");
			arr[i] = sc.nextInt();
		}

		new_len = n;
		current = arr[0];
		current_pos = 0;
		seen = false;
		
		for(int i=1; i<n; i++)
		{
			if(arr[i] == current)
			{
				current = arr[i];
				current_pos = i;
				seen = true;
				new_len--;

			}

			else if(arr[i] != current && (seen))
			{
				arr[current_pos] = arr[i];
				current_pos += 1;
				current = arr[i];
			}

		}

		n = new_len;
		for(int i=0; i<n; i++)
		{
			System.out.print(arr[i]);
		}

	}
}
			
		 


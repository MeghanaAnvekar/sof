import static org.junit.Assert.*;
 
import org.junit.Before;
import org.junit.Test;

public class BinarySearch {
	
	static int size = 26; 
	int array[];
	int zeroArray[];
	static int zero = 0;
	static int[] createArray()
	{
		int[] temp = new int[size];
		int num = -13;
		for(int i = 0; i < size;++i,num ++)
			temp[i] = num;
		
		return temp;
		
	}
	
	static int[] createZeroSizeArray()
	{
		int[] temp = new int[zero];
		return temp;
	}
	@Before
	public void initialize()
	{
		array = createArray();
		zeroArray = createZeroSizeArray();
	}
	
	@Test
	public void findMinusThirteen()
	{
		assertEquals("Searching -13 in array must return index 0",0,binarySearch(array,size,-13));
	}
	
	@Test
	public void findZero()
	{
		assertEquals("Searching 0 in array must return index 13",13,binarySearch(array,size,0));
	}
	
	@Test
	public void findOne()
	{
		assertEquals("Searching 0 in array must return index 14",14,binarySearch(array,size,1));
	}
	
	@Test
	public void findFourteen()
	{
		assertEquals("Searching 12 in array must return index 25",25,binarySearch(array,size,12));
	}
	
	@Test
	public void findNinety()
	{
		assertEquals("Searching 90 in array must return index -1",-1,binarySearch(array,size,90));
	}
	
	@Test
	public void findFiftyThree()
	{
		assertEquals("Searching 53 in array must return index -1",-1,binarySearch(array,size,53));
		
	}
	
	@Test
	public void findMinusFiftyThree()
	{
		assertEquals("Searching -53 in array must return index -1",-1,binarySearch(array,size,-53));
		
	}
	
	@Test
	public void findMinusThirtyTwo()
	{
		assertEquals("Searching -32 in array must return index -1",-1,binarySearch(array,size,-32));
		
	}
	
	@Test
	public void emptyArrayTest()
	{
		assertEquals("Searching -32 in an empty array must return index -1",-1,binarySearch(zeroArray,zero,-32));
	}
	
	int binarySearch(int array[],int size,int x)
	{
		int low = 0, high = size-1,mid = -1;
		int found = 0;
		
		while(low <= high && found == 0)
		{
			mid = (low + high)/2;
			if(array[mid] == x)
				found = 1;
			else if(array[mid] > x)
				  high = mid -1;
			else
				low = mid + 1;
				
		}
		
		if(found == 1)
			return mid;
		else
			return -1;
		
	}
	
	
}

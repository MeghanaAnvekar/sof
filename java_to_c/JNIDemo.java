public class JNIDemo
{

	static
	{
		System.loadLibrary("JNIDemo");
	}

	private native double[] sumAndAverage(int[] numbers);

	public static void main(String args[])
	{
		try
		{
		

		    int[] numbers = {1, 2, 3, 4};
			double[] results = new JNIDemo().sumAndAverage(numbers);
			System.out.println("In Java, the sum is " + results[0]);
			System.out.println("In Java, the average is " + results[1]);
		}
		catch(Exception e)
		{
			System.out.println("Alertt Alert: " + e.getMessage());
		}
	}
}

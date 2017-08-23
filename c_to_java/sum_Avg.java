public class sum_Avg{
	public static void main(String[] args)
	{
		System.out.println("Hello, World");
	}
	public static double sum(double[] input)
	{
		double sum=0;
		int len=input.length;
		for(int i=0;i<len;i++){
			sum+=input[i];
		}
		return sum;
	}
	public static double avg(double[] input)
	{
		double avg, sum=0;
		int len=input.length;
		for(int i=0;i<len;i++){
			sum+=input[i];
		}
		avg=sum/len;
		return avg;
	}
}

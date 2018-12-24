import java.util.*;

class FibonacciSumLastDigit{ 
	private static long fast_fib_sum_last_digit(long num){
		if(num<=1) return num;
		int[] fib = new int[3];
		fib[0] = 0;
		fib[1] = 1;
		long sum=1;
		int i=2;
		while(i<=num){
			fib[i%3] = (fib[(i-1)%3] + fib[(i-2)%3])%10;
			sum+=fib[i%3];
			i++;
		}
		return sum;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
	}
}
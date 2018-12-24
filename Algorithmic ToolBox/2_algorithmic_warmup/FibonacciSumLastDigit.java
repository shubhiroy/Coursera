import java.util.*;

class FibonacciSumLastDigit{ 
	private static long naive_fib_sum_last_digit(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
	
	private static long fast_fib_sum_last_digit(long num){
		if(num<=1) return num;
		int[] fib = new int[3];
		fib[0] = 0;
		fib[1] = 1;
		long sum=1;
		int i=2;
		while(i<=num){
			fib[i%3] = (fib[(i-1)%3] + fib[(i-2)%3])%10;
			sum+=(fib[i%3]);
			sum%=10;
			i++;
		}
		return sum;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int t = sc.nextInt();
		int num = rand.nextInt(t);
		long fast_fib_sum_last_digit_res = fast_fib_sum_last_digit(num);
		long naive_fib_sum_last_digit_res = naive_fib_sum_last_digit(num);
		while(fast_fib_sum_last_digit_res==naive_fib_sum_last_digit_res){
		System.out.println("OK for num = "+num);
			num = rand.nextInt(t);
			fast_fib_sum_last_digit_res = fast_fib_sum_last_digit(num);
			naive_fib_sum_last_digit_res = naive_fib_sum_last_digit(num);
		}
		System.out.println("For num = "+num);
		System.out.println("Answer for fast_fib_sum_last_digit :" + fast_fib_sum_last_digit_res);
		System.out.println("Answer for naive_fib_sum_last_digit :" + naive_fib_sum_last_digit_res);
	}
}
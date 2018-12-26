import java.util.*;

class FibonacciPartialSum{
	private static long naive_fib_partial_sum(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
	private static long fast_fib_partial_sum(int num1,int num2){
		if(num2<1)
			return 0;
		if(num2<2)
			return 1;
		long[] fib = new long[3];
		fib[0]=0;
		fib[1]=1;
		long sum = 0;
		if(num1<2)
			sum=1;
		int i=2;
		while(i<=num2){
			fib[i%3] = fib[(i-1)%3] + fib[(i-2)%3];
			//System.out.println("fib["+i+"]"+fib[i%3]);
			if(i>=num1){
				//System.out.println("fib["+i+"]"+fib[i%3]+" sum "+sum);
				sum+=fib[i%3];
				sum%=10;
			}
			i++;
		}
		return sum;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int t = sc.nextInt();
		int num1 = rand.nextInt(t);
		int num2 = rand.nextInt(t);
		if(num1>num2){
			int temp = num1;
			num1=num2;
			num2=temp;
		}
		long fast_fib_partial_sum_res = fast_fib_partial_sum(num1,num2);
		long naive_fib_partial_sum_res = naive_fib_partial_sum(num1,num2);
		while(fast_fib_partial_sum_res==naive_fib_partial_sum_res){
		System.out.println("OK for num1 = "+num1+"   num2 = "+num2);
			num1 = rand.nextInt(t);
			num2 = rand.nextInt(t);
			if(num1>num2){
				int temp = num1;
				num1=num2;
				num2=temp;
			}
			fast_fib_partial_sum_res = fast_fib_partial_sum(num1,num2);
			naive_fib_partial_sum_res = naive_fib_partial_sum(num1,num2);
		}
		System.out.println("For num1 = "+num1+"    num2 = "+num2);
		System.out.println("Answer for fast_fib_partial_sum :" + fast_fib_partial_sum_res);
		System.out.println("Answer for naive_fib_partial_sum :" + naive_fib_partial_sum_res);
	}
}
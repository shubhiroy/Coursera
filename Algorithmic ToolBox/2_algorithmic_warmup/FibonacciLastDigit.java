import java.util.*;

class FibonacciLastDigit{
	
	private static int naiveFibLastDigit(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
	
	private static int fastFibLastDigit(int n){
		if(n<=1) return n;
		int[] fib = new int[3];
		int size = n+1;
		int i=2;
		fib[0]=0;
		fib[1]=1;
		while(i<size){
			fib[i%3] = (fib[(i-1)%3]+fib[(i-2)%3])%10;
			i++;
		}
		return fib[n%3];
	}
	public static void main(String[] args){
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = rand.nextInt(t);
		while(naiveFibLastDigit(n)==fastFibLastDigit(n)){
			System.out.println("OK for n = "+n);
			n = rand.nextInt(t);
		}
		System.out.println("For n = " + n);
		System.out.println("Answer for fastFibLastDigit :" + fastFibLastDigit(n));
		System.out.println("Answer for naiveFibLastDigit :" + naiveFibLastDigit(n));
		
	}
}
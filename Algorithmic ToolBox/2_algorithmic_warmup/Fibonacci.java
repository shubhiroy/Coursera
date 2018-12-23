//Stress Test implemented on naive and fast method. Input the number and it will continue to test on all the possible test cases between that number and will stop only if the result of naive and fast methods differs. 
//Naive Method
//Time Complexity >= f(n) (where f(n) >= 2^(n/2) for n>=6)
//Fast Method
//Time Complexity : O(n)
//The time complexity becomes O(n^2) when the fibonacci number is too larger as one n for the loop and the second for the addition of the large fibonacci number. 

import java.util.*;

class Fibonacci{
	private static int fastFib(int n){
		if(n<=1) return n;
		int[] fib = new int[3];
		int size = n+1;
		int i = 2;
		fib[0]=0;
		fib[1]=1;
		while(i<size){
			fib[i%3] = fib[(i-1)%3]+fib[(i-2)%3];
			i++;
		}
		return fib[n%3];
	}
	
	private static int naiveFib(int n){
		if (n<=1)
			return n;
		return naiveFib(n-1) + naiveFib(n-2);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int t = sc.nextInt();
		int n = rand.nextInt(t);
		while(fastFib(n)==naiveFib(n)){
			System.out.println("OK for n = "+n);
			n = rand.nextInt(t);
		}
		System.out.println("For n = " + n);
		System.out.println("Answer for fastFib :" + fastFib(n));
		System.out.println("Answer for naiveFib :" + naiveFib(n));
	}
}
//Naive method finds gcd of two nos. by iterating from 1 to max(num1,num2).Time Complexity = O(n)
//Fast method > num1 = num2*q + c. If num2 divides num1 then c is also a multiple of num2.
import  java.util.*;

class GCD{
	private static int naive_gcd(int a, int b) {
		if(b==0) return a;
		int current_gcd = 1;
		for(int d = 2; d <= a && d <= b; ++d) {
		  if (a % d == 0 && b % d == 0) {
			if (d > current_gcd) {
			  current_gcd = d;
			}
		  }
		}	
		return current_gcd;
	}
	
	private static int fast_gcd(int num1,int num2){
		if(num2==0 || num1==num2){
			return num1;
		}
		return fast_gcd(num2,num1%num2);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int t = sc.nextInt();
		int num1 = rand.nextInt(t);
		int num2 = rand.nextInt(t);
		if(num1<num2){
			int temp = num1;
			num1=num2;
			num2=temp;
		}
		while(naive_gcd(num1,num2)==fast_gcd(num1,num2)){
		System.out.println("OK for num1 = "+num1+"   num2 = "+num2);
			num1 = rand.nextInt(t);
			num2 = rand.nextInt(t);
			if(num1<num2){
			int temp = num1;
			num1=num2;
			num2=temp;
		}
		}
		System.out.println("For num1 = "+num1+"    num2 = "+num2);
		System.out.println("Answer for fast_gcd :" + fast_gcd(num1,num2));
		System.out.println("Answer for naive_gcd :" + naive_gcd(num1,num2));
	}
}
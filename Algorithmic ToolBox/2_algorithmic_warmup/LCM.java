//Naive method finds gcd of two nos. by iterating from 1 to num1*num2.Time Complexity = O(n)
//Fast method > No. of steps taken : log(ab)

import java.util.*;
class LCM{

	private static int gcd(int num1,int num2){
		if(num2==0 || num1==num2){
			return num1;
		}
		return gcd(num2,num1%num2);
	}
	private static int fast_lcm(int num1,int num2){
		if(num2==0){
			return num2;
		}
		if(num1%num2==0){
			return num1;
		}
		return (num1*num2)/gcd(num1,num2);
	}

	private static long naive_lcm(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
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
		while(naive_lcm(num1,num2)==fast_lcm(num1,num2)){
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
		System.out.println("Answer for fast_lcm :" + fast_lcm(num1,num2));
		System.out.println("Answer for naive_lcm :" + naive_lcm(num1,num2));
	}
}
// Time Complexity : O(1)
// Space Complexity : O(1)
import java.util.*;

class Sum{
	public int getSum(int num1,int num2){
		return (num1+num2);
	}
}

class ABPlus{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Sum obj = new Sum();
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int sum = obj.getSum(num1,num2);
		System.out.println(sum);
	}
}
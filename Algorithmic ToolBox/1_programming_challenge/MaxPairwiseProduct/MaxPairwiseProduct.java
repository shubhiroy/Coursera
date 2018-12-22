// Time Complexity of this code depends on no. of comparisons.
// No. of comparisons to find first max = n-1
// No. of comparisons to find next max = log(base2)n
// Total no. of comparisons = n + log(base2)n - 1
// Space Complexity = O(n)
import java.util.*;


class MaxPairwiseProduct{
	public static int max(int num1,int num2){
		if(num1>num2)
			return num1;
		else
			return num2;
	}
	
	public static void buildTourn(int[] tournArr){
		int n = tournArr.length;
		for(int i=n-2;i>=0;i-=2){
			tournArr[i/2]=max(tournArr[i],tournArr[i+1]);
		}
	}
	
	public static void nextMax(int[] tournArr){
		int n = tournArr.length;
		int i;
		for(i=0;i<n;){
			tournArr[i]=-1;
			if(2*i+2>=n){
				break;
			}
			if(tournArr[2*i+1]>tournArr[2*i+2]){
				i=2*i+1;
			}else{
				i=2*i+2;
			}
		}
		/*if((i+1)>=n){
			i-=1;
		}*/
		while(i>0){
			if(i%2!=0){
				tournArr[i/2] = max(tournArr[i],tournArr[i+1]);
			}else{
				tournArr[i/2] = max(tournArr[i],tournArr[i-1]);
			}
			i/=2;
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tournArr = new int[2*n-1];
		for(int i=n-1;i<2*n-1;i++){
			tournArr[i]=sc.nextInt();
		}
		//System.out.println(tournArr.length);
		buildTourn(tournArr);
		int max1 = tournArr[0];
		nextMax(tournArr);
		buildTourn(tournArr);
		int max2 = tournArr[0];
		System.out.println(max1*max2);
	}
}

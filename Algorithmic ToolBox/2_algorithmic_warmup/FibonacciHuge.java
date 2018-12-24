import java.util.*;

class FibonnaciHuge{
	private static long checkPeriod(long num){
		if(num<=1) return num;
		long[] fib = new long[3];
		fib[0]=0;
		fib[1]=1;
		int i=2;
		while(true){
			fib[i%3]=(fib[(i-1)%3]+fib[(i-2)%3])%num;
			//System.out.println(i);
			if(fib[i%3]==1 && fib[(i-1)%3]==0){
				return i-1;
			}
			i++;
		}
	}
	private static long fast_fibHuge(long num,long mod){
		long numAfterPeriod = num%checkPeriod(mod);
		if(numAfterPeriod<=1){
			return numAfterPeriod;
		}
		long[] fib = new long[3];
		fib[0]=0;
		fib[1]=1;
		int i =2;
		while(i<=numAfterPeriod){
			fib[i%3] = (fib[(i-1)%3] + fib[(i-2)%3])%mod;
			i++;
		}
		return fib[(i-1)%3];
	}
	
	private static long naive_fibHuge(long n, long m) {
        if (n < 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long res = current % m;
		return res;
    }
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int t = sc.nextInt();
		long num = rand.nextInt(t);
		long mod = rand.nextInt(t);
		if(mod==0) mod++;
		long naive_fibHuge_res = naive_fibHuge(num,mod);
		long fast_fibHuge_res = fast_fibHuge(num,mod);
		while(naive_fibHuge_res==fast_fibHuge_res){
		System.out.println("OK for num = "+num+"   mod = "+mod);
			num = rand.nextInt(t);
			mod = rand.nextInt(t);
			if(mod==0) mod++;
			naive_fibHuge_res = naive_fibHuge(num,mod);
			fast_fibHuge_res = fast_fibHuge(num,mod);
		}
		System.out.println("For num = "+num+"    mod = "+mod);
		System.out.println("Answer for fast_fibHuge :" + fast_fibHuge_res);
		System.out.println("Answer for naive_fibHuge :" + naive_fibHuge_res);
	}
}
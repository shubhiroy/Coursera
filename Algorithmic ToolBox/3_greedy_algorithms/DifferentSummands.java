import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int c = 1;
		while(c<=n){
			summands.add(c);
			n-=c;
			c++;
		}
		if(n!=0){
			int len = summands.size()-1;
			int last = summands.get(len);
			summands.set(len,(last+n));
		}
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}


import java.util.Scanner;


public class FractionalKnapsack {
	private static int get_max_weight(double[] value_unit_weight){
		double max = 0;
		int max_i=0;
		for(int i = 0;i<value_unit_weight.length;i++){
			if(max<value_unit_weight[i]){
				max=value_unit_weight[i];
				max_i=i;
			}
		}
		return max_i;
	} 
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
		double[] value_unit_weight = new double[values.length];
		for(int i=0;i<values.length;i++){
			value_unit_weight[i] = (double)values[i]/(double)weights[i];
		}
		while(capacity>0){
			int i = get_max_weight(value_unit_weight);
			double val = value_unit_weight[i];
			value_unit_weight[i]=0;
			int taken = java.lang.Math.min(weights[i],capacity);
			capacity-=taken;
			value += (taken*val);
		}
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 

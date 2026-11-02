import java.util.Scanner;

public class knapsack{
    public static void main(String[] args){
        System.out.println("enter the number of items");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];
        System.out.println("enter the weights and there values");
        for(int i = 0; i<n ; i++){
            System.out.println("enter the weight");
            weights[i] = sc.nextInt();
            System.out.println("enter its value");
            values[i] = sc.nextInt();   
        }

        System.out.println("enter the knapsack capacity");
        int W = sc.nextInt();
        

        int[][] dp = new int[n+1][W+1];

        for(int i=1; i<=n ; i++){
            for(int w=0; w<=W; w++){
                if(weights[i-1]<= w){
                    dp[i][w] = Math.max(dp[i - 1][w],values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                }else{
                     dp[i][w] = dp[i - 1][w];
                    
                }
                
            }
        }

        System.out.println("maximum profit is"+dp[n][W]);

        System.out.println("the weights are");

        int w = W;
        for(int i = n; i>0; i--){
            if(dp[i][w]!=dp[i-1][w]){
                System.out.print(i +" ");
                w -= weights[i - 1];
            }
        }
        
    }
}










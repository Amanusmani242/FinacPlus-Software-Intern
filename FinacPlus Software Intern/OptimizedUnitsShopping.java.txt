import java.util.*;
public class OptimizedUnitsShopping {

    public static void main(String[] args) {
        // Available units: 1, 2, 5, 10, 20, 50
        int[] units = {1, 2, 5, 10, 20, 50};
        int maxValue = 99;
        
        int[] dp = new int[maxValue + 1];
        
        // Initialize dp array
        for (int i = 1; i <= maxValue; i++) {
            dp[i] = Integer.MAX_VALUE; 
        }
        dp[0] = 0; 
        
     
        for (int i = 1; i <= maxValue; i++) {
            for (int unit : units) {
                if (i - unit >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - unit] + 1);
                }
            }
        }
        
      
        int totalUnits = 0;
        for (int i = 1; i <= maxValue; i++) {
            totalUnits += dp[i];
        }
        
       
        double averageUnits = (double) totalUnits / maxValue;
        
      
        System.out.println("Total units used for numbers 1 to 99: " + totalUnits);
        System.out.println("Average number of units used: " + averageUnits);
        
      
        System.out.print("For 98, units used: ");
        printUnits(dp, 98, units);
        System.out.print("For 99, units used: ");
        printUnits(dp, 99, units);
    }


    private static void printUnits(int[] dp, int value, int[] units) {
  
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            for (int unit : units) {
                if (value - unit >= 0 && dp[value] == dp[value - unit] + 1) {
                    result.append(unit).append(" ");
                    value -= unit;
                    break;
                }
            }
        }
        System.out.println(result.toString().trim());
    }
}

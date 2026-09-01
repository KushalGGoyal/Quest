class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int first=prices[0];
        ///sabse pehle chhote wale number tak pahnchna hai fir comparison 
        for(int i=1;i<prices.length;i++){
            if(prices[i]<first){
                first=prices[i];


            }
             profit = Math.max(profit, prices[i] - first);
        }
        
        
    
      return profit ; }
}
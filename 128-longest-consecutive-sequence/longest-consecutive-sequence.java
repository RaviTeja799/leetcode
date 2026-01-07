class Solution {
    public int longestConsecutive(int[] nums) {

      HashSet<Integer> set=new HashSet<>();
      for(int ele:nums){
        set.add(ele);
      } 

      int maxStreak=0;
      for(int ele:set){ 
         if(!set.contains(ele-1)){
            int currele=ele;
            int currrentStreak=1;
         while(set.contains(currele+1)){
            currele++;
            currrentStreak++;
         }
        maxStreak=Math.max(currrentStreak,maxStreak);
         }
      
      }
      return maxStreak;
    }
}
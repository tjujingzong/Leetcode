import java.util.Arrays;

class Solution {
  public int smallestDivisor(int[] nums, int threshold) {
    Arrays.sort(nums);
    int left=1;
    int right=nums[nums.length-1];
    while(left<=right){
      int mid=(left+right)/2;
      int sum=0;
      for(int i=0;i<nums.length;i++){
        sum+=Math.ceil((double)nums[i]/mid);
      }
      if(sum>threshold){
        left=mid+1;
      }
      else right=mid-1;
    }
    return left;
  }
}
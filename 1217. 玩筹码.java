class Solution {
  public int minCostToMoveChips(int[] position) {
    int ans1=0;
    int ans2=0;
    for(int i=0;i<position.length;i++){
      if(position[i]%2==0) ans1++;
      else ans2++;
    }
    return Math.min(ans1, ans2);
  }
}
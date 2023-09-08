class Solution {
  public String smallestNumber(String pattern) {
        int n=pattern.length();

        int[] arr = new int[n+1];
        //直接先按升序排列好,再来处理。比如n=5,那就先创建一个{1,2,3,4,5,6}
        for(int i=0;i<n+1;i++){
            arr[i]=i+1;
        }

        for(int i=0;i<n;i++){
            if(pattern.charAt(i)=='I')
                continue;
            else{
                for(int j=i;j>=0 && pattern.charAt(j)=='D';j--){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++)
            sb.append(arr[i]);
        return sb.toString();
  }
}
public int findLast (int[] x, int y){
  //Effects: If x==null throwNullPointerException
  //else return the index of the last elementl/ in x that equals y.
  // If no such element exists, return -1
  for (int i=x.length-1; i > 0; i--){
    if (x[i] == y){
      return i;
    }
  }
  return -1;
}
  // test: x=[2,3,5]; y=2 Expected= 0

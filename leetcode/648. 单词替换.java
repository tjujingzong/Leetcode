class Solution {
  public String replaceWords(List<String> dictionary, String sentence) {
    String ans="";
    String[] words=sentence.split(" ");
    for(int i=0;i<words.length;i++){
      for(String e:dictionary){
        if(words[i].startsWith(e)) words[i]=e;
      }
      ans+=words[i]+" ";
    }
    return ans.substring(0, ans.length()-1);
  }
}
import java.util.HashMap;
import java.util.TreeMap;

class FoodRatings {
  TreeMap<String, String> cuiMap;
  TreeMap<String, Integer> scMap;
  TreeMap<String, String> maxsocremMap;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    cuiMap = new TreeMap<>();
    scMap = new TreeMap<>();
    maxsocremMap = new TreeMap<>();
    int n = foods.length;
    for (int i = 0; i < n; i++) {
      scMap.put(foods[i], ratings[i]);
      cuiMap.put(foods[i], cuisines[i]);
      if (maxsocremMap.containsKey(cuisines[i])) {
        int nowmax = scMap.get(maxsocremMap.get(cuisines[i]));
        if (nowmax < ratings[i])
          maxsocremMap.put(cuisines[i], foods[i]);
        else if (nowmax == ratings[i] && maxsocremMap.get(cuisines[i]).compareTo(foods[i]) > 0) {
          maxsocremMap.put(cuisines[i], foods[i]);
        }
      } else {
        maxsocremMap.put(cuisines[i], foods[i]);
      }
    }
  }

  public void changeRating(String food, int newRating) {
    String cuiString = cuiMap.get(food);
    String nowhiString = maxsocremMap.get(cuiString);
    int nowhisc = scMap.get(nowhiString);
    scMap.put(food, newRating);
    if (food.equals(nowhiString)) {
      if (newRating < nowhisc) {
        for (String fod : cuiMap.keySet()) {
          if (cuiMap.get(fod).equals(cuiString)) {
            String lafod = maxsocremMap.get(cuiString);
            if (scMap.get(fod) > scMap.get(lafod)) {
              maxsocremMap.put(cuiString, fod);
            }
          }
        }
      }
    } else {
      if (nowhisc < newRating) {
        maxsocremMap.put(cuiString, food);
      } else if (nowhisc == newRating) {
        if (nowhiString.compareTo(food) > 0)
          maxsocremMap.put(cuiString, food);
      }
    }
  }

  public String highestRated(String cuisine) {
    return maxsocremMap.get(cuisine);
  }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
class Solution {
  public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
    int ans = 0;
    for (int i = 0; i < energy.length; i++) {
      if (initialEnergy <= energy[i]) {
        ans += energy[i] - initialEnergy + 1;
        initialEnergy = energy[i] + 1;
      }
      if (initialExperience <= experience[i]) {
        ans += experience[i] - initialExperience + 1;
        initialExperience = experience[i] + 1;
      }
      if (initialEnergy > energy[i] && initialExperience > experience[i]) {
        initialExperience += experience[i];
        initialEnergy -= energy[i];
      }
    }
    return ans;
  }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int windowSize = s1.length();

        for (int l = 0; l <= s2.length() - windowSize; l++) {

            int[] countS2 = new int[26];

            for (int i = l; i < l + windowSize; i++) {
                countS2[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(count, countS2)) {
                return true;
            }
        }

        return false;
    }
}
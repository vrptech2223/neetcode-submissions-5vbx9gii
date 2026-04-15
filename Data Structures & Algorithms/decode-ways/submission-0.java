class Solution {

    private Set<String> ss = new HashSet<>();
    private Integer[] memo;

    public int numDecodings(String s) {
        for (int i = 1; i <= 26; i++) {
            ss.add(String.valueOf(i));
        }

        memo = new Integer[s.length()];
        return dfs(s, 0);
    }

    public int dfs(String s, int i) {

        // ✅ reached end → valid decoding
        if (i == s.length()) {
            return 1;
        }

        // ✅ memo check
        if (memo[i] != null) {
            return memo[i];
        }

        int count = 0;

        // ✅ try 1 digit
        String one = s.substring(i, i + 1);
        if (ss.contains(one)) {
            count += dfs(s, i + 1);
        }

        // ✅ try 2 digits
        if (i + 1 < s.length()) {
            String two = s.substring(i, i + 2);
            if (ss.contains(two)) {
                count += dfs(s, i + 2);
            }
        }

        return memo[i] = count;
    }
}

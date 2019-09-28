public class LevenshteinDistance {

    public static int findMinDistance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= a.length(); i++) {
            char c1 = a.charAt(i-1);
            for (int j = 1; j <= b.length(); j++) {
                char c2 = b.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = dp[i][j-1] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    dp[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}

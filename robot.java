public class robot {
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int[][] prev = new int[m + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            int[][] cur = new int[m + 1][m + 1];
            for (int j1 = 1; j1 <= m; j1++) {
                for (int j2 = 1; j2 <= m; j2++) {

                    int ans = 0;

                    // Inner nested loops to try out 9 options
                    for (int d1 = -1; d1 <= 1; d1++) {
                        if (j1 + d1 == m + 1)
                            continue;
                        for (int d2 = -1; d2 <= 1; d2++) {
                            if (j2 + d2 == m + 1)
                                continue;

                            ans = Math.max(ans, prev[j1 + d1][j2 + d2]);
                        }
                    }
                    ans += grid[i][j2 - 1];
                    if (j1 != j2) // since they are different both values are addes
                        ans += grid[i][j1 - 1];

                    cur[j1][j2] = ans;
                }
            }

            for (int a = 0; a < m; a++) {
                prev[a] = cur[a];
            }
        }

        return prev[1][m];

    }
    public static void main(String[] args) {
        int[][] a={{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        robot r=new robot();
        int ans=r.solve(a.length, a[0].length, a);
        System.out.println(ans);
    }
}

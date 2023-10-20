import java.util.ArrayList;
import java.util.List;

public class print_lcs {

    int[][] ss;
    List<String> ans;

    public List<String> all_longest_common_subsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        ss = new int[n + 1][m + 1];
        ans = new ArrayList<>();
        subsequence(s, t, n, m);

        /* for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                System.out.print(ss[i][j] + " ");
            System.out.println();
        } */
        char[] res = new char[ss[n][m] + 1];
        print(s, t, 1, 1, 0, n, m, ss[n][m], res);
        return ans;
    }

    void subsequence(String sr, String sc, int n, int m) {
        for (int i = 1; i <= n; i++) {
            char a = sr.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char b = sc.charAt(j - 1);
                if (a != b)
                    ss[i][j] = Math.max(ss[i - 1][j], ss[i][j - 1]);
                else
                    ss[i][j] = 1 + ss[i - 1][j - 1];
            }
        }
    }

    void print(String s, String t, int i1, int i2, int curr, int n, int m, int lcs, char[] res) {

        if (lcs == curr) {
            res[curr] = '\0';
            ans.add(new String(res));
            return;
        }
        if (i1 == n + 1 || i2 == m + 1)
            return;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            boolean done = false;
            for (int i = i1 ; i <= n; i++) {
                char a = s.charAt(i - 1);
                if (a == ch) {
                    for (int j = i2 ; j <= m; j++) {
                        char b = t.charAt(j - 1);
                        int s_s=ss[i][j];
                        if (a == b && ss[i][j] == curr + 1) {
                            res[curr] = a;
                            print(s, t, i + 1, j + 1, curr + 1, n, m, lcs, res);
                            done = true;
                            break;

                        }

                    }
                }
                if (done)
                    break;
            }
        }
    }
    public static void main(String[] args) {
        String a="abaaa";
        String b="baabaca";
        print_lcs p=new print_lcs();
        List<String>ans=p.all_longest_common_subsequences(a,b);
        System.out.println(ans);
    }
}
